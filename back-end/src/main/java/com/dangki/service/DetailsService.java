package com.dangki.service;

import com.dangki.data.dto.DetailsDto;
import com.dangki.data.entities.Details;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link Details}.
 */
public interface DetailsService {

    /**
     * add a detail.
     *
     * @param detail the list to save.
     * @return the persisted entity.
     */
    DetailsDto add(DetailsDto detail);

    /**
     * add details.
     *
     * @param details the list to save.
     * @return the persisted entity.
     */
    List<DetailsDto> add(List<DetailsDto> details);


    /**
     * Save a details.
     *
     * @param details the entity to save.
     * @return the persisted entity.
     */
    Details update(Details details);
    /**
     * Get all the details.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<Details> findAll(Pageable pageable);

    /**
     * Get all the details with eager load of many-to-many relationships.
     *
     * @return the list of entities.
     */
    Page<Details> findAllWithEagerRelationships(Pageable pageable);


    /**
     * Get the "id" details.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<Details> findOne(Long id);

    /**
     * Delete the "id" details.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
