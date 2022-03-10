package com.example.Hours_Alpha_v2.employer;

import com.example.Hours_Alpha_v2.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Employer extends User{

    public Employer(String email, String firstName, String lastName, String telephone) {
        super(email, firstName, lastName, telephone);
    }
}
