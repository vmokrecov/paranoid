package com.vmokrecov.paranoid.configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Adding LogbookInterceptor to InterceptorRegistry
 */
@Configuration
@RequiredArgsConstructor
@ConditionalOnMissingBean(value = LogbookAutoConfiguration.class)
public class LogbookInterceptorConfiguration implements WebMvcConfigurer {

    private final LogbookInterceptor logbookInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(logbookInterceptor);
    }
}
