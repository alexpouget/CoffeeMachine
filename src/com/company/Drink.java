package com.company;

import java.util.Objects;

/**
 * Created by alex on 16/11/2017.
 */
public class Drink {

    private EnumDrink drink;
    private int sugar;
    private boolean stick;
    private boolean extraHot;

    public Drink() {
        sugar = 0;
    }

    public Drink(EnumDrink drink, int sugar, boolean stick) {
        this.drink = drink;
        this.sugar = sugar;
        this.stick = stick;
    }

    public Drink(EnumDrink drink, int sugar, boolean stick, boolean extraHot) {
        this.drink = drink;
        this.sugar = sugar;
        this.stick = stick;
        this.extraHot = extraHot;
    }

    public EnumDrink getDrink() {
        return drink;
    }

    public void setDrink(EnumDrink drink) {
        this.drink = drink;
    }

    public int getSugar() {
        return sugar;
    }

    public void setSugar(int sugar) {
        this.sugar = sugar;
    }

    public boolean isStick() {
        return stick;
    }

    public void setStick(boolean stick) {
        this.stick = stick;
    }

    public boolean isExtraHot() {
        return extraHot;
    }

    public void setExtraHot(boolean extraHot) {
        this.extraHot = extraHot;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Drink drink1 = (Drink) o;
        return sugar == drink1.sugar &&
                stick == drink1.stick &&
                extraHot == drink1.extraHot &&
                drink == drink1.drink;
    }

    @Override
    public int hashCode() {
        return Objects.hash(drink, sugar, stick, extraHot);
    }
}
