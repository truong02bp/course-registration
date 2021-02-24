package com.dangki.data.repository;

import com.dangki.data.entities.Week;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the Week entity.
 */
@SuppressWarnings("unused")
@Repository
public interface WeekRepository extends JpaRepository<Week, Long> {
    Week findByName(Integer name);
}
