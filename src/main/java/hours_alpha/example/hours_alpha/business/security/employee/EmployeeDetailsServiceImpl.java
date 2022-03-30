package hours_alpha.example.hours_alpha.business.security.employee;

import hours_alpha.example.hours_alpha.business.employee.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeeDetailsServiceImpl implements UserDetailsService {

    private final EmployeeService employeeService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return this.employeeService.getEmployeeByEmail(email)
                .map(EmployeeDetailsImpl::new)
                .orElseThrow(() -> new UsernameNotFoundException(email));
    }
}
