package com.vmokrecov.paranoid.configuration;

import com.vmokrecov.paranoid.services.LogbookService;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.web.servlet.DispatcherType;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Interceptor for log requests and responses
 */
@Configuration
@AllArgsConstructor
@ConditionalOnMissingBean(value = LogbookAutoConfiguration.class)
public class LogbookInterceptor implements HandlerInterceptor {

    private final LogbookService logbookService;

    @Override
    @SneakyThrows
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        if (DispatcherType.REQUEST.name().equals(request.getDispatcherType().name()) &&
                (request.getMethod().equals(HttpMethod.GET.name())
                        || request.getMethod().equals(HttpMethod.DELETE.name())
                )) {
            logbookService.logRequest(request, null);
        }
        return true;
    }
}
