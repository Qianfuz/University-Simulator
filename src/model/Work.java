package model;

public class Work {
    private String name;
    private int money;
    private int healthValue;
    private int happyValue;
    private int energyValue;
    private String skill;

    public Work(String name,int money,String skill,int happyValue,int healthValue,int energyValue){
        this.happyValue=happyValue;
        this.energyValue=energyValue;
        this.money=money;
        this.healthValue=healthValue;
        this.name=name;
        this.skill=skill;
    }

    public int getHappyValue() {
        return happyValue;
    }
    public int getEnergyValue() {
        return energyValue;
    }
    public int getHealthValue() {
        return healthValue;
    }
    public String getName() {
        return name;
    }
    public int getMoney() {
        return money;
    }
    public String getSkill() {
        return skill;
    }
    public void setHappyValue(int happyValue) {
        this.happyValue = happyValue;
    }
    public void setHealthValue(int healthValue) {
        this.healthValue = healthValue;
    }
    public void setEnergyValue(int energyValue) {
        this.energyValue = energyValue;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setMoney(int money) {
        this.money = money;
    }

}
