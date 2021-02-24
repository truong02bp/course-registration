package com.dangki.data.repository;

import com.dangki.data.entities.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the Professor entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long> {
    Professor findByName(String name);
}
