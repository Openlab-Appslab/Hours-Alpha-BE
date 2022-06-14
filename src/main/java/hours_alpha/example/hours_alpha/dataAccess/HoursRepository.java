package hours_alpha.example.hours_alpha.dataAccess;

import hours_alpha.example.hours_alpha.business.hour.Hour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HoursRepository extends JpaRepository<Hour, Long> {
}
