package com.employee.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Attendance extends BaseModel{

    private String weekNumber;
    private String monday;
    private String tuesday;
    private String wednesday;
    private String thursday;
    private String friday;

    @ManyToOne
    //@JoinColumn(name = "employee_id")
    private Employee employee;

}
