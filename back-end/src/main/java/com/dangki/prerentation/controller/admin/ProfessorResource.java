package com.dangki.prerentation.controller.admin;

import com.dangki.data.entities.Professor;
import com.dangki.service.ProfessorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing {@link Professor}.
 */
@RestController
@RequestMapping("/admin/api")
public class ProfessorResource {

    private final Logger log = LoggerFactory.getLogger(ProfessorResource.class);

    private final ProfessorService professorService;

    public ProfessorResource(ProfessorService professorService) {
        this.professorService = professorService;
    }

    /**
     * {@code POST  /professors} : Create a new professor.
     *
     * @param professors the professor to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new professor, or with status {@code 400 (Bad Request)} if the professor has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/professors")
    public ResponseEntity<List<Professor>> createProfessor(@Valid @RequestBody List<Professor> professors) throws URISyntaxException {
        log.debug("REST request to save Professor : {}", professors);
        List<Professor> result = professorService.add(professors);
        return ResponseEntity.ok(result);
    }

    /**
     * {@code PUT  /professors} : Updates an existing professor.
     *
     * @param professor the professor to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated professor,
     * or with status {@code 400 (Bad Request)} if the professor is not valid,
     * or with status {@code 500 (Internal Server Error)} if the professor couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/professors")
    public ResponseEntity<Professor> updateProfessor(@Valid @RequestBody Professor professor) throws URISyntaxException {
        log.debug("REST request to update Professor : {}", professor);
        Professor result = professorService.update(professor);
        return ResponseEntity.ok()
            .body(result);
    }

    /**
     * {@code GET  /professors} : get all the professors.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of professors in body.
     */
    @GetMapping("/professors")
    public ResponseEntity<List<Professor>> getAllProfessors(Pageable pageable) {
        log.debug("REST request to get a page of Professors");
        Page<Professor> page = professorService.findAll(pageable);
        return ResponseEntity.ok().body(page.getContent());
    }

    /**
     * {@code GET  /professors/:id} : get the "id" professor.
     *
     * @param id the id of the professor to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the professor, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/professors/{id}")
    public ResponseEntity<Professor> getProfessor(@PathVariable Long id) {
        log.debug("REST request to get Professor : {}", id);
        Optional<Professor> professor = professorService.findOne(id);
        return ResponseEntity.ok(professor.get());
    }

    /**
     * {@code DELETE  /professors/:id} : delete the "id" professor.
     *
     * @param id the id of the professor to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/professors/{id}")
    public void deleteProfessor(@PathVariable Long id) {
        log.debug("REST request to delete Professor : {}", id);
        professorService.delete(id);
    }
}
