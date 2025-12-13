package model;

import java.util.*;

public class Student {
    private String name;
    private String character;
    private int energyValue;
    private int healthValue;
    private int money;

    private List<Subject>subjects=new ArrayList<>();
    //private List<Item>items=new ArrayList<>();
    private List<Drug>drugs=new ArrayList<>();

    public Student(String name,String character,int energyValue,int healthValue,int money){
        this.name=name;
        this.character=character;
        this.energyValue=energyValue;
        this.healthValue=healthValue;
        this.money=money;

        subjects.add(new Subject("English", 5,100));
        subjects.add(new Subject("Math", 6,100));
        subjects.add(new Subject("Java", 4,100));
        subjects.add(new Subject("Chinese", 10,100));
        subjects.add(new Subject("Algorithm",3, 500));

        drugs.add(new Drug("感冒药",0, 200, 5));
        drugs.add(new Drug("头孢克肟",0, 300, 8));
        drugs.add(new Drug("神奇药丸",0, 10000, 999));
        drugs.add(new Drug("扛着", 0,0, -15)); // 特殊药，反向扣血
    }

    //

    public void setMoney(int money) {
        this.money = money;
    }
    public void setEnergyValue(int energyValue) {
        this.energyValue = energyValue;
    }
    public void setHealthValue(int healthValue) {
        this.healthValue = healthValue;
    }
    public String getName(){
        return name;
    }
    public int getEnergyValue(){
        return energyValue;
    }
    public int getHealthValue(){
        return healthValue;
    }
    public int getMoney(){
        return money;
    }


    //


    //

    public Subject findSubject(String name){
        for (int i = 0; i < subjects.size(); i++) {
            Subject s = subjects.get(i);
            if(s.getName().equalsIgnoreCase(name)) {
                return s;
            }
        }
        return null;
    }

    public Drug findDrug(String name){
        for (int i = 0; i < drugs.size(); i++) {
            Drug d = drugs.get(i);
            if(d.getName().equalsIgnoreCase(name)){
                return d;
            }
        }
        return null;
    }

    public List<Drug> getDrugs() {
        return drugs;
    }
    //

}
