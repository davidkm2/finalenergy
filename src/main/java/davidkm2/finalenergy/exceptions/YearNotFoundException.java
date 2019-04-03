package davidkm2.finalenergy.exceptions;

public class YearNotFoundException extends RuntimeException {
    public YearNotFoundException (String exception){
        super("No entries for that year!");
    }
}
