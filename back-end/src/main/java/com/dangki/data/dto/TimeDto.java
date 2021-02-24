package com.dangki.data.dto;

public class TimeDto extends BaseDto {
    private String name;
    private Integer lesson;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLesson() {
        return lesson;
    }

    public void setLesson(Integer lesson) {
        this.lesson = lesson;
    }
}
