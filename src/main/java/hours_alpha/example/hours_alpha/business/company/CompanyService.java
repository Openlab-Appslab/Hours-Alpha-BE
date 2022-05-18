package hours_alpha.example.hours_alpha.business.company;

import hours_alpha.example.hours_alpha.business.dto.companyDTO.CreationCompanyDTO;
import hours_alpha.example.hours_alpha.business.employer.Employer;
import hours_alpha.example.hours_alpha.dataAccess.company.CompanyRepository;
import hours_alpha.example.hours_alpha.dataAccess.employer.EmployerRepository;
import hours_alpha.example.hours_alpha.exception.CompanyAlreadyExists;
import hours_alpha.example.hours_alpha.exception.CompanyDoesntExists;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CompanyService {

    private final EmployerRepository employerRepository;
    private final CompanyRepository companyRepository;

    public Company createCompany(CreationCompanyDTO creationCompanyDTO){

        Employer employer = employerRepository.findByEmail(creationCompanyDTO.getEmail());

        Optional<Company> optionalCompany = companyRepository.findByName(creationCompanyDTO.getName());

        if (optionalCompany.isPresent()) {
            throw new CompanyAlreadyExists("Firma s danym menom uz existuje! MENO: "+creationCompanyDTO.getName());
        }else {
            Company company = new Company(
                    creationCompanyDTO.getName(),
                    creationCompanyDTO.getIco(),
                    employer
            );

            employer.setCompany(company);

            companyRepository.save(company);
            employerRepository.save(employer);

            return company;
        }

    }

    public Optional<Company> getCompanyByName(String name){
        Optional<Company> company = companyRepository.findByName(name);

        if(company.isPresent()) {
            return company;
        }else{
            throw new CompanyDoesntExists("Firma s meno "+name+" nexxistuje");
        }
    }

    public Company updateCompany(Company company){
        return companyRepository.save(company);
    }

    public void deleteCompany(String name){
        companyRepository.deleteByName(name);
    }
}

