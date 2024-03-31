package Exception;

public class SOFException extends Exception{
    private SOFExceptionType sofExceptionType;
    public SOFException(SOFExceptionType sofExceptionType,String message) {
        super(message);
        this.sofExceptionType = sofExceptionType;
    }
    public String getMessage() {
        return super.getMessage();
    }
}
