package com.example.Hours_Alpha_v2.employee;

import com.example.Hours_Alpha_v2.user.User;
import com.example.Hours_Alpha_v2.user.UserRoles;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class Employee extends User{

    public Employee(String email, String firstName, String lastName, String telephone, UserRoles userRoles) {
        super(email, firstName, lastName, telephone, userRoles);
    }
}
