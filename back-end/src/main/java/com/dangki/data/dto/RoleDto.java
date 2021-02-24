package com.dangki.data.dto;

import java.util.List;

public class RoleDto extends BaseDto {
    private String code;
    private List<UserDto> users;
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
