package hours_alpha.example.hours_alpha.business.hour;

import com.fasterxml.jackson.annotation.JsonIgnore;
import hours_alpha.example.hours_alpha.business.employee.Employee;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Hour {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double sumOfHour;
    private String place;
    private LocalDate dateOfDay;
    private String note;
    private String issue;

    @ManyToOne
    @JoinColumn(name="employee_id")
    private Employee employee;

    //without issues
    public Hour(Double sumOfHour, String place, LocalDate dateOfDay, String note) {
        this.sumOfHour = sumOfHour;
        this.place = place;
        this.dateOfDay = dateOfDay;
        this.note = note;
        this.issue="Žiadny nebol uvedení";
    }

    //with issues
    public Hour(Double sumOfHour, String place, LocalDate dateOfDay, String note, String issue) {
        this.sumOfHour = sumOfHour;
        this.place = place;
        this.dateOfDay = dateOfDay;
        this.note = note;
        this.issue = issue;
    }

    @Override
    public String toString() {
        return "Hour{" +
                "id=" + id +
                ", sumOfHour=" + sumOfHour +
                ", place='" + place + '\'' +
                ", dateOfDay=" + dateOfDay +
                ", note='" + note + '\'' +
                ", issue='" + issue + '\'' +
                '}';
    }
}
