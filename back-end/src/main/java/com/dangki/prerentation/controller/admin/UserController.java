package com.dangki.prerentation.controller.admin;

import com.dangki.data.dto.UserDto;
import com.dangki.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController(value = "UserOfAdmin")
@RequestMapping("/admin/api/user")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping
    public ResponseEntity<?> getList()
    {
        return ResponseEntity.ok(userService.findAll());
    }
    @PostMapping
    public ResponseEntity<?> add(@RequestBody List<UserDto> usersDto)
    {
        return ResponseEntity.ok(userService.add(usersDto));
    }
    @PutMapping
    public ResponseEntity<?> update(@RequestBody UserDto userDto)
    {
        return ResponseEntity.ok(userService.update(userDto));
    }
    @DeleteMapping
    public void delete(@RequestBody List<UserDto> users)
    {
        userService.delete(users);
    }
}
