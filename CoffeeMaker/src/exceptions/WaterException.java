package exceptions;

public class WaterException extends Exception {
    private double cupsOfWater;

    public WaterException(double cupsOfWater){
        super(cupsOfWater + " is not enough water.");
    }
}
