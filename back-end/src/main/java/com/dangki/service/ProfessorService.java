package com.dangki.service;

import com.dangki.data.entities.Professor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link Professor}.
 */
public interface ProfessorService {

    /**
     * add a professor.
     *
     * @param professors the entity to save.
     * @return the persisted entity.
     */
    List<Professor> add(List<Professor> professors);
    /**
     * update a professor.
     *
     * @param professor the entity to save.
     * @return the persisted entity.
     */
    Professor update(Professor professor);

    /**
     * Get all the professors.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<Professor> findAll(Pageable pageable);


    /**
     * Get the "id" professor.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<Professor> findOne(Long id);

    /**
     * Delete the "id" professor.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
