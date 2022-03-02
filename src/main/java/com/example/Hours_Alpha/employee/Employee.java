package com.example.Hours_Alpha.employee;

import com.example.Hours_Alpha.company.Company;
import com.example.Hours_Alpha.hour.Hour;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;

import java.time.LocalDate;
import java.util.List;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(
        name = "employee",
        uniqueConstraints = {
                @UniqueConstraint(name = "employee_email_unique", columnNames = "email")
        }
)
public class Employee {

    @Id
    @SequenceGenerator(
            name="employee_sequence",
            sequenceName = "employee_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "employee_sequence"
    )
    private Long id;

    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private LocalDate dob;

    @JsonIgnore
    @ManyToOne(
          cascade = CascadeType.ALL
    )
    @JoinColumn(name = "company_id")
    private Company company;

    @OneToMany(
            mappedBy = "employee"
    )
    private List<Hour> recordHour;

    public Employee(String email, String password, String firstName, String lastName, LocalDate dob) {
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
    }

    public Employee() {
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

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public List<Hour> getRecordHour() {
        return recordHour;
    }

    public void setRecordHour(List<Hour> recordHour) {
        this.recordHour = recordHour;
    }
}
