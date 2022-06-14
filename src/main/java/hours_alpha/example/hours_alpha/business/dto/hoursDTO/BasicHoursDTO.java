package hours_alpha.example.hours_alpha.business.dto.hoursDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BasicHoursDTO {

    private Integer numberOfHours;
    private String workPlace;
    private String todaysDate;
}
