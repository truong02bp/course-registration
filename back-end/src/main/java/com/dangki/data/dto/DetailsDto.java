package com.dangki.data.dto;

import com.dangki.data.entities.Room;

import java.util.Set;

public class DetailsDto extends BaseDto {
    private TimeDto time;
    private ProfessorDto professor;
    private Room room;
    private Set<WeekDto> weeks;

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public TimeDto getTime() {
        return time;
    }

    public void setTime(TimeDto time) {
        this.time = time;
    }

    public ProfessorDto getProfessor() {
        return professor;
    }

    public void setProfessor(ProfessorDto professor) {
        this.professor = professor;
    }

    public Set<WeekDto> getWeeks() {
        return weeks;
    }

    public void setWeeks(Set<WeekDto> weeks) {
        this.weeks = weeks;
    }
}
