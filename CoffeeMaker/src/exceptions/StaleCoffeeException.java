package exceptions;

public class StaleCoffeeException extends Exception {
    private int timeSinceLastBrew;

    public StaleCoffeeException(int timeSinceLastBrew){
        super(timeSinceLastBrew + " is too long since last brew.");
    }
}
