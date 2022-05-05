package hours_alpha.example.hours_alpha.presentation;

import hours_alpha.example.hours_alpha.business.employee.EmployeeService;
import hours_alpha.example.hours_alpha.business.employer.EmployerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class TextingController {

    private final EmployeeService employeeService;
    private final EmployerService employerService;

    @GetMapping(path = "/noAuth/example1")
    public String example12(){
        return "JEDE TO! / no authorization";
    }

    @GetMapping(path = "/Auth/example2")
    public String example22(){
        return "JEDE TO! / authorization";
    }

    @PostMapping(path = "/noAuth/example3")
    public String example3(){
        return "noooo ides?";
    }

    @GetMapping(path = "/Auth/Login")
    public void login(){}

    @GetMapping(path = "/employer/showCopany")
    public void showCompany(){}

    @GetMapping(path = "/employee/example11")
    public String example1(){
        return "jede to";
    }

    @GetMapping(path = "/employer/example11")
    public String example2(){
        return "jede to";
    }
}
