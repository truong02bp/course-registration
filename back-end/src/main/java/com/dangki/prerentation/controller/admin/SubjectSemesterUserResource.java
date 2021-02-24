package com.dangki.prerentation.controller.admin;

import com.dangki.common.utils.SecurityUtil;
import com.dangki.data.dto.ParamDto;
import com.dangki.data.entities.SubjectSemesterUser;
import com.dangki.service.SubjectSemesterUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
 * REST controller for managing {@link SubjectSemesterUser}.
 */
@RestController
@RequestMapping("/api")
public class SubjectSemesterUserResource {

    private final Logger log = LoggerFactory.getLogger(SubjectSemesterUserResource.class);

    private final SubjectSemesterUserService subjectSemesterUserService;

    public SubjectSemesterUserResource(SubjectSemesterUserService subjectSemesterUserService) {
        this.subjectSemesterUserService = subjectSemesterUserService;
    }

    /**
     * {@code POST  /subject-semester-users} : Create a new subjectSemesterUser.
     *
     * @param params have user_id , semester_id and subject_id
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new subjectSemesterUser, or with status {@code 400 (Bad Request)} if the subjectSemesterUser has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/subject-semester-users")
    public ResponseEntity<List<SubjectSemesterUser>> createSubjectSemesterUser(@Valid @RequestBody List<ParamDto> params) throws URISyntaxException {
        List<SubjectSemesterUser> result = subjectSemesterUserService.add(params);
        return ResponseEntity.ok().body(result);
    }

    /**
     * {@code PUT  /subject-semester-users} : Updates an existing subjectSemesterUser.
     *
     * @param subjectSemesterUser the subjectSemesterUser to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated subjectSemesterUser,
     * or with status {@code 400 (Bad Request)} if the subjectSemesterUser is not valid,
     * or with status {@code 500 (Internal Server Error)} if the subjectSemesterUser couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/subject-semester-users")
    public ResponseEntity<SubjectSemesterUser> updateSubjectSemesterUser(@Valid @RequestBody SubjectSemesterUser subjectSemesterUser) throws URISyntaxException {
        log.debug("REST request to update SubjectSemesterUser : {}", subjectSemesterUser);
        SubjectSemesterUser result = subjectSemesterUserService.update(subjectSemesterUser);
        return ResponseEntity.ok()
            .body(result);
    }

    /**
     * {@code GET  /subject-semester-users/:id} : get the "id" subjectSemesterUser.
     *
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the subjectSemesterUser, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/subject-semester-users")
    public ResponseEntity<List<SubjectSemesterUser>> getSubjectSemesterUser() {
        List<SubjectSemesterUser> subjectSemesterUsers = subjectSemesterUserService.findAll();
        return ResponseEntity.ok(subjectSemesterUsers);
    }

    /**
     * {@code DELETE  /subject-semester-users/:id} : delete the "id" subjectSemesterUser.
     *
     * @param id the id of the subjectSemesterUser to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/subject-semester-users/{id}")
    public void deleteSubjectSemesterUser(@PathVariable Long id) {
        log.debug("REST request to delete SubjectSemesterUser : {}", id);
        subjectSemesterUserService.delete(id);
    }
}
