package hours_alpha.example.hours_alpha.dataAccess.company;

import hours_alpha.example.hours_alpha.business.company.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

    void deleteByName(String name);

    Optional<Company> findByName(String name);
}
