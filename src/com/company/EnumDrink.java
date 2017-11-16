package com.company;

/**
 * Created by alex on 16/11/2017.
 */
public enum  EnumDrink {

    TEA('T', 40, true),
    COFFEE('C', 60, true),
    CHOCOLATE('H', 50, true),
    ORANGE('O', 60, false);

    private char id;
    private int price;
    private final boolean extraHot;

    EnumDrink(char parId, int parPrice, boolean parExtraHot) {
        id = parId;
        price = parPrice;
        extraHot = parExtraHot;
    }

    public char getId() {
        return id;
    }

    public void setId(char id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean canBeExtraHot(){
        return extraHot;
    }
}
