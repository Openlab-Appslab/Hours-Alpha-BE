package hours_alpha.example.hours_alpha.dataAccess.hours;

import hours_alpha.example.hours_alpha.business.hour.Hour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HoursRepository extends JpaRepository<Hour, Long> {
}
