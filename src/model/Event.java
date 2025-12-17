package model;

public class Event {
    private String introduction;
    private int money;
    private int healthValue;
    private int EnergyValue;
    private int happyValue;
    private String items;
    private String drugs;

    public Event(String introduction,int money,int energyValue,int healthValue,int happyValue,String items,String drugs){
        this.happyValue=happyValue;
        this.money=money;
        this.items=items;
        this.drugs=drugs;
        this.healthValue=healthValue;
        this.EnergyValue=energyValue;
        this.introduction=introduction;
    }

    public int getHappyValue() {
        return happyValue;
    }
    public int getEnergyValue() {
        return EnergyValue;
    }
    public int getMoney() {
        return money;
    }
    public int getHealthValue() {
        return healthValue;
    }
    public String getIntroduction() {
        return introduction;
    }
    public String getDrugs() {
        return drugs;
    }
    public String getItems() {
        return items;
    }
}
