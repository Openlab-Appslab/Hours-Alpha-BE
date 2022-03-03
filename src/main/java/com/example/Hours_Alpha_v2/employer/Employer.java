package com.example.Hours_Alpha_v2.employer;

import com.example.Hours_Alpha_v2.user.User;
import com.example.Hours_Alpha_v2.user.UserRoles;

import javax.persistence.Entity;

@Entity
public class Employer extends User {

    private UserRoles useRole = UserRoles.EMPLOYER;
}
