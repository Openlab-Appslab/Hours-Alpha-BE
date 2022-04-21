package hours_alpha.example.hours_alpha.exception;

public class CompanyAlreadyExists extends RuntimeException {
    public CompanyAlreadyExists(String message){
        super(message);
    }
}
