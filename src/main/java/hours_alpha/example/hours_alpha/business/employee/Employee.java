package hours_alpha.example.hours_alpha.business.employee;


import hours_alpha.example.hours_alpha.business.entity.EntityModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Employee extends EntityModel {

    public Employee(String email, String firstName, String  lastName, String password) {
        super(email, firstName, lastName, password);
    }
}
