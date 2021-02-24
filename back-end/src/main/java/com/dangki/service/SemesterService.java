package com.dangki.service;

import com.dangki.data.entities.Semester;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link Semester}.
 */
public interface SemesterService {

    /**
     * Save a semester.
     *
     * @param semester the entity to save.
     * @return the persisted entity.
     */
    Semester save(Semester semester);

    /**
     * Get all the semesters.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<Semester> findAll(Pageable pageable);


    /**
     * Get the "id" semester.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<Semester> findOne(Long id);

    /**
     * Delete the "id" semester.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
