package com.vmokrecov.paranoid.configuration;

import lombok.Data;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * POJO log settings
 */
@Data
@Configuration
@ConfigurationProperties("paranoid")
@ConditionalOnMissingBean(value = LogbookAutoConfiguration.class)
public class LogbookProperties {

    /**
     * Log Enable/Disable Flag
     */
    private boolean logbook;
}
