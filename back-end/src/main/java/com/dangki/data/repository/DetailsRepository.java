package com.dangki.data.repository;

import com.dangki.data.entities.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
 * Spring Data  repository for the Details entity.
 */
@Repository
public interface DetailsRepository extends JpaRepository<Details, Long> {

    @Query(value = "select distinct details from Details details left join fetch details.weeks",
        countQuery = "select count(distinct details) from Details details")
    Page<Details> findAllWithEagerRelationships(Pageable pageable);

    @Query("select distinct details from Details details left join fetch details.weeks")
    List<Details> findAllWithEagerRelationships();

    @Query("select details from Details details left join fetch details.weeks where details.id =:id")
    Optional<Details> findOneWithEagerRelationships(@Param("id") Long id);

    @Query("select d from Details d where" +
            " d.time.name=:name and d.time.lesson=:lesson and d.professor.name=:professor and d.room.name=:room")
    List<Details> find(@Param("name") String name ,@Param("lesson")Integer lesson, @Param("professor") String professor ,
                 @Param("room") String room);
}
