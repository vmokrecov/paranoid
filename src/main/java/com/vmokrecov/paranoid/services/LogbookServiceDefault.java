package com.vmokrecov.paranoid.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vmokrecov.paranoid.configuration.LogbookAutoConfiguration;
import com.vmokrecov.paranoid.configuration.LogbookProperties;
import com.vmokrecov.paranoid.domain.entity.Logbook;
import com.vmokrecov.paranoid.repositories.LogbookRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Business logic of working with logbook
 */
@Slf4j
@Service
@AllArgsConstructor
@ConditionalOnMissingBean(value = LogbookAutoConfiguration.class)
public class LogbookServiceDefault implements LogbookService {

    private final LogbookRepository repository;
    private final LogbookProperties logbookProperties;

    @Override
    public void logRequest(HttpServletRequest httpServletRequest, Object body) throws JsonProcessingException {
        if (!logbookProperties.isLogbook()) return;

        Logbook logbook = Logbook.builder()
                .eventName("REQUEST")
                .method(httpServletRequest.getMethod())
                .path(httpServletRequest.getRequestURI())
                .headers(new ObjectMapper().writeValueAsString(buildHeadersMap(httpServletRequest)))
                .param(buildParametersMap(httpServletRequest).toString())
                .system(httpServletRequest.getRemoteHost())
                .host(httpServletRequest.getRemoteAddr())
                .build();
        Optional.ofNullable(body).ifPresent(requestBody -> logbook.setResult(requestBody.toString()));
        repository.save(logbook);
    }

    @Override
    public void logResponse(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object body)
            throws JsonProcessingException {
        if (!logbookProperties.isLogbook()) return;

        Logbook logbook = Logbook.builder()
                .eventName("RESPONSE")
                .method(httpServletRequest.getMethod())
                .path(httpServletRequest.getRequestURI())
                .headers(new ObjectMapper().writeValueAsString(buildHeadersMap(httpServletResponse)))
                .param(buildParametersMap(httpServletRequest).toString())
                .system(httpServletRequest.getRemoteHost())
                .host(httpServletRequest.getRemoteAddr())
                .result(body.toString())
                .build();
        repository.save(logbook);
    }

    private Map<String, String> buildParametersMap(HttpServletRequest request) {
        Map<String, String> resultMap = new HashMap<>();
        Enumeration<String> parameterNames = request.getParameterNames();

        while (parameterNames.hasMoreElements()) {
            String key = parameterNames.nextElement();
            String value = request.getParameter(key);
            resultMap.put(key, value);
        }

        return resultMap;
    }

    private Map<String, String> buildHeadersMap(HttpServletRequest request) {
        Map<String, String> map = new HashMap<>();

        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String key = headerNames.nextElement();
            String value = request.getHeader(key);
            map.put(key, value);
        }

        return map;
    }

    private Map<String, String> buildHeadersMap(HttpServletResponse response) {
        Map<String, String> map = new HashMap<>();

        Collection<String> headerNames = response.getHeaderNames();
        for (String header : headerNames) {
            map.put(header, response.getHeader(header));
        }

        return map;
    }
}
