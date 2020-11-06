package com.vmokrecov.paranoid.services;

import com.fasterxml.jackson.core.JsonProcessingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Business logic of working with logbook
 */
public interface LogbookService {

    void logRequest(HttpServletRequest httpServletRequest, Object body) throws JsonProcessingException;

    void logResponse(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object body)
            throws JsonProcessingException;
}
