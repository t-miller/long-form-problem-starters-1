package model;

import exceptions.*;

/**
 * A coffee maker used to train baristas.
 *
 * Class invariant: cups remaining >= 0, time since last brew >= 0
 */

public class CoffeeMaker {

    public CoffeeMaker(){
        // TODO: complete the implementation of this method
    }

    // getters
    public int getTimeSinceLastBrew() {
        // TODO: complete the implementation of this method
        return 0;
    }
    public int getCupsRemaining() {
        // TODO: complete the implementation of this method
        return 0;
    }

    // EFFECTS: return true if there are coffee cups remaining
    //          otherwise, throws NoCupsRemainingException
    public boolean areCupsRemaining() throws NoCupsRemainingException {
        // TODO: complete the implementation of this method
        return false;
    }

    //REQUIRES: a non-negative integer
    //EFFECTS: sets time since last brew
    public void setTimeSinceLastBrew(int time) {
        // TODO: complete the implementation of this method
    }

    //EFFECTS: sets cups remaining to full (20 cups) and time since last brew to 0,
    //          throws TooManyBeansException if beans >2.6 cups, throws NotEnoughBeansException if beans<2.4 cups
    //          throws WaterException if cups <= 14.75 cups
    public void brew(double beans, double water) throws TooManyBeansException, NotEnoughBeansException, WaterException {
        // TODO: complete the implementation of this method
    }

    //MODIFIES: this
    //EFFECTS: subtracts one cup from cups remaining
    //          throws NoCupsRemainingException is cups <=0,
    //          throws StaleCoffeeException if time since last brew >=60
    public void pourCoffee() throws NoCupsRemainingException, StaleCoffeeException{
        // TODO: complete the implementation of this method
    }


}
