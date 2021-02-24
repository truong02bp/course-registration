package com.dangki.prerentation.controller.web;

import com.dangki.data.dto.ClassRoomDto;
import com.dangki.data.dto.UserDto;
import com.dangki.service.ClassRoomService;
import com.dangki.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController(value = "ClassRoomOfUser")
@RequestMapping("/api/class-rooms")
public class ClassRoomResource {

    private final Logger log = LoggerFactory.getLogger(com.dangki.prerentation.controller.admin.ClassRoomResource.class);

    private final ClassRoomService classRoomService;

    private final UserService userService;

    public ClassRoomResource(ClassRoomService classRoomService, UserService userService) {
        this.classRoomService = classRoomService;
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<ClassRoomDto> getById(@RequestParam("id") Long id) {
        log.debug("REST request to get a page of ClassRooms");
        ClassRoomDto classRoomDto = classRoomService.findById(id);
        return ResponseEntity.ok().body(classRoomDto);
    }

    /**
     * {@code GET  /class-rooms/subjectId} : get all the classRooms of subject
     *
     * @param subjectId
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of classRooms in body.
     */

    @GetMapping("/{subjectId}")
    public ResponseEntity<List<ClassRoomDto>> getAllClassRooms(@PathVariable Long subjectId) {
        log.debug("REST request to get a page of ClassRooms");
        List<ClassRoomDto> classes = classRoomService.findAllBySubjectId(subjectId);
        return ResponseEntity.ok().body(classes);
    }
    @PutMapping
    public ResponseEntity<?> registerClass(@RequestBody List<ClassRoomDto> classRooms) {
        UserDto userDto = userService.updateClass(classRooms);
        return ResponseEntity.ok(userDto);
    }
}
