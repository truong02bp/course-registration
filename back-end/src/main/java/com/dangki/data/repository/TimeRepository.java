package com.dangki.data.repository;

import com.dangki.data.entities.Time;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the Time entity.
 */
@SuppressWarnings("unused")
@Repository
public interface TimeRepository extends JpaRepository<Time, Long> {
    Time findByNameAndLesson(String name, Integer lesson);
}
