package com.vmokrecov.paranoid.repositories;

import com.vmokrecov.paranoid.domain.entity.Logbook;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Logbook repository
 */
public interface LogbookRepository extends JpaRepository<Logbook, Long> {

}
