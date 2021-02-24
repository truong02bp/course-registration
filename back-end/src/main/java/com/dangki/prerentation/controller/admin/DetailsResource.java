package com.dangki.prerentation.controller.admin;

import com.dangki.data.dto.DetailsDto;
import com.dangki.data.entities.Details;
import com.dangki.service.DetailsService;
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
 * REST controller for managing {@link Details}.
 */
@RestController
@RequestMapping("/api")
public class DetailsResource {

    private final Logger log = LoggerFactory.getLogger(DetailsResource.class);

    private final DetailsService detailsService;

    public DetailsResource(DetailsService detailsService) {
        this.detailsService = detailsService;
    }

    /**
     * {@code POST  /details} : Create a new details.
     *
     * @param details the details to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new details, or with status {@code 400 (Bad Request)} if the details has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/details")
    public ResponseEntity<List<DetailsDto>> createDetails(@Valid @RequestBody List<DetailsDto> details) throws URISyntaxException {
        log.debug("REST request to save Details : {}", details);

        List<DetailsDto> result = detailsService.add(details);
        return ResponseEntity.ok()
                .body(result);
    }

    /**
     * {@code PUT  /details} : Updates an existing details.
     *
     * @param details the details to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated details,
     * or with status {@code 400 (Bad Request)} if the details is not valid,
     * or with status {@code 500 (Internal Server Error)} if the details couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/details")
    public ResponseEntity<Details> updateDetails(@Valid @RequestBody Details details) throws URISyntaxException {
        log.debug("REST request to update Details : {}", details);
        Details result = detailsService.update(details);
        return ResponseEntity.ok()
                .body(result);
    }

    /**
     * {@code GET  /details} : get all the details.
     *
     * @param pageable  the pagination information.
     * @param eagerload flag to eager load entities from relationships (This is applicable for many-to-many).
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of details in body.
     */
    @GetMapping("/details")
    public ResponseEntity<List<Details>> getAllDetails(Pageable pageable, @RequestParam(required = false, defaultValue = "false") boolean eagerload) {
        log.debug("REST request to get a page of Details");
        Page<Details> page;
        if (eagerload) {
            page = detailsService.findAllWithEagerRelationships(pageable);
        } else {
            page = detailsService.findAll(pageable);
        }
        return ResponseEntity.ok().body(page.getContent());
    }

    /**
     * {@code GET  /details/:id} : get the "id" details.
     *
     * @param id the id of the details to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the details, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/details/{id}")
    public ResponseEntity<Details> getDetails(@PathVariable Long id) {
        log.debug("REST request to get Details : {}", id);
        Optional<Details> details = detailsService.findOne(id);
        return ResponseEntity.ok(details.get());
    }

    /**
     * {@code DELETE  /details/:id} : delete the "id" details.
     *
     * @param id the id of the details to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/details/{id}")
    public void deleteDetails(@PathVariable Long id) {
        log.debug("REST request to delete Details : {}", id);
        detailsService.delete(id);
    }
}
