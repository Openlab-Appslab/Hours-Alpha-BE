package hours_alpha.example.hours_alpha.business.company;

import hours_alpha.example.hours_alpha.business.dto.companyDTO.CompanyBasicDTO;
import hours_alpha.example.hours_alpha.business.dto.companyDTO.CreationCompanyDTO;
import hours_alpha.example.hours_alpha.business.employee.Employee;
import hours_alpha.example.hours_alpha.business.employer.Employer;
import hours_alpha.example.hours_alpha.dataAccess.company.CompanyRepository;
import hours_alpha.example.hours_alpha.dataAccess.employee.EmployeeRepository;
import hours_alpha.example.hours_alpha.dataAccess.employer.EmployerRepository;
import hours_alpha.example.hours_alpha.exception.CompanyAlreadyExists;
import hours_alpha.example.hours_alpha.exception.CompanyDoesntExists;
import hours_alpha.example.hours_alpha.exception.PresentVariableIsNull;
import hours_alpha.example.hours_alpha.exception.UserNotFoundByEmailException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CompanyService {

    private final EmployerRepository employerRepository;
    private final EmployeeRepository employeeRepository;
    private final CompanyRepository companyRepository;

    public Company createCompany(CreationCompanyDTO creationCompanyDTO){

        Employer employer = employerRepository.findByEmail(creationCompanyDTO.getEmail());

        Company company = companyRepository.findByName(creationCompanyDTO.getName());

        if (company != null) {

            employer.setCompany(company);

            companyRepository.save(company);
            employerRepository.save(employer);

            return company;

        }else {
            throw new CompanyAlreadyExists("Firma s danym menom uz existuje! MENO: "+creationCompanyDTO.getName());
        }

    }

    public CompanyBasicDTO convertCompanyToCompanyBasicDTO(Employer employer, Company company){

        if(company != null){
            return new CompanyBasicDTO(
                    company.getName(),
                    company.getListOfEmployees().size(),
                    employer.getFirstName(),
                    employer.getLastName(),
                    employer.getEmail()
            );
        }else{
            throw new PresentVariableIsNull("Sending variable is null!");
        }

    }

    public CompanyBasicDTO addEmployeeToCompany(String name, String email){

        Company company = companyRepository.findByName(name);

        if(company != null){

            Employee employee = employeeRepository.findByEmail(email);

            if(employee != null){
                company.getListOfEmployees().add(employee);

                employee.setCompany(company);

                employeeRepository.save(employee);
                companyRepository.save(company);

                return convertCompanyToCompanyBasicDTO(employerRepository.findByEmail(company.getEmployer().getEmail()), company);

            }else{
                throw new UserNotFoundByEmailException("Pouzivatel s danym emailom nexxistuje! "+email);
            }

        }else {
            throw new CompanyDoesntExists("Firma s danym menom nexxistuje: "+name);
        }
    }

    public Company getOptionalCompanyByName(String name){
        Company company = companyRepository.findByName(name);

        if(company != null) {
            return company;
        }else{
            throw new CompanyDoesntExists("Firma s menom "+name+" nexxistuje");
        }
    }

    public Company updateCompany(Company company){
        return companyRepository.save(company);
    }

    public void deleteCompany(String name){
        companyRepository.deleteByName(name);
    }
}

