package com.dangki.data.dto;


import com.dangki.data.entities.User;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ClassRoomDto extends BaseDto {
    private String nmh;
    private Integer tth;
    private Integer quantity;
    private Integer slot;
    private SubjectDto subject;
    private Set<DetailsDto> details = new HashSet<>();
    private List<UserDto> users;

    public String getNmh() {
        return nmh;
    }

    public void setNmh(String nmh) {
        this.nmh = nmh;
    }

    public Integer getTth() {
        return tth;
    }

    public void setTth(Integer tth) {
        this.tth = tth;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getSlot() {
        return slot;
    }

    public void setSlot(Integer slot) {
        this.slot = slot;
    }

    public SubjectDto getSubject() {
        return subject;
    }

    public void setSubject(SubjectDto subject) {
        this.subject = subject;
    }

    public Set<DetailsDto> getDetails() {
        return details;
    }

    public void setDetails(Set<DetailsDto> details) {
        this.details = details;
    }

    public List<UserDto> getUsers() {
        return users;
    }

    public void setUsers(List<UserDto> users) {
        this.users = users;
    }
}
