package model;

public class Achievement {

    private String name;
    private String introduction;
    private int money;
    private int healthValue;
    private int EnergyValue;
    private int happyValue;
    private String items=null;

    public Achievement(String name,String introduction,int money,int energyValue,int healthValue,int happyValue,String items){
        this.happyValue=happyValue;
        this.name=name;
        this.money=money;
        this.healthValue=healthValue;
        this.EnergyValue=energyValue;
        this.introduction=introduction;
        this.items=items;
    }

    public String getIntroduction() {
        return introduction;
    }
    public int getHealthValue() {
        return healthValue;
    }
    public int getEnergyValue() {
        return EnergyValue;
    }
    public int getHappyValue() {
        return happyValue;
    }
    public int getMoney() {
        return money;
    }
    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }
    public void setHappyValue(int happyValue) {
        this.happyValue = happyValue;
    }
    public void setEnergyValue(int energyValue) {
        EnergyValue = energyValue;
    }
    public void setHealthValue(int healthValue) {
        this.healthValue = healthValue;
    }
    public void setMoney(int money) {
        this.money = money;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getItems() {
        return items;
    }
}
