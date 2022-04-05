package hours_alpha.example.hours_alpha;

import hours_alpha.example.hours_alpha.business.employee.Employee;
import hours_alpha.example.hours_alpha.business.employee.EmployeeService;
import hours_alpha.example.hours_alpha.dataAccess.employee.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@Configuration
@AllArgsConstructor
public class MainConfig {

    @Bean
    CommandLineRunner commandLineRunner (EmployeeService employeeService){
        return args -> {
            Employee employee1 = new Employee("jozko@gmail.com","Jojko","TV", "1234");
            Employee employee2 = new Employee("mrkvicka@gmail.com","Peto","Mrkva","1234");
            Employee employee3 = new Employee("tehla@gmail.com","Beton","Tehla", "1234");

            employeeService.addNewEmployee(employee1);
            employeeService.addNewEmployee(employee2);
            employeeService.addNewEmployee(employee3);


        };
    }
}
