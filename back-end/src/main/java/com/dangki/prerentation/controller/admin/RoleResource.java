package com.dangki.prerentation.controller.admin;

import com.dangki.data.entities.Role;
import com.dangki.data.repository.RoleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing {@link Role}.
 */
@RestController
@RequestMapping("/api")
@Transactional
public class RoleResource {

    private final Logger log = LoggerFactory.getLogger(RoleResource.class);

    private final RoleRepository roleRepository;

    public RoleResource(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    /**
     * {@code POST  /roles} : Create a new role.
     *
     * @param role the role to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new role, or with status {@code 400 (Bad Request)} if the role has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/roles")
    public ResponseEntity<Role> createRole(@Valid @RequestBody Role role) throws URISyntaxException {
        log.debug("REST request to save Role : {}", role);
        Role result = roleRepository.save(role);
        return ResponseEntity.created(new URI("/api/roles/" + result.getId()))
            .body(result);
    }

    /**
     * {@code PUT  /roles} : Updates an existing role.
     *
     * @param role the role to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated role,
     * or with status {@code 400 (Bad Request)} if the role is not valid,
     * or with status {@code 500 (Internal Server Error)} if the role couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/roles")
    public ResponseEntity<Role> updateRole(@Valid @RequestBody Role role) throws URISyntaxException {
        log.debug("REST request to update Role : {}", role);
        Role result = roleRepository.save(role);
        return ResponseEntity.ok()
            .body(result);
    }

    /**
     * {@code GET  /roles} : get all the roles.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of roles in body.
     */
    @GetMapping("/roles")
    public ResponseEntity<List<Role>> getAllRoles(Pageable pageable) {
        log.debug("REST request to get a page of Roles");
        Page<Role> page = roleRepository.findAll(pageable);
        return ResponseEntity.ok().body(page.getContent());
    }

    /**
     * {@code GET  /roles/:id} : get the "id" role.
     *
     * @param id the id of the role to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the role, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/roles/{id}")
    public ResponseEntity<Role> getRole(@PathVariable Long id) {
        log.debug("REST request to get Role : {}", id);
        Optional<Role> role = roleRepository.findById(id);
        return ResponseEntity.ok(role.get());
    }

    /**
     * {@code DELETE  /roles/:id} : delete the "id" role.
     *
     * @param id the id of the role to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/roles/{id}")
    public void deleteRole(@PathVariable Long id) {
        log.debug("REST request to delete Role : {}", id);
        roleRepository.deleteById(id);
    }
}
