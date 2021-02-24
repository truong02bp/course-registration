package com.dangki.prerentation.controller.web;

import com.dangki.common.utils.SecurityConstants;
import com.dangki.common.utils.SecurityUtil;
import com.dangki.data.dto.AuthenticationResponse;
import com.dangki.data.dto.UserDto;
import com.dangki.data.entities.User;
import com.dangki.data.repository.UserRepository;
import com.dangki.service.JwtUtil;
import com.dangki.service.MyUserDetailsService;
import com.dangki.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private MyUserDetailsService myUserDetailsService;
    @Autowired
    private UserService userService;
    @Autowired
    private SecurityUtil securityUtil;
    @Autowired
    private JwtUtil util;

    @GetMapping
    public ResponseEntity<?> getUserCurrent() {
        return ResponseEntity.ok(securityUtil.getUserDetails().getUser());
    }

    @GetMapping("/list")
    public ResponseEntity<List<UserDto>> getUsersOfClass(@RequestParam("classId") Long classId)
    {
        return ResponseEntity.ok(userService.getAllByClassId(classId));
    }

    @PostMapping("/avatar")
    public ResponseEntity<?> updateAvatar(@RequestBody MultipartFile multipartFile) throws IOException {
        userService.updateAvatar(multipartFile);
        return ResponseEntity.ok("ok");
    }

    @PostMapping("/authenticate")
    public ResponseEntity<?> authentication(@RequestBody UserDto userDto) throws Exception {
        System.out.println("aa");
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    userDto.getUsername(), userDto.getPassword()));
        } catch (BadCredentialsException e) {
            throw new Exception("Invalid username", e);
        }
        UserDetails userDetails = myUserDetailsService.loadUserByUsername(userDto.getUsername());
        String jwt = util.generateToken(userDetails);
        return ResponseEntity.ok(new AuthenticationResponse(SecurityConstants.JWT_TOKEN_PREFIX + jwt));
    }
    @PutMapping
    public ResponseEntity<?> update(@RequestBody UserDto userDto)
    {
        return ResponseEntity.ok(userService.update(userDto));
    }
}
