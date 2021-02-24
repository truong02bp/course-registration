package com.dangki.service;

import com.dangki.data.dto.TimeDto;
import com.dangki.data.entities.Time;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link Time}.
 */
public interface TimeService {

    /**
     * add a time.
     *
     * @param timeDtos to save.
     * @return the persisted entity.
     */
    List<TimeDto> add(List<TimeDto> timeDtos);

    /**
     * update a time.
     *
     * @param timeDto to save.
     * @return the persisted entity.
     */
     TimeDto update(Time time);
    /**
     * Get all the times.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<Time> findAll(Pageable pageable);


    /**
     * Get the "id" time.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<Time> findOne(Long id);

    /**
     * Delete the "id" time.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
