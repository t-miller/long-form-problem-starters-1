package model;

import exceptions.*;

/**
 * A coffee maker used to train baristas.
 *
 * Class invariant: cups remaining >= 0, time since last brew >= 0
 */

public class CoffeeMaker {

    private int cupsRemaining;
    private int timeSinceLastBrew;

    // EFFECTS:
    public CoffeeMaker(){
        cupsRemaining = 0;
        timeSinceLastBrew = 0;
    }

    // getters
    public int getTimeSinceLastBrew() {
        return timeSinceLastBrew;
    }
    public int getCupsRemaining() {
        return cupsRemaining;
    }

    // EFFECTS: return true if there are coffee cups remaining
    //          otherwise, throws NoCupsRemainingException
    public boolean areCupsRemaining(){
        return cupsRemaining > 0;
    }

    //REQUIRES: a non-negative integer
    //EFFECTS: sets time since last brew
    public void setTimeSinceLastBrew(int time) {
        this.timeSinceLastBrew = time;
    }

    //EFFECTS: sets cups remaining to full (20 cups) and time since last brew to 0,
    //          throws TooManyBeansException if beans >2.6 cups, throws NotEnoughBeansException if beans<2.4 cups
    //          throws WaterException if cups <= 14.75 cups
    public void brew(double beans, double water) throws TooManyBeansException, NotEnoughBeansException, WaterException {
        if (water <= 14.75){
            throw new WaterException(water);
        }
        if (beans > 2.6){
            throw new TooManyBeansException(beans);
        }
        else{
            if (beans < 2.4){
                throw new NotEnoughBeansException(beans);
            }
            else {
                cupsRemaining = 20;
                timeSinceLastBrew = 0;
            }
        }
    }

    //MODIFIES: this
    //EFFECTS: subtracts one cup from cups remaining
    //          throws NoCupsRemainingException is cups <=0,
    //          throws StaleCoffeeException if time since last brew >=60
    public void pourCoffee() throws NoCupsRemainingException, StaleCoffeeException{
        if (cupsRemaining <= 0){
            throw new NoCupsRemainingException();
        }

        if (timeSinceLastBrew >= 60) {
            throw new StaleCoffeeException(timeSinceLastBrew);
        }

        cupsRemaining--;
    }


}
