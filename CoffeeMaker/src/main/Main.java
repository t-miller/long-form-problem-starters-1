package main;

import exceptions.*;
import model.CoffeeMaker;

public class Main {

    public static void main(String[] args){
        CoffeeMaker cm = new CoffeeMaker();

        // CORRECT
        // brew coffee
        try {
            cm.brew(2.5, 15);
        } catch (TooManyBeansException | NotEnoughBeansException | WaterException e) {
            e.printStackTrace();
        }

        // pour a couple cups
        try {
            cm.pourCoffee();
        } catch (NoCupsRemainingException | StaleCoffeeException e) {
            e.printStackTrace();
        }

        try {
            cm.pourCoffee();
        } catch (NoCupsRemainingException | StaleCoffeeException e) {
            e.printStackTrace();
        }

        // set time since last brew
        cm.setTimeSinceLastBrew(0);


        // INCORRECT
        // brew coffee
        try {
            cm.brew(1, 2);
        } catch (TooManyBeansException | NotEnoughBeansException | WaterException e) {
            e.printStackTrace();
        }

        //add correct amounts
        try {
            cm.brew(2.5, 15);
        } catch (TooManyBeansException | NotEnoughBeansException | WaterException e) {
            e.printStackTrace();
        }

        // pour cups
        try {
            cm.pourCoffee();
        } catch (NoCupsRemainingException | StaleCoffeeException e) {
            e.printStackTrace();
        }

        try {
            cm.pourCoffee();
        } catch (NoCupsRemainingException | StaleCoffeeException e) {
            e.printStackTrace();
        }

        // set time wrong
        cm.setTimeSinceLastBrew(75);

        // pour again
        try {
            cm.pourCoffee();
        } catch (NoCupsRemainingException | StaleCoffeeException e) {
            e.printStackTrace();
        }
    }


}