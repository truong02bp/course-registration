package com.dangki.prerentation.controller.admin;


import com.dangki.data.entities.Subject;
import com.dangki.service.SubjectService;
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
 * REST controller for managing {@link Subject}.
 */
@RestController
@RequestMapping("/api")
public class SubjectResource {

    private final Logger log = LoggerFactory.getLogger(SubjectResource.class);

    private final SubjectService subjectService;

    public SubjectResource(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    /**
     * {@code POST  /subjects} : Create a new subject.
     *
     * @param subjects the subject to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new subject, or with status {@code 400 (Bad Request)} if the subject has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/subjects")
    public ResponseEntity<List<Subject>> createSubject(@Valid @RequestBody List<Subject> subjects) throws URISyntaxException {
        log.debug("REST request to save Subjects: {}", subjects);

        List<Subject> result = subjectService.save(subjects);
        return ResponseEntity.ok(result);
    }

    /**
     * {@code PUT  /subjects} : Updates an existing subject.
     *
     * @param subject the subject to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated subject,
     * or with status {@code 400 (Bad Request)} if the subject is not valid,
     * or with status {@code 500 (Internal Server Error)} if the subject couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/subjects")
    public ResponseEntity<Subject> updateSubject(@Valid @RequestBody Subject subject) throws URISyntaxException {
        log.debug("REST request to update Subject : {}", subject);
        Subject result = subjectService.save(subject);
        return ResponseEntity.ok()
            .body(result);
    }

    /**
     * {@code GET  /subjects} : get all the subjects.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of subjects in body.
     */
    @GetMapping("/subjects")
    public ResponseEntity<List<Subject>> getAllSubjects(Pageable pageable) {
        log.debug("REST request to get a page of Subjects");
        Page<Subject> page = subjectService.findAll(pageable);
        return ResponseEntity.ok().body(page.getContent());
    }

    /**
     * {@code GET  /subjects/:id} : get the "id" subject.
     *
     * @param id the id of the subject to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the subject, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/subjects/{id}")
    public ResponseEntity<Subject> getSubject(@PathVariable Long id) {
        log.debug("REST request to get Subject : {}", id);
        Optional<Subject> subject = subjectService.findOne(id);
        return ResponseEntity.ok(subject.get());
    }

    /**
     * {@code DELETE  /subjects/:id} : delete the "id" subject.
     *
     * @param id the id of the subject to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/subjects/{id}")
    public void deleteSubject(@PathVariable Long id) {
        log.debug("REST request to delete Subject : {}", id);
        subjectService.delete(id);
    }
}
