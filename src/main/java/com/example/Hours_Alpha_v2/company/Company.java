package com.example.Hours_Alpha_v2.company;

import com.example.Hours_Alpha_v2.employee.Employee;
import com.example.Hours_Alpha_v2.employer.Employer;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.TypeAlias;

import javax.persistence.*;

import java.util.List;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(
        name = "company"
)
public class Company {

    @Id
    @SequenceGenerator(
            name = "company_sequence",
            sequenceName = "company_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "company_sequence"
    )
    private Long id;

    @OneToOne(mappedBy = "company")
    private Employer employer;

    @OneToMany(mappedBy = "company")
    private List<Employee> employeeList;
}
