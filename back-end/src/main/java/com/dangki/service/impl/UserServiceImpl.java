package com.dangki.service.impl;

import com.dangki.common.MessageConstants;
import com.dangki.common.exception.ApiException;
import com.dangki.common.utils.Converter;
import com.dangki.common.utils.SecurityUtil;
import com.dangki.data.dto.ClassRoomDto;
import com.dangki.data.dto.UserDto;
import com.dangki.data.entities.ClassRoom;
import com.dangki.data.entities.User;
import com.dangki.data.repository.ClassRoomRepository;
import com.dangki.data.repository.RoleRepository;
import com.dangki.data.repository.UserRepository;
import com.dangki.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private ClassRoomRepository classRoomRepository;
    @Autowired
    private SecurityUtil securityUtil;
    private final Converter<UserDto, User> converter = new Converter<>(UserDto.class,User.class);
    @Override
    @Transactional
    public List<UserDto> add(List<UserDto> userDtos) {
        List<UserDto> list = new ArrayList<>();
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        userDtos.forEach(userDto -> {
            User user = converter.toEntity(userDto);
            String password = user.getCode();
            String username = user.getCode();
            if (userRepository.findByUsername(username) != null)
                throw ApiException.from(HttpStatus.INTERNAL_SERVER_ERROR).message(MessageConstants.USER_CONSIST);
            user.setPassword(passwordEncoder.encode(password));
            user.setUsername(username);
            user.setActive(true);
            user.setRoles(roleRepository.findByName("USER"));
            list.add(converter.toDto(userRepository.save(user)));
        });
        return list;
    }

    @Override
    @Transactional
    public UserDto update(UserDto userDto){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        User user = userRepository.findById(userDto.getId()).get();
        user.setPhone(userDto.getPhone());
        user.setEmail(userDto.getEmail());
        if (userDto.getPassword() != null){
            if (!passwordEncoder.matches(userDto.getOldPassword(),user.getPassword()))
                throw ApiException.from(HttpStatus.INTERNAL_SERVER_ERROR).message(MessageConstants.OLD_PASSWORD_WRONG);
            user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        }
        return converter.toDto(userRepository.save(user));
    }

    @Override
    public void updateAvatar(MultipartFile multipartFile) throws IOException {
        User user = userRepository.findById(securityUtil.getUserDetails().getUser().getId()).get();
        File file = new File("images/"+multipartFile.getOriginalFilename());
        user.setUrl("images/"+multipartFile.getOriginalFilename());
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(multipartFile.getBytes());
        fos.close();
        userRepository.save(user);
    }

    @Override
    public List<UserDto> getAllByClassId(Long classId) {
        List<UserDto> list = converter.toDto(userRepository.findAllByClassRoomId(classId));
        list.forEach(userDto -> {
            userDto.setPassword(null);
            userDto.setClassRooms(null);
        });
        return list;
    }

    @Override
    public UserDto updateClass(List<ClassRoomDto> classRooms) {
        User user = userRepository.findById(securityUtil.getUserDetails().getUser().getId()).get();
        List<ClassRoom> list = new ArrayList<>();
        List<ClassRoom> old = user.getClassRooms();
        old.forEach(classRoom -> {
            classRoom.setSlot(classRoom.getSlot()+1);
        });
        classRooms.forEach(classRoomDto -> {
            ClassRoom classRoom = classRoomRepository.findById(classRoomDto.getId()).get();
            if (classRoom.getSlot() == 0)
                throw ApiException.from(HttpStatus.INTERNAL_SERVER_ERROR).message(MessageConstants.CLASS_FULL+": " +classRoom.getSubject().getName()+" "+classRoom.getNmh());
            classRoom.setSlot(classRoom.getSlot()-1);
            list.add(classRoom);
        }            );
        user.setClassRooms(list);
        user = userRepository.save(user);
        return converter.toDto(user);
    }

    @Override
    @Transactional
    public void delete(List<UserDto> users) {
        List<User> list = converter.toEntity(users);
        userRepository.deleteAll(list);
    }


    @Override
    @Transactional(readOnly = true)
    public List<UserDto> findAll() {
        return converter.toDto(userRepository.findAll());
    }

}
