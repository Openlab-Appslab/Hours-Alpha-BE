package hours_alpha.example.hours_alpha.presentation.employee;

import hours_alpha.example.hours_alpha.business.employee.Employee;
import hours_alpha.example.hours_alpha.business.employee.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping(path = "/noAuth/getAllEmployees")
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @PostMapping(path = "/noAuth/addNewEmployee")
    public Employee addNewEmployee(@RequestBody Employee employee){
        return employeeService.addNewEmployee(employee);
    }

    @GetMapping(path = "/noAuth/example1")
    public String example1(){
        return "JEDE TO! / no authorization";
    }

    @GetMapping(path = "/Auth/example2")
    public String example2(){
        return "JEDE TO! / authorization";
    }

    @PostMapping(path = "/noAuth/example3")
    public String example3(){
        return "noooo ides?";
    }

    @GetMapping(path = "/Auth/Login")
    public void login(){}
}
