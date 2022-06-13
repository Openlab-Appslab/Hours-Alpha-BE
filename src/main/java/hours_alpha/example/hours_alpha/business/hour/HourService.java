package hours_alpha.example.hours_alpha.business.hour;

import hours_alpha.example.hours_alpha.business.dto.hoursDTO.BasicHoursDTO;
import hours_alpha.example.hours_alpha.business.employee.Employee;
import hours_alpha.example.hours_alpha.dataAccess.employee.EmployeeRepository;
import hours_alpha.example.hours_alpha.dataAccess.hours.HoursRepository;
import hours_alpha.example.hours_alpha.exception.UserNotFoundByEmailException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class HourService {

    private final EmployeeRepository employeeRepository;
    private final HoursRepository hoursRepository;

    public List<BasicHoursDTO> getAllHoursFromUser(String email){
        Optional<Employee> employeeOptional = employeeRepository.findByEmail(email);

        if(employeeOptional.isPresent()){

            List<BasicHoursDTO> listOfHoursDTO = new ArrayList<>();

            employeeOptional.get().getHours().forEach((e) ->{
             listOfHoursDTO.add(convertToHoursToBasicHours(e));
            });

            return listOfHoursDTO;
        }else{
            throw new UserNotFoundByEmailException("Uživateľ nebol najdený!");
        }
    }

    public BasicHoursDTO getHoursByDateOfDay(String email, LocalDate localDate){
        return null;
    }

    public BasicHoursDTO addNewHoursToUser(BasicHoursDTO basicHoursDTO, String email){
        Optional<Employee> employeeOptional = employeeRepository.findByEmail(email);

        if(employeeOptional.isPresent()){
            Hour hour = new Hour(
                    basicHoursDTO.getHours(),
                    basicHoursDTO.getPlace());

            hour.setEmployee(employeeOptional.get());
            employeeOptional.get().getHours().add(hour);

            hoursRepository.save(hour);
            employeeRepository.save(employeeOptional.get());

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
                hour.getId(),
                hour.getSumOfHour(),
                hour.getPlace());
    }
}
