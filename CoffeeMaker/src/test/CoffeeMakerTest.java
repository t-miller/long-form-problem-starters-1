package test;

import exceptions.*;
import model.CoffeeMaker;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.fail;


public class CoffeeMakerTest {
    private CoffeeMaker cm;

    @Before
    public void setUp(){
        cm = new CoffeeMaker();
    }
    @Test
    public void testConstructor(){
        assertEquals(cm.getTimeSinceLastBrew(), cm.getCupsRemaining(), 0);
    }
    @Test (expected = NotEnoughBeansException.class)
    public void TestBrewNotEnoughBeans() throws NotEnoughBeansException, TooManyBeansException, WaterException {
        cm.brew(2.3, 14.76);
    }
    @Test (expected = TooManyBeansException.class)
    public void TestBrewFailTooManyBeans() throws NotEnoughBeansException, TooManyBeansException, WaterException {
        cm.brew(2.7, 14.76);
    }
    @Test (expected = WaterException.class)
    public void TestBrewFailNotEnoughWater() throws NotEnoughBeansException, TooManyBeansException, WaterException {
        cm.brew(2.6, 2);
    }
    @Test (expected = WaterException.class)
    public void TestBrewFailBothParamsWrongThrowWaterFirst() throws NotEnoughBeansException, TooManyBeansException, WaterException {
        cm.brew(2.7, 2);
    }
    @Test
    public void TestBrewPass(){
        try{
            brewCoffee();
            assertEquals(20, cm.getCupsRemaining());
            assertEquals(0, cm.getTimeSinceLastBrew());
        }
        catch (Exception e){
            fail();
        }
    }
    @Test (expected = NoCupsRemainingException.class)
    public void TestPourCoffeeFailNoCups() throws NoCupsRemainingException, StaleCoffeeException, NotEnoughBeansException, TooManyBeansException, WaterException {
        brewCoffee();
        pour20COffees();
        cm.pourCoffee();
    }
    @Test (expected = StaleCoffeeException.class)
    public void TestPourCoffeeFailStaleCoffee() throws NoCupsRemainingException, StaleCoffeeException, NotEnoughBeansException, TooManyBeansException, WaterException {
        brewCoffee();
        cm.setTimeSinceLastBrew(60);
        cm.pourCoffee();
    }
    @Test (expected = NoCupsRemainingException.class)
    public void TestPourCoffeeFailBothParamsWrongNoCupsFirst() throws NoCupsRemainingException, StaleCoffeeException, NotEnoughBeansException, TooManyBeansException, WaterException {
        brewCoffee();
        pour20COffees();
        cm.pourCoffee();
        cm.setTimeSinceLastBrew(60);
        cm.pourCoffee();
    }
    @Test
    public void TestPourCoffeePass() throws NotEnoughBeansException, TooManyBeansException, WaterException {
        brewCoffee();
        try{
            cm.pourCoffee();
            assertEquals(19, cm.getCupsRemaining());
        }
        catch (Exception e){
            fail();
        }

    }

    public void brewCoffee() throws NotEnoughBeansException, TooManyBeansException, WaterException {
        cm.brew(2.5, 17);
    }

    public void pour20COffees() throws NoCupsRemainingException, StaleCoffeeException {
        for (int i = 20; i >= 0; i--){
            cm.pourCoffee();
        }
    }
}
