package com.dangki.service;

import com.dangki.data.dto.ClassRoomDto;
import com.dangki.data.dto.UserDto;
import com.dangki.data.entities.ClassRoom;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface UserService {
    List<UserDto> add(List<UserDto> userDtos);
    UserDto update(UserDto userDto);
    void updateAvatar(MultipartFile multipartFile) throws IOException;
    List<UserDto> getAllByClassId(Long classId);
    UserDto updateClass(List<ClassRoomDto> classRooms);
    void delete(List<UserDto> users);
    List<UserDto> findAll();
}
