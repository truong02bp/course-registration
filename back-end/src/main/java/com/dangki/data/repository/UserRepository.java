package com.dangki.data.repository;

import com.dangki.data.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {
    @Query(value = "select * from users as u where BINARY u.username=:username ",nativeQuery = true)
    User findByUsername(@Param("username") String username);

    @Query(value = "select * from users as u , class_room as c , user_class_room as t\n" +
            "where u.id = t.user_id and c.id = t.class_room_id and c.id=:id",nativeQuery = true)
    List<User> findAllByClassRoomId(@Param("id") Long id);
}
