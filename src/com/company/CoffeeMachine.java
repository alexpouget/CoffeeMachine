package com.company;

/**
 * Created by alex on 15/11/2017.
 */
public class CoffeeMachine {

    private int money;

    public CoffeeMachine() {
    }

    public Drink makeDrink(String command){
        System.out.println(command);
        if (3 > command.length()){
            print("command incorrect");
            return null;
        }
        final Drink locDrink = new Drink();
        for (int i = 0; i < command.length();i++) {
            char locOrder = command.charAt(i);
            if(null == locDrink.getDrink()) {
                for (EnumDrink e : EnumDrink.values()) {
                    if (locOrder == e.getId()) {
                        if(getMoney() < e.getPrice()) {
                            print("Il manque : "+ (e.getPrice() - getMoney()) + " centimes");
                            return null;
                        }
                            setMoney(getMoney() - e.getPrice());
                            locDrink.setDrink(e);

                    }
                    if (null != locDrink.getDrink()) {
                        break;
                    }
                }
            }
            if ('h' == locOrder){
                if(null != locDrink.getDrink() && locDrink.getDrink().canBeExtraHot()) {
                    locDrink.setExtraHot(true);
                }
            }
            if (':' != locOrder) {
                final Integer locSugarNum = Character.getNumericValue(locOrder);
                if(2 < locSugarNum) {
                    continue;
                }
                locDrink.setSugar(locSugarNum);
                if (0 < locSugarNum) {
                    locDrink.setStick(true);
                }
                break;
            }
        }
        return locDrink;
    }

    private void print(String message){
        System.out.println("M:"+message);
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
