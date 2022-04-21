package hours_alpha.example.hours_alpha.exception;

public class UsersNotFoundByEmailException extends RuntimeException{

    public UsersNotFoundByEmailException(String message){
        super(message);
    }
}
