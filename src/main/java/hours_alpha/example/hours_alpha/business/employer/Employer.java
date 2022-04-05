package hours_alpha.example.hours_alpha.business.employer;

import hours_alpha.example.hours_alpha.business.entity.EntityModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Employer extends EntityModel {

    public Employer(String email, String firstName, String lastName, String password) {
        super(email, firstName, lastName, password, "ROLE_EMPLOYER");
    }
}
