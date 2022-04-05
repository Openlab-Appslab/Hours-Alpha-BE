package hours_alpha.example.hours_alpha.business.security;

import hours_alpha.example.hours_alpha.business.employee.EmployeeService;
import hours_alpha.example.hours_alpha.business.employer.EmployerService;
import hours_alpha.example.hours_alpha.business.security.entityModel.EntityModelDetailsServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import java.util.List;

@AllArgsConstructor
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final EmployerService employerService;
    private final EmployeeService employeeService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .cors().and()
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/noAuth/*").permitAll()
                .anyRequest().fullyAuthenticated()
                .and()
                .httpBasic();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(new EntityModelDetailsServiceImpl<>(
                List.of(employerService, employeeService)
        ));
    }
}
