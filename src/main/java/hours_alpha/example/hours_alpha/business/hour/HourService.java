package hours_alpha.example.hours_alpha.business.hour;

import hours_alpha.example.hours_alpha.business.dto.hoursDTO.BasicHoursDTO;
import hours_alpha.example.hours_alpha.business.employee.Employee;
import hours_alpha.example.hours_alpha.dataAccess.employee.EmployeeRepository;
import hours_alpha.example.hours_alpha.exception.UserNotFoundByEmailException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class HourService {

    private final EmployeeRepository employeeRepository;

    public List<BasicHoursDTO> getAllHoursFromUser(String email){
        Employee employee = employeeRepository.findByEmail(email);
        if(employee != null){
            List<Hour> listOfHour = employee.getHours();
            List<BasicHoursDTO> basicHoursDTOList = new ArrayList<>();

            for (Hour hour : listOfHour) {
                basicHoursDTOList.add(convertToHoursToBasicHours(hour));
            }

            return basicHoursDTOList;

        }else{
            throw new UserNotFoundByEmailException("Uživateľ nebol najdený!");
        }
    }

    public BasicHoursDTO getHoursByDateOfDay(String email, LocalDate localDate){
        return null;
    }

    public BasicHoursDTO addNewHoursToUser(BasicHoursDTO basicHoursDTO, String email){
        Employee employee = employeeRepository.findByEmail(email);

        if(employee != null){
            Hour hour = new Hour(
                    basicHoursDTO.getHours(),
                    basicHoursDTO.getPlace(),
                    basicHoursDTO.getDateOfDay()
            );

            employee.getHours().add(hour);
            employeeRepository.save(employee);

            return convertToHoursToBasicHours(hour);

        }else{
            throw new UserNotFoundByEmailException("Uživateľ nebol najdený!");
        }
    }

    @Transactional
    public BasicHoursDTO updateHours(BasicHoursDTO basicHoursDTO){
       return null;
    }

    public void deleteHours(LocalDate localDate){

    }

    public BasicHoursDTO convertToHoursToBasicHours(Hour hour){
        return new BasicHoursDTO(
                hour.getSumOfHour(),
                hour.getPlace(),
                hour.getDateOfDay()
        );
    }
}
