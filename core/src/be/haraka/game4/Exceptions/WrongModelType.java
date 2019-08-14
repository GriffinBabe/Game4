package be.haraka.game4.Exceptions;

public class WrongModelType extends RuntimeException {

    public WrongModelType(String errorMessage) {
        super(errorMessage);
    }
}
