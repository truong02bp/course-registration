package com.dangki.service;

import com.dangki.data.entities.Room;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link Room}.
 */
public interface RoomService {

    /**
     * Add a list room.
     *
     * @param rooms the entity to save.
     * @return the persisted entity.
     */
    List<Room> add(List<Room> rooms);

    /**
     * update a room.
     *
     * @param room the entity to save.
     * @return the persisted entity.
     */
    Room update(Room room);

    /**
     * Get all the rooms.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<Room> findAll(Pageable pageable);


    /**
     * Get the "id" room.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<Room> findOne(Long id);

    /**
     * Delete the "id" room.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
