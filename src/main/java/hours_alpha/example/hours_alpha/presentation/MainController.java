package hours_alpha.example.hours_alpha.presentation;

import hours_alpha.example.hours_alpha.business.company.Company;
import hours_alpha.example.hours_alpha.business.company.CompanyService;
import hours_alpha.example.hours_alpha.business.dto.companyDTO.AddNewEmployeeToCompanyDTO;
import hours_alpha.example.hours_alpha.business.dto.companyDTO.CompanyBasicDTO;
import hours_alpha.example.hours_alpha.business.dto.companyDTO.CreationCompanyDTO;
import hours_alpha.example.hours_alpha.business.dto.userDTO.LoginDTO;
import hours_alpha.example.hours_alpha.business.dto.userDTO.UserBasicDTO;
import hours_alpha.example.hours_alpha.business.dto.userDTO.UserRegistrationDTO;
import hours_alpha.example.hours_alpha.business.employee.Employee;
import hours_alpha.example.hours_alpha.business.employee.EmployeeService;
import hours_alpha.example.hours_alpha.business.employer.Employer;
import hours_alpha.example.hours_alpha.business.employer.EmployerService;
import hours_alpha.example.hours_alpha.exception.CompanyDoesntExists;
import hours_alpha.example.hours_alpha.exception.UserNotFoundByEmailException;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class MainController {

    private final EmployeeService employeeService;
    private final EmployerService employerService;
    private final CompanyService companyService;

    /////////////////////////////////
    //EMPLOYEE PART
    ////////////////////////////////

    @GetMapping(path = "/noAuth/getAllEmployees")
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    /////////////////////////////////
    //EMPLOYER PART
    ////////////////////////////////

    @PostMapping(path = "/noAuth/registration")
    public UserBasicDTO addNewUser(@RequestBody UserRegistrationDTO newUser){

       if(newUser.getStateEmployer()) {
           return employerService.addNewEmployer(newUser);
       }else if (!newUser.getStateEmployer()){
           return employeeService.addNewEmployee(newUser);
       }else{
           return null;
       }
    }

    @PostMapping(path = "/Auth/login")
    public UserBasicDTO login(
            @RequestBody LoginDTO loginDTO){

        Employer employer = employerService.loginGetUserByEmail(loginDTO.getEmail());
        Employee employee = employeeService.loginGetUserByEmail(loginDTO.getEmail());

        if(employee != null){
            return employeeService.convertToUserBasicDTO(employee);
        }else if (employer != null){
            return employerService.convertToUserBasicDTO(employer);
        }else{
            throw new UserNotFoundByEmailException("Použivateľ s emailom: "+" nebol najdení!");
        }

    }

    /////////////////////////////////
    //COMPANY PART
    ////////////////////////////////

    @PostMapping(path = "/employer/createCompany")
    public CompanyBasicDTO createCompany(@RequestBody CreationCompanyDTO creationCompanyDTO){
        return companyService.createCompany(creationCompanyDTO);
    }


    @GetMapping(path = "/employer/showInfoAboutCompany")
    @ResponseBody
    public CompanyBasicDTO showInfoAboutCompany(@RequestBody LoginDTO loginDTO){
        Employer employer = employerService.getUserByEmail(loginDTO.getEmail());

        if(employer != null)
        {
            Company company = companyService.getCompanyByName(employer.getCompany().getName());
            if(company != null) {
                return companyService.convertCompanyToCompanyBasicDTO(employer, company);
            }else{
              throw new CompanyDoesntExists("Tento pouzivatel firmu nema!");
            }
        }else{
            throw new UserNotFoundByEmailException("Pouzivatel nexxistuje s tymto emailom: "+ loginDTO.getEmail());
        }
    }

    @PutMapping(path = "/employee/addEmployeeToCompany")
    public CompanyBasicDTO addNewEmployeeToCompany(@RequestBody AddNewEmployeeToCompanyDTO addNewEmployeeToCompanyDTO){

        return companyService.addEmployeeToCompany(addNewEmployeeToCompanyDTO.name, addNewEmployeeToCompanyDTO.getEmail());
    }


}
