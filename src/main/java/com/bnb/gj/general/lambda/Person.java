package com.bnb.gj.general.lambda;

import java.time.LocalDate;

/**
 * Created by vivek_000 on 27/04/2014.
 */
public class Person {
    public enum Sex {
        MALE, FEMALE
    }

    private String name;
    private LocalDate birthday;
    private Sex gender;
    private String emailAddress;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
