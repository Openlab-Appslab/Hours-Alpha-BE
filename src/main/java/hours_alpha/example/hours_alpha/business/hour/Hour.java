package hours_alpha.example.hours_alpha.business.hour;

import com.fasterxml.jackson.annotation.JsonIgnore;
import hours_alpha.example.hours_alpha.business.employee.Employee;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Hour {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer sumOfHour;
    private String place;
    private String date;

    @ManyToOne
    @JoinColumn(name="employee_id")
    private Employee employee;

    public Hour(Integer sumOfHour, String place, String date) {
        this.sumOfHour = sumOfHour;
        this.place = place;
        this.date = date;
    }
}
