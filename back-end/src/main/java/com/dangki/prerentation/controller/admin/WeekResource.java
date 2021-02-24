package com.dangki.prerentation.controller.admin;

import com.dangki.data.entities.Week;
import com.dangki.service.WeekService;
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
 * REST controller for managing {@link Week}.
 */
@RestController
@RequestMapping("/api")
public class WeekResource {

    private final Logger log = LoggerFactory.getLogger(WeekResource.class);

    private final WeekService weekService;

    public WeekResource(WeekService weekService) {
        this.weekService = weekService;
    }

    /**
     * {@code POST  /weeks} : Create a new week.
     *
     * @param week the week to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new week, or with status {@code 400 (Bad Request)} if the week has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/weeks")
    public ResponseEntity<Week> createWeek(@Valid @RequestBody Week week) throws URISyntaxException {
        log.debug("REST request to save Week : {}", week);
        Week result = weekService.save(week);
        return ResponseEntity.created(new URI("/api/weeks/" + result.getId()))
            .body(result);
    }

    /**
     * {@code PUT  /weeks} : Updates an existing week.
     *
     * @param week the week to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated week,
     * or with status {@code 400 (Bad Request)} if the week is not valid,
     * or with status {@code 500 (Internal Server Error)} if the week couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/weeks")
    public ResponseEntity<Week> updateWeek(@Valid @RequestBody Week week) throws URISyntaxException {
        log.debug("REST request to update Week : {}", week);
        Week result = weekService.save(week);
        return ResponseEntity.ok()
            .body(result);
    }

    /**
     * {@code GET  /weeks} : get all the weeks.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of weeks in body.
     */
    @GetMapping("/weeks")
    public ResponseEntity<List<Week>> getAllWeeks(Pageable pageable) {
        log.debug("REST request to get a page of Weeks");
        Page<Week> page = weekService.findAll(pageable);
        return ResponseEntity.ok().body(page.getContent());
    }

    /**
     * {@code GET  /weeks/:id} : get the "id" week.
     *
     * @param id the id of the week to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the week, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/weeks/{id}")
    public ResponseEntity<Week> getWeek(@PathVariable Long id) {
        log.debug("REST request to get Week : {}", id);
        Optional<Week> week = weekService.findOne(id);
        return ResponseEntity.ok(week.get());
    }

    /**
     * {@code DELETE  /weeks/:id} : delete the "id" week.
     *
     * @param id the id of the week to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/weeks/{id}")
    public void deleteWeek(@PathVariable Long id) {
        log.debug("REST request to delete Week : {}", id);
        weekService.delete(id);
    }
}
