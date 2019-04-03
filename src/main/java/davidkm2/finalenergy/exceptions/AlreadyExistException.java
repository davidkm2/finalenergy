package davidkm2.finalenergy.exceptions;

public class AlreadyExistException extends RuntimeException {
    public AlreadyExistException(){
        super("Already exist!");
    }
}
