package com.vmokrecov.paranoid.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Entity that describes the logbook
 */
@Data
@Builder
@Table(name = "logbook")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Logbook extends BaseEntity {

    /**
     * Event name
     */
    private String eventName;

    /**
     * Operation method
     */
    private String method;

    /**
     * Method path
     */
    private String path;

    /**
     * Headers
     */
    @Column(name = "headers", length = 2000)
    private String headers;

    /**
     * Params
     */
    @Column(name = "param", length = 2000)
    private String param;

    /**
     * Event source
     */
    private String system;

    /**
     * Host information (IP address or host name)
     */
    private String host;

    /**
     * Result
     */
    @Column(name = "result", columnDefinition = "TEXT")
    private String result;
}
