package com.dangki.prerentation.controller.admin;

import com.dangki.data.entities.Semester;
import com.dangki.service.SemesterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing {@link Semester}.
 */
@RestController
@RequestMapping("/api")
public class SemesterResource {

    private final Logger log = LoggerFactory.getLogger(SemesterResource.class);

    private final SemesterService semesterService;

    public SemesterResource(SemesterService semesterService) {
        this.semesterService = semesterService;
    }

    /**
     * {@code POST  /semesters} : Create a new semester.
     *
     * @param semester the semester to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new semester, or with status {@code 400 (Bad Request)} if the semester has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/semesters")
    public ResponseEntity<Semester> createSemester(@RequestBody Semester semester) throws URISyntaxException {
        log.debug("REST request to save Semester : {}", semester);
        Semester result = semesterService.save(semester);
        return ResponseEntity.created(new URI("/api/semesters/" + result.getId()))
            .body(result);
    }

    /**
     * {@code PUT  /semesters} : Updates an existing semester.
     *
     * @param semester the semester to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated semester,
     * or with status {@code 400 (Bad Request)} if the semester is not valid,
     * or with status {@code 500 (Internal Server Error)} if the semester couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/semesters")
    public ResponseEntity<Semester> updateSemester(@RequestBody Semester semester) throws URISyntaxException {
        log.debug("REST request to update Semester : {}", semester);
        Semester result = semesterService.save(semester);
        return ResponseEntity.ok()
            .body(result);
    }

    /**
     * {@code GET  /semesters} : get all the semesters.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of semesters in body.
     */
    @GetMapping("/semesters")
    public ResponseEntity<List<Semester>> getAllSemesters(Pageable pageable) {
        log.debug("REST request to get a page of Semesters");
        Page<Semester> page = semesterService.findAll(pageable);
        return ResponseEntity.ok().body(page.getContent());
    }

    /**
     * {@code GET  /semesters/:id} : get the "id" semester.
     *
     * @param id the id of the semester to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the semester, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/semesters/{id}")
    public ResponseEntity<Semester> getSemester(@PathVariable Long id) {
        log.debug("REST request to get Semester : {}", id);
        Optional<Semester> semester = semesterService.findOne(id);
        return ResponseEntity.ok(semester.get());
    }

    /**
     * {@code DELETE  /semesters/:id} : delete the "id" semester.
     *
     * @param id the id of the semester to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/semesters/{id}")
    public void deleteSemester(@PathVariable Long id) {
        log.debug("REST request to delete Semester : {}", id);
        semesterService.delete(id);
    }
}
