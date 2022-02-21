package com.example.Hours_Alpha.boss;

import javax.persistence.*;
import java.time.LocalDate;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(
         name="boss",
        uniqueConstraints = {
                 @UniqueConstraint(name = "boss_email_unique", columnNames = "email")
        }
)
public class Boss {

    @Id
    @SequenceGenerator(
            name="boss_sequence",
            sequenceName = "boss_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "boss_sequence"
    )
    @Column(
            updatable = false
    )
    private Long id;

    @Column(
            name = "email",
            columnDefinition = "text",
            nullable = false
    )
    private String email;

    @Column(
            name = "password",
            columnDefinition = "text",
            nullable = false
    )
    private String password;

    @Column(
            name = "firstName",
            columnDefinition = "text",
            nullable = false
    )
    private String firstName;

    @Column(
            name = "lastName",
            columnDefinition = "text",
            nullable = false
    )
    private String lastName;


    @Column(
            name = "dob",
            columnDefinition = "date",
            nullable = false
    )
    private LocalDate dob;


    @Column(
            name = "company",
            columnDefinition = "company",
            nullable = false
    )
    private Company nameOfCompany;

    public Boss() {
    }

    public Boss(String email, String password, String firstName, String lastName, LocalDate dob, Company nameOfCompany) {
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.nameOfCompany = nameOfCompany;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public Company getNameOfCompany() {
        return nameOfCompany;
    }

    public void setNameOfCompany(Company nameOfCompany) {
        this.nameOfCompany = nameOfCompany;
    }
}
