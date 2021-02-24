package com.dangki.data.repository;

import com.dangki.data.entities.Semester;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the Semester entity.
 */
@SuppressWarnings("unused")
@Repository
public interface SemesterRepository extends JpaRepository<Semester, Long> {
}
