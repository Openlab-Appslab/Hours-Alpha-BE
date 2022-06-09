package hours_alpha.example.hours_alpha.business.company;

import hours_alpha.example.hours_alpha.business.dto.companyDTO.CompanyBasicDTO;
import hours_alpha.example.hours_alpha.business.dto.companyDTO.BasicCompanyDTO;
import hours_alpha.example.hours_alpha.business.employee.Employee;
import hours_alpha.example.hours_alpha.business.employer.Employer;
import hours_alpha.example.hours_alpha.dataAccess.company.CompanyRepository;
import hours_alpha.example.hours_alpha.dataAccess.employee.EmployeeRepository;
import hours_alpha.example.hours_alpha.dataAccess.employer.EmployerRepository;
import hours_alpha.example.hours_alpha.exception.CompanyDoesntExists;
import hours_alpha.example.hours_alpha.exception.PresentVariableIsNull;
import hours_alpha.example.hours_alpha.exception.UserNotFoundByEmailException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CompanyService {

    private final EmployerRepository employerRepository;
    private final EmployeeRepository employeeRepository;
    private final CompanyRepository companyRepository;

    public CompanyBasicDTO createCompany(BasicCompanyDTO creationCompanyDTO){

        Optional<Employer> employer = employerRepository.findByEmail(creationCompanyDTO.getEmail());
        if(employer.isPresent()){

            if(companyRepository.findByName(creationCompanyDTO.getName()).isEmpty()){

                //CREATING AND SAVING COMPANY
                Company company = new Company(
                        creationCompanyDTO.getName(),
                        creationCompanyDTO.getIco(),
                        employer.get()
                );
                companyRepository.save(company);

                //SAVING COMPANY TO EMPLOYER
                employer.get().setCompany(company);
                employerRepository.save(employer.get());

                return convertCompanyToCompanyBasicDTO(employer.get(), company);

            }else{
                throw new CompanyDoesntExists("Firma s týmto menom nexxistuje! Meno: "+creationCompanyDTO.getName()); //EXC
            }
        }else{
            throw  new UserNotFoundByEmailException("Uživateľ s týmto emailom nebol nájdení. Email: "+ creationCompanyDTO.getEmail()); //EXC
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

        Optional<Company> companyOptional = companyRepository.findByName(name);

        if(companyOptional.isPresent()){

            Optional<Employee> employeeOptional = employeeRepository.findByEmail(email);

            if(employeeOptional.isPresent()){
                companyOptional.get().getListOfEmployees().add(employeeOptional.get());

                employeeOptional.get().setCompany(companyOptional.get());

                employeeRepository.save(employeeOptional.get());
                companyRepository.save(companyOptional.get());

                Optional<Employer> employerOptional = employerRepository.findByEmail(companyOptional.get().getEmployer().getEmail());

                if(employerOptional.isPresent()){
                    return convertCompanyToCompanyBasicDTO(employerOptional.get(), companyOptional.get());
                }else{
                    throw new UserNotFoundByEmailException("Pouzivatel s danym emailom nexxistuje! "+email);
                }
            }else{
                throw new UserNotFoundByEmailException("Pouzivatel s danym emailom nexxistuje! "+email);
            }

        }else {
            throw new CompanyDoesntExists("Firma s danym menom nexxistuje: "+name);
        }
    }

    public Company getCompanyByName(String name){
        Optional<Company> companyOptional = companyRepository.findByName(name);

        if(companyOptional.isPresent()) {
            return companyOptional.get();
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

