package com.dangki.prerentation.controller.admin;

import com.dangki.data.entities.Room;
import com.dangki.service.RoomService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing {@link Room}.
 */
@RestController
@RequestMapping("/api")
public class RoomResource {

    private final Logger log = LoggerFactory.getLogger(RoomResource.class);

    private final RoomService roomService;

    public RoomResource(RoomService roomService) {
        this.roomService = roomService;
    }

    /**
     * {@code POST  /rooms} : Create a new room.
     *
     * @param rooms the room to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new room, or with status {@code 400 (Bad Request)} if the room has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/rooms")
    public ResponseEntity<List<Room>> createRoom(@Valid @RequestBody List<Room> rooms) throws URISyntaxException {
        log.debug("REST request to save Room : {}", rooms);
        List<Room> result = roomService.add(rooms);
        return ResponseEntity.ok().body(result);
    }

    /**
     * {@code PUT  /rooms} : Updates an existing room.
     *
     * @param room the room to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated room,
     * or with status {@code 400 (Bad Request)} if the room is not valid,
     * or with status {@code 500 (Internal Server Error)} if the room couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/rooms")
    public ResponseEntity<Room> updateRoom(@Valid @RequestBody Room room) throws URISyntaxException {
        log.debug("REST request to update Room : {}", room);
        Room result = roomService.update(room);
        return ResponseEntity.ok()
            .body(result);
    }

    /**
     * {@code GET  /rooms} : get all the rooms.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of rooms in body.
     */
    @GetMapping("/rooms")
    public ResponseEntity<List<Room>> getAllRooms(Pageable pageable) {
        log.debug("REST request to get a page of Rooms");
        Page<Room> page = roomService.findAll(pageable);
        return ResponseEntity.ok().body(page.getContent());
    }

    /**
     * {@code GET  /rooms/:id} : get the "id" room.
     *
     * @param id the id of the room to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the room, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/rooms/{id}")
    public ResponseEntity<Room> getRoom(@PathVariable Long id) {
        log.debug("REST request to get Room : {}", id);
        Optional<Room> room = roomService.findOne(id);
        return ResponseEntity.ok(room.get());
    }

    /**
     * {@code DELETE  /rooms/:id} : delete the "id" room.
     *
     * @param id the id of the room to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/rooms/{id}")
    public void deleteRoom(@PathVariable Long id) {
        log.debug("REST request to delete Room : {}", id);
        roomService.delete(id);
    }
}
