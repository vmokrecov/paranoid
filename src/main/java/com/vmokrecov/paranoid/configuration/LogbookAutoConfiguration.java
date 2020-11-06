package com.vmokrecov.paranoid.configuration;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Auto configuration
 */
@Configuration
@EntityScan("com.vmokrecov.paranoid.*")
@EnableJpaRepositories("com.vmokrecov.paranoid.*")
@ComponentScan(basePackages = {"com.vmokrecov.paranoid.*"})
@ConditionalOnProperty(prefix = "paranoid", name = "logbook", matchIfMissing = true)
public class LogbookAutoConfiguration {

}
