package hours_alpha.example.hours_alpha.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class UserNotFoundByEmailException extends RuntimeException{
    public UserNotFoundByEmailException(String message){
        super(message);
    }
}
