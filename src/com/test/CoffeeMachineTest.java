package com.test;


import com.company.CoffeeMachine;
import com.company.Drink;
import com.company.EnumDrink;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by alex on 15/11/2017.
 */
public class CoffeeMachineTest {

    private CoffeeMachine coffeeMachine;

    @Before
    public void setUp() throws Exception {
        coffeeMachine = new CoffeeMachine();
    }

    @Test
    public void OrderEmpty() {
        final Drink locDrink = coffeeMachine.makeDrink("::");
        Assert.assertNull("drink not empty", locDrink);
    }

    @Test
    public void OrderError() {
        final Drink locDrink = coffeeMachine.makeDrink("");
        Assert.assertNull("drink error", locDrink);
    }

    @Test
    public void OrderDrink() {
        coffeeMachine.setMoney(50);
        final Drink locDrink = coffeeMachine.makeDrink("H::");
        Assert.assertNotNull("drink null", locDrink);
    }

    @Test
    public void OrderChocolate(){
        coffeeMachine.setMoney(50);
        final Drink locDrink = coffeeMachine.makeDrink("H::");
        Assert.assertNotNull("drink null",locDrink);
        final Drink locDrinkExpected = new Drink(EnumDrink.CHOCOLATE,0,false);
        Assert.assertEquals("drink error", locDrinkExpected, locDrink);
    }

    @Test
    public void OrderTea(){
        coffeeMachine.setMoney(40);
        final Drink locDrink = coffeeMachine.makeDrink("T::");
        final Drink locDrinkExpected = new Drink(EnumDrink.TEA,0,false);
        Assert.assertEquals("drink error", locDrinkExpected, locDrink);
    }

    @Test
    public void OrderCoffee(){
        coffeeMachine.setMoney(60);
        final Drink locDrink = coffeeMachine.makeDrink("C::");
        final Drink locDrinkExpected = new Drink(EnumDrink.COFFEE,0,false);
        Assert.assertEquals("drink error", locDrinkExpected, locDrink);
    }

    @Test
    public void OrderDrinkWith1Sugar(){
        coffeeMachine.setMoney(60);
        final Drink locDrink = coffeeMachine.makeDrink("C:1:0");
        final Drink locDrinkExpected = new Drink(EnumDrink.COFFEE,1,true);
        Assert.assertEquals("drink error", locDrinkExpected, locDrink);
    }

    @Test
    public void OrderDrinkWith2Sugar(){
        coffeeMachine.setMoney(60);
        final Drink locDrink = coffeeMachine.makeDrink("C:2:0");
        final Drink locDrinkExpected = new Drink(EnumDrink.COFFEE,2,true);
        Assert.assertEquals("drink error", locDrinkExpected, locDrink);
    }

    @Test
    public void OrderError2() {
        final Drink locDrink = coffeeMachine.makeDrink("Y::");
        final Drink locDrinkExpected = new Drink();
        Assert.assertEquals("drink not empty", locDrinkExpected, locDrink);
    }

    @Test
    public void OrderCoffeeWithoutMoney(){
        final CoffeeMachine locCoffeeMachine = new CoffeeMachine();
        locCoffeeMachine.setMoney(0);
        final Drink locDrink = locCoffeeMachine.makeDrink("C::");
        Assert.assertNull(locDrink);
    }

    @Test
    public void OrderCoffeeWithNotEnoughMoney(){
        final CoffeeMachine locCoffeeMachine = new CoffeeMachine();
        locCoffeeMachine.setMoney(30);
        final Drink locDrink = locCoffeeMachine.makeDrink("C::");
        Assert.assertNull(locDrink);
    }

    @Test
    public void OrderCoffeeWithMoney(){
        final CoffeeMachine locCoffeeMachine = new CoffeeMachine();
        locCoffeeMachine.setMoney(60);
        final Drink locDrink = locCoffeeMachine.makeDrink("C::");
        final Drink locDrinkExpected = new Drink(EnumDrink.COFFEE,0,false);
        Assert.assertEquals("drink error", locDrinkExpected, locDrink);
    }

    @Test
    public void OrderTeaWithMoney(){
        final CoffeeMachine locCoffeeMachine = new CoffeeMachine();
        locCoffeeMachine.setMoney(40);
        final Drink locDrink = locCoffeeMachine.makeDrink("T::");
        final Drink locDrinkExpected = new Drink(EnumDrink.TEA,0,false);
        Assert.assertEquals("drink error", locDrinkExpected, locDrink);
    }

    @Test
    public void OrderChocolateWithMoney(){
        final CoffeeMachine locCoffeeMachine = new CoffeeMachine();
        locCoffeeMachine.setMoney(50);
        final Drink locDrink = locCoffeeMachine.makeDrink("H::");
        final Drink locDrinkExpected = new Drink(EnumDrink.CHOCOLATE,0,false);
        Assert.assertEquals("drink error", locDrinkExpected, locDrink);
    }

    @Test
    public void Order2CoffeeWithEnoughMoneyFor1(){
        final CoffeeMachine locCoffeeMachine = new CoffeeMachine();
        locCoffeeMachine.setMoney(80);
        final Drink locDrink = locCoffeeMachine.makeDrink("C::");
        final Drink locDrinkExpected = new Drink(EnumDrink.COFFEE,0,false);
        Assert.assertEquals("drink error", locDrinkExpected, locDrink);
        Assert.assertEquals(20,locCoffeeMachine.getMoney());
        final Drink locDrink2 = locCoffeeMachine.makeDrink("C::");
        Assert.assertNull(locDrink2);
    }

    @Test
    public void OrderOrange(){
        final CoffeeMachine locCoffeeMachine = new CoffeeMachine();
        locCoffeeMachine.setMoney(60);
        final Drink locDrink = locCoffeeMachine.makeDrink("O::");
        final Drink locDrinkExpected = new Drink(EnumDrink.ORANGE,0,false);
        Assert.assertEquals("drink error", locDrinkExpected, locDrink);
    }

    @Test
    public void OrderHotCoffee(){
        coffeeMachine.setMoney(60);
        final Drink locDrink = coffeeMachine.makeDrink("Ch::");
        final Drink locDrinkExpected = new Drink(EnumDrink.COFFEE,0,false, true);
        Assert.assertEquals("drink error", locDrinkExpected, locDrink);
    }

    @Test
    public void OrderHotTea(){
        coffeeMachine.setMoney(60);
        final Drink locDrink = coffeeMachine.makeDrink("Th::");
        final Drink locDrinkExpected = new Drink(EnumDrink.TEA,0,false, true);
        Assert.assertEquals("drink error", locDrinkExpected, locDrink);
    }

    @Test
    public void OrderHotChocolate(){
        coffeeMachine.setMoney(60);
        final Drink locDrink = coffeeMachine.makeDrink("Hh::");
        final Drink locDrinkExpected = new Drink(EnumDrink.CHOCOLATE,0,false, true);
        Assert.assertEquals("drink error", locDrinkExpected, locDrink);
    }

    @Test
    public void OrderHotOrange(){
        coffeeMachine.setMoney(60);
        final Drink locDrink = coffeeMachine.makeDrink("Oh::");
        final Drink locDrinkExpected = new Drink(EnumDrink.ORANGE,0,false, false);
        Assert.assertEquals("drink error", locDrinkExpected, locDrink);
    }


}