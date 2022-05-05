package hours_alpha.example.hours_alpha.presentation;

import hours_alpha.example.hours_alpha.business.employee.Employee;
import hours_alpha.example.hours_alpha.business.employee.EmployeeService;
import hours_alpha.example.hours_alpha.business.employer.Employer;
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

    /////////////////////////////////
    //EMPLOYEE PART
    ////////////////////////////////

    @GetMapping(path = "/noAuth/getAllEmployees")
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @PostMapping(path = "/noAuth/addNewEmployee")
    public Employee addNewEmployee(@RequestBody Employee employee){
        return employeeService.addNewEmployee(employee);
    }

    /////////////////////////////////
    //EMPLOYER PART
    ////////////////////////////////

    @GetMapping(path = "/noAuth/addNewEmployer")
    public Employer addNewEmployer(@RequestBody Employer employer){
        return employerService.addNewEmployer(employer);
    }
}
