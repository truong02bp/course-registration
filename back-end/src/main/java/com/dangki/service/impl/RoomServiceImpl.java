package com.dangki.service.impl;

import com.dangki.data.entities.Room;
import com.dangki.data.repository.RoomRepository;
import com.dangki.service.RoomService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Service Implementation for managing {@link Room}.
 */
@Service
@Transactional
public class RoomServiceImpl implements RoomService {

    private final Logger log = LoggerFactory.getLogger(RoomServiceImpl.class);

    private final RoomRepository roomRepository;

    public RoomServiceImpl(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @Override
    public Room update(Room room) {
        log.debug("Request to save Room : {}", room);
        return roomRepository.save(room);
    }

    @Override
    public List<Room> add(List<Room> rooms) {
        List<Room> result = new ArrayList<>();
        for (Room room : rooms) {
            if (roomRepository.findByName(room.getName()) == null)
                result.add(roomRepository.save(room));
        }
        return result;
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Room> findAll(Pageable pageable) {
        log.debug("Request to get all Rooms");
        return roomRepository.findAll(pageable);
    }


    @Override
    @Transactional(readOnly = true)
    public Optional<Room> findOne(Long id) {
        log.debug("Request to get Room : {}", id);
        return roomRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete Room : {}", id);
        roomRepository.deleteById(id);
    }
}
