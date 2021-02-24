package com.dangki.prerentation.controller.admin;

import com.dangki.data.dto.TimeDto;
import com.dangki.data.entities.Time;
import com.dangki.service.TimeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing {@link Time}.
 */
@RestController
@RequestMapping("/api")
public class TimeResource {

    private final Logger log = LoggerFactory.getLogger(TimeResource.class);
    private final TimeService timeService;

    public TimeResource(TimeService timeService) {
        this.timeService = timeService;
    }

    /**
     * {@code POST  /times} : Create a new time.
     *
     * @param timeDtos the time to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new time, or with status {@code 400 (Bad Request)} if the time has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/times")
    public ResponseEntity<List<TimeDto>> createTime(@RequestBody List<TimeDto> timeDtos) throws URISyntaxException {
        log.debug("REST request to save Time : {}", timeDtos);
        System.out.println(timeDtos.size());
        List<TimeDto> result = timeService.add(timeDtos);
        return ResponseEntity.ok().body(result);
    }

    /**
     * {@code PUT  /times} : Updates an existing time.
     *
     * @param time the time to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated time,
     * or with status {@code 400 (Bad Request)} if the time is not valid,
     * or with status {@code 500 (Internal Server Error)} if the time couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/times")
    public ResponseEntity<TimeDto> updateTime(@RequestBody Time time) throws URISyntaxException {
        log.debug("REST request to update Time : {}", time);
        TimeDto result = timeService.update(time);
        return ResponseEntity.ok()
            .body(result);
    }

    /**
     * {@code GET  /times} : get all the times.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of times in body.
     */
    @GetMapping("/times")
    public ResponseEntity<List<Time>> getAllTimes(Pageable pageable) {
        log.debug("REST request to get a page of Times");
        Page<Time> page = timeService.findAll(pageable);
        return ResponseEntity.ok().body(page.getContent());
    }

    /**
     * {@code GET  /times/:id} : get the "id" time.
     *
     * @param id the id of the time to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the time, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/times/{id}")
    public ResponseEntity<Time> getTime(@PathVariable Long id) {
        log.debug("REST request to get Time : {}", id);
        Optional<Time> time = timeService.findOne(id);
        return ResponseEntity.ok(time.get());
    }

    /**
     * {@code DELETE  /times/:id} : delete the "id" time.
     *
     * @param id the id of the time to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/times/{id}")
    public void deleteTime(@PathVariable Long id) {
        log.debug("REST request to delete Time : {}", id);
        timeService.delete(id);
    }
}
