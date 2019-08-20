package com.vibenar.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@NoArgsConstructor
public class User {
    private int id;
    private String name;
    private String lastName;
    private String middleName;
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date yearOfBirth;
    private String nationality;
    private String education;
    private String placeOfStudy;
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date yearOfCompletion;
    private String phone;
    private String email;


}
