package hours_alpha.example.hours_alpha.business.employee.dto;

import hours_alpha.example.hours_alpha.business.company.Company;
import hours_alpha.example.hours_alpha.business.hour.Hour;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeGetBasicInfoDTO {
    private String email;
    private String firstName;
    private String lastName;
    private Company company;
    private List<Hour> listOfHours;
}
