package hours_alpha.example.hours_alpha.presentation;

import hours_alpha.example.hours_alpha.business.employee.EmployeeService;
import hours_alpha.example.hours_alpha.business.employer.EmployerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class MainController {

    private final EmployeeService employeeService;
    private final EmployerService employerService;

    @GetMapping(path = "/employee/example11")
    public String example1(){
        return "jede to";
    }

    @GetMapping(path = "/employer/example11")
    public String example2(){
        return "jede to";
    }
}
