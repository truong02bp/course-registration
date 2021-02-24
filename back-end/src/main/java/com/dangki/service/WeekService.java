package com.dangki.service;

import com.dangki.data.entities.Week;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link Week}.
 */
public interface WeekService {

    /**
     * Save a week.
     *
     * @param week the entity to save.
     * @return the persisted entity.
     */
    Week save(Week week);

    /**
     * Get all the weeks.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<Week> findAll(Pageable pageable);


    /**
     * Get the "id" week.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<Week> findOne(Long id);

    /**
     * Delete the "id" week.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
