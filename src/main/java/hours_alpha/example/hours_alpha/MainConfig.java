package hours_alpha.example.hours_alpha;

import hours_alpha.example.hours_alpha.business.company.Company;
import hours_alpha.example.hours_alpha.business.company.CompanyService;
import hours_alpha.example.hours_alpha.business.employee.Employee;
import hours_alpha.example.hours_alpha.business.employee.EmployeeService;
import hours_alpha.example.hours_alpha.business.employer.Employer;
import hours_alpha.example.hours_alpha.business.employer.EmployerService;
import hours_alpha.example.hours_alpha.business.hour.HourService;
import hours_alpha.example.hours_alpha.dataAccess.company.CompanyRepository;
import hours_alpha.example.hours_alpha.dataAccess.employee.EmployeeRepository;
import hours_alpha.example.hours_alpha.dataAccess.employer.EmployerRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AllArgsConstructor
public class MainConfig {

    @Bean
    CommandLineRunner commandLineRunner (EmployeeRepository employeeRepository, EmployeeService employeeService, EmployerService employerService, CompanyService companyService, HourService hourService, EmployerRepository employerRepository, CompanyRepository companyRepository){
        return args -> {
            Employee employee1 = new Employee("jozko@gmail.com","Jojko","TV", "1234");
//            Employee employee2 = new Employee("mrkvicka@gmail.com","Peto","Mrkva","1234");
//            Employee employee3 = new Employee("tehla@gmail.com","Beton","Tehla", "1234");

            //employeeService.addNewEmployee(employee1);
//            employeeService.addNewEmployee(employee2);
//            employeeService.addNewEmployee(employee3);

            Employer employer = new Employer("mato@gmail.com", "Mato", "ST", "1234");

            Employer returnEmployer = employerService.getUserByEmail(employer.getEmail());
            Company company = new Company("Firma","Zilina", "21323", employer);

            //listOfHours.add(new Hour(10.0, "Zilina", LocalDate.of(2022,2,10), "Nothing", "Noone"));

//            employee.setListOfHourFebruary(listOfHours);
//
//            employeeRepository.save(employee);
//
//            Employee employee2 = employeeService.getUserByEmail("jozko@gmail.com");
//
//            System.out.println(employee2.getEmail());
        };
    }
}
