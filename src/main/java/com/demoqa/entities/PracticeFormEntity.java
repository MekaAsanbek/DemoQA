package com.demoqa.entities;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Builder   //Билдер помогает создавать сложные обьекты(сложные значит: обьекты с множеством полей, с зависимыми полями, объекты с логикой инициализации)


public class PracticeFormEntity {

    private String firstName;
    private String lastName;
    private String email;
    private String gender;
    private String mobileNumber;
    private String dateOfBirth;
    private String subjects;
    private String hobbies;
    private String upLoadPicture;
    private String currentAddress;
    private String state;
    private String city;
}


