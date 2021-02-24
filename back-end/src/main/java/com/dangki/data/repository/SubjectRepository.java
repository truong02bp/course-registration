package com.dangki.data.repository;

import com.dangki.data.entities.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the Subject entity.
 */
@SuppressWarnings("unused")
@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {
    Subject findByName(String name);
}
