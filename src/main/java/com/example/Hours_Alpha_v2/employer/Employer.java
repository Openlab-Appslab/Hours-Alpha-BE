package com.example.Hours_Alpha_v2.employer;

import com.example.Hours_Alpha_v2.company.Company;
import com.example.Hours_Alpha_v2.user.User;
import com.example.Hours_Alpha_v2.user.UserRoles;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Employer extends User{

    @OneToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "company_id"
    )
    private Company company;

    public Employer(String email, String firstName, String lastName, Long telephone, UserRoles userRoles) {
        super(email, firstName, lastName, telephone, userRoles);
    }
}
