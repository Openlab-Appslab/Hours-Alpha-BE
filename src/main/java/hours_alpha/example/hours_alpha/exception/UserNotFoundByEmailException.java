package hours_alpha.example.hours_alpha.exception;

public class UserNotFoundByEmailException extends RuntimeException{

    public UserNotFoundByEmailException(String message){
        super(message);
    }
}
