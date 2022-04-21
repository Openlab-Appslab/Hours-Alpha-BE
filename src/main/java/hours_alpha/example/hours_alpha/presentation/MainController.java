package hours_alpha.example.hours_alpha.presentation;

import hours_alpha.example.hours_alpha.business.employee.Employee;
import hours_alpha.example.hours_alpha.business.employee.EmployeeService;
import hours_alpha.example.hours_alpha.business.employer.EmployerService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    @GetMapping(path = "/noAuth/getAllEmployees")
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @PostMapping(path = "/noAuth/addNewEmployee")
    public Employee addNewEmployee(@RequestBody Employee employee){
        return employeeService.addNewEmployee(employee);
    }

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
    public void showCompany(){

    }
}
