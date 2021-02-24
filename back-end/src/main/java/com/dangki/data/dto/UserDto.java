package com.dangki.data.dto;

import com.dangki.data.entities.Professor;
import com.dangki.data.entities.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto extends BaseDto {
    private String username;
    private String password;
    private String oldPassword = null;
    private String name;
    private String code;
    private String email;
    private String lop;
    private String phone;
    private Boolean active;
    private String birthday;
    private String major;
    private Professor professor;
    private String url;
    private List<Role> roles;
    private List<ClassRoomDto> classRooms;
    private String nameHoney;
}
