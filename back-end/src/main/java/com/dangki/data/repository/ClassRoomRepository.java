package com.dangki.data.repository;

import com.dangki.data.entities.ClassRoom;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Spring Data  repository for the ClassRoom entity.
 */
@Repository
public interface ClassRoomRepository extends JpaRepository<ClassRoom, Long> {

    @Query("select c from ClassRoom c where c.subject.id=:id")
    List<ClassRoom> findAllBySubjectId(@Param("id") Long id);
}
