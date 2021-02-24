package com.dangki.data.repository;

import com.dangki.data.entities.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the Room entity.
 */
@SuppressWarnings("unused")
@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
    Room findByName(String name);
}
