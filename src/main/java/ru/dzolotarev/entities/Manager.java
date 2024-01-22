package ru.dzolotarev.entities;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

@Entity
@Table(name = "managers", schema = "company")
public class Manager {

    @Id
    private Long id;
    private String name;
    private String title;
    private Integer salary;
    @Column(name = "hire_date")
    private LocalDate hireDate;
    private Integer subordinates;
    @Column(name = "department_id")
    private Integer departmentId;
}
