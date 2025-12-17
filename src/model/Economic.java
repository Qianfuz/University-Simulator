package model;

import model.Student;

import java.util.*;

public class Economic {
    String name;
    String introduce;
    int price;
    int rate;
    int  probably;
    int type;
    int number;

    public Economic(String name,String introduce,int price,int rate,int probably,int type){
        this.introduce=introduce;
        this.name=name;
        this.price=price;
        this.rate=rate;
        this.probably=probably;
        this.type=type;
        this.number=1;

    }

    public void setNumber(int number) {
        this.number = number;
    }
    public int getNumber() {
        return number;
    }
    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public void setRate(int rate) {
        this.rate = rate;
    }
    public String getName() {
        return name;
    }
    public String getIntroduce() {
        return introduce;
    }
    public int getRate() {
        return rate;
    }
    public int getPrice() {
        return price;
    }
    public int getProbably() {
        return probably;
    }
    public void setProbably(int probably) {
        this.probably = probably;
    }
    public int getType() {
        return type;
    }
}
