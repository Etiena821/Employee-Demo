package com.employee.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Employee extends BaseModel {

    private String firstName;

    private String lastName;

   // @Column(unique = true) //two users cannot have the same email
    private String email;

    private String age;

    private String position;

    private String salary;

    private String leaveStatus;

    private String address;

    private String phoneNumber;

    private String stateOfOrigin;

    private String maritalStatus;

    private String religion;

    private String qualification;

    private String yearsOfExperience;


}

