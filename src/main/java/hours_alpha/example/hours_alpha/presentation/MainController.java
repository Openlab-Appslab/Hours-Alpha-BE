package hours_alpha.example.hours_alpha.presentation;

import hours_alpha.example.hours_alpha.business.company.Company;
import hours_alpha.example.hours_alpha.business.company.CompanyService;
import hours_alpha.example.hours_alpha.business.dto.companyDTO.AddNewEmployeeToCompanyDTO;
import hours_alpha.example.hours_alpha.business.dto.companyDTO.CompanyBasicDTO;
import hours_alpha.example.hours_alpha.business.dto.companyDTO.BasicCompanyDTO;
import hours_alpha.example.hours_alpha.business.dto.hoursDTO.BasicHoursDTO;
import hours_alpha.example.hours_alpha.business.dto.userDTO.LoginResponse;
import hours_alpha.example.hours_alpha.business.dto.userDTO.UserBasicDTO;
import hours_alpha.example.hours_alpha.business.dto.userDTO.UserRegistrationDTO;
import hours_alpha.example.hours_alpha.business.employee.Employee;
import hours_alpha.example.hours_alpha.business.employee.EmployeeService;
import hours_alpha.example.hours_alpha.business.employer.Employer;
import hours_alpha.example.hours_alpha.business.employer.EmployerService;
import hours_alpha.example.hours_alpha.business.hour.Hour;
import hours_alpha.example.hours_alpha.business.hour.HourService;
import hours_alpha.example.hours_alpha.exception.CompanyDoesntExists;
import hours_alpha.example.hours_alpha.exception.UserNotFoundByEmailException;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class MainController {

    private final EmployeeService employeeService;
    private final EmployerService employerService;
    private final CompanyService companyService;
    private final HourService hourService;

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

    // Authentication je objekt, ktorý ti sem dodá Spring Security, je to vlastne aktuálne prihlásený user
    @GetMapping(path = "/Auth/login")
    public LoginResponse login(Authentication authentication) {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        boolean isEmployer =
                userDetails.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_EMPLOYER"));

        return new LoginResponse(isEmployer);
    }

    /////////////////////////////////
    //COMPANY PART
    ////////////////////////////////

    @PostMapping(path = "/employer/createCompany")
    public CompanyBasicDTO createCompany(@RequestBody BasicCompanyDTO creationCompanyDTO){
        return companyService.createCompany(creationCompanyDTO);
    }


    @GetMapping(path = "/employer/showInfoAboutCompany")
    @ResponseBody
    public CompanyBasicDTO showInfoAboutCompany(Authentication authentication) {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        Employer employer = employerService.getUserByEmail(userDetails.getUsername());

        if(employer != null)
        {
            Company company = companyService.getCompanyByName(employer.getCompany().getName());
            if(company != null) {
                return companyService.convertCompanyToCompanyBasicDTO(employer, company);
            }else{
              throw new CompanyDoesntExists("Tento pouzivatel firmu nema!");
            }
        }else{
            throw new UserNotFoundByEmailException(
                    "Pouzivatel nexxistuje s tymto emailom: " + userDetails.getUsername());
        }
    }

    @PutMapping(path = "/employee/addEmployeeToCompany")
    public CompanyBasicDTO addNewEmployeeToCompany(@RequestBody AddNewEmployeeToCompanyDTO addNewEmployeeToCompanyDTO){

        return companyService.addEmployeeToCompany(addNewEmployeeToCompanyDTO.name, addNewEmployeeToCompanyDTO.getEmail());
    }

    /////////////////////////////////
    //HOURS PART
    ////////////////////////////////

    @PostMapping(path = "/employee/addWorkInfo")
    public BasicHoursDTO addWorkInfoToEmployee(@RequestBody BasicHoursDTO basicHoursDTO, Authentication authentication){
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        return hourService.addNewHoursToUser(basicHoursDTO, userDetails.getUsername());
    }

    @GetMapping(path = "/employee/showAllWorkInfo")
    public List<BasicHoursDTO> showAllWorkInfo(Authentication authentication){
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        return hourService.getAllHoursFromUser(userDetails.getUsername());
    }


}
