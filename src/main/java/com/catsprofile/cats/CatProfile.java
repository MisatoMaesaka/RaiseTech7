package com.catsprofile.cats;

import java.time.LocalDate;

public class CatProfile {
    private String name;
    private LocalDate birthDay;
    private String color;

    public CatProfile(String name, LocalDate birthDay, String color) {
        this.name = name;
        this.birthDay = birthDay;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public String getColor() {
        return color;
    }
}
