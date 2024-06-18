package com.demoqa.utils;

import com.demoqa.entities.Employee;
import com.demoqa.entities.PracticeFormEntity;
import com.demoqa.entities.TextBoxEntity;
import com.github.javafaker.Faker;

public class RandomUtils {
    static Faker faker = new Faker();

    public TextBoxEntity generateRandomTextBoxEntity(){
        TextBoxEntity textBoxEntity = new TextBoxEntity();
        textBoxEntity.setFullName(faker.name().fullName());
        textBoxEntity.setEmail(faker.internet().emailAddress());
        textBoxEntity.setCurrentAddress(faker.address().fullAddress());
        textBoxEntity.setPermanentAddress(faker.address().secondaryAddress());
        return textBoxEntity;
    }

    public PracticeFormEntity generateRandomPracticeFormEntity() {

        PracticeFormEntity practiceFormEntity = new PracticeFormEntity();
        practiceFormEntity.setFirstName(faker.name().firstName());
        practiceFormEntity.setLastName(faker.name().lastName());
        practiceFormEntity.setEmail(faker.internet().emailAddress());
        practiceFormEntity.setGender(faker.demographic().sex());
        practiceFormEntity.setMobileNumber(faker.phoneNumber().subscriberNumber(10));
        practiceFormEntity.setDateOfBirth(String.valueOf(faker.date().birthday()));
//        practiceFormEntity.setSubjects(faker.educator().course());
        practiceFormEntity.setSubjects("Computer Science");
        practiceFormEntity.setHobbies(faker.name().name());
        practiceFormEntity.setUpLoadPicture("D:/pic/justin-ha-bxKKZNNsqTg-unsplash.jpg");
        practiceFormEntity.setCurrentAddress(faker.address().fullAddress());
//        practiceFormEntity.setState(faker.address().state());
//        practiceFormEntity.setCity(faker.address().city());
        practiceFormEntity.setState("NCR");
        practiceFormEntity.setCity("Delhi");
        return practiceFormEntity;

    }



    public static Employee createMockEmployee(){
        Employee employee = new Employee();
        employee.setFirstName(faker.name().firstName());
        employee.setLastName(faker.name().lastName());
        employee.setEmail(faker.internet().emailAddress());
//      employee.setEmail("kierra@example.com");
        employee.setAge(faker.number().numberBetween(18,100));
        employee.setSalary(faker.number().numberBetween(1000000l,20000000l));
        employee.setDepartment(faker.job().position());
        return employee;
    }



}
