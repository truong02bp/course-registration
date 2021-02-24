package com.dangki.service;

import com.dangki.data.dto.RoleDto;
import com.dangki.data.dto.UserDto;

import java.util.List;

public interface RoleService {
    RoleDto add(RoleDto roleDto);
    RoleDto update(RoleDto roleDto);
    void delete(List<RoleDto> users);
    List<RoleDto> findAll();
}
