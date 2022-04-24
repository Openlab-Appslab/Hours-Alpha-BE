package hours_alpha.example.hours_alpha.business.employee;


import com.fasterxml.jackson.annotation.JsonIgnore;
import hours_alpha.example.hours_alpha.business.company.Company;
import hours_alpha.example.hours_alpha.business.entity.EntityModel;
import hours_alpha.example.hours_alpha.business.hour.Hour;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Employee extends EntityModel {

    @JsonIgnore
    @ManyToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(name = "company")
    private Company company;

   @JsonIgnore
   @OneToMany(
           mappedBy = "employee"
   )
   private List<Hour> listOfHour = new ArrayList<>();

    public Employee(String email, String firstName, String  lastName, String password) {
        super(email, firstName, lastName, password);
    }
}
