package hours_alpha.example.hours_alpha.exception;

public class CompanyDoesntExists extends RuntimeException{
    public CompanyDoesntExists(String message){
        super(message);
    }
}
