package hours_alpha.example.hours_alpha.business.company;

import hours_alpha.example.hours_alpha.dataAccess.company.CompanyRepository;
import hours_alpha.example.hours_alpha.dataAccess.employer.EmployerRepository;
import hours_alpha.example.hours_alpha.exception.CompanyDoesntExists;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CompanyService {

    private final EmployerRepository employerRepository;
    private final CompanyRepository companyRepository;

    public Company createCompany(Company company){
        return companyRepository.save(company);
    }

    public Company getCompanyByName(String name){
        Company company = companyRepository.findByName(name);

        if(company != null) {
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

