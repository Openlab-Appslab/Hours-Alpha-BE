package com.example.Hours_Alpha_v2.employee;

import com.example.Hours_Alpha_v2.company.Company;
import com.example.Hours_Alpha_v2.hour.Hour;
import com.example.Hours_Alpha_v2.user.User;
import com.example.Hours_Alpha_v2.user.UserRoles;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class Employee extends User{

    @JsonIgnore
    @ManyToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "company_id"
    )
    private Company company = new Company();

    @JsonIgnore
    @OneToMany(
            mappedBy = "employee"
    )
    private List<Hour> listOfHour = new ArrayList<>();

    public Employee(String email, String firstName, String lastName, Long telephone, UserRoles userRoles) {
        super(email, firstName, lastName, telephone, userRoles);
    }
}
