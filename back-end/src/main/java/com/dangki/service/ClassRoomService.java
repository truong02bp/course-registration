package com.dangki.service;

import com.dangki.data.dto.ClassRoomDto;
import com.dangki.data.dto.UserDto;
import com.dangki.data.entities.ClassRoom;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link ClassRoom}.
 */
public interface ClassRoomService {

    /**
     * add a classRoom.
     *
     * @param classRooms the entity to save.
     * @return the persisted entity.
     */
    List<ClassRoomDto> add(List<ClassRoomDto> classRooms);

    /**
     * update a classRoom.
     *
     * @param classRoom the entity to save.
     * @return the persisted entity.
     */
    ClassRoom update(ClassRoom classRoom);

    ClassRoomDto findById(Long id);

    /**
     * Get all the classRooms.
     *
     * @param id of subject
     * @return the list of entities.
     */
    List<ClassRoomDto> findAllBySubjectId(Long id);

    /**
     * Get all the classRooms with eager load of many-to-many relationships.
     *
     * @return the list of entities.
     */


    /**
     * Delete the "id" classRoom.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
