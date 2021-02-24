package com.dangki.data.repository;

import com.dangki.data.entities.SubjectSemesterUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the SubjectSemesterUser entity.
 */
@SuppressWarnings("unused")
@Repository
public interface SubjectSemesterUserRepository extends JpaRepository<SubjectSemesterUser, Long> {

}
