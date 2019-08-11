package be.haraka.game4.Exceptions;

/**
 * Unchecked exception that will crash the program.
 * As if the map is not correctly loaded, we can't
 * continue the game.
 *
 * @author GriffinBabe
 */
public class MapFormatException extends RuntimeException {

    public MapFormatException(String errorMessage) {
        super(errorMessage);
    }

}
