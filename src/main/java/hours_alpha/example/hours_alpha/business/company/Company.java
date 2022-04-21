package hours_alpha.example.hours_alpha.business.company;

import com.fasterxml.jackson.annotation.JsonIgnore;
import hours_alpha.example.hours_alpha.business.employee.Employee;
import hours_alpha.example.hours_alpha.business.employer.Employer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Company  {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String place;
    private String ico;

    @OneToOne(mappedBy = "company")
    private Employer employer;

    @JsonIgnore
    @OneToMany(
            mappedBy = "company"
    )
    private List<Employee> listOfEmployees = new ArrayList<>();

    public Company(String place, String ico, Employer employer) {
        this.place = place;
        this.ico = ico;
        this.employer = employer;
        this.listOfEmployees = new ArrayList<>();
    }
}
