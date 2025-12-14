package model;

public class Item {

    private String name;
    private String introduction;
    private int number;
    private int price;
    private int secondHandPrice;
    private int studyAddEffection;
    private int extraEffection;
    private int type;

    public Item(String name,int price,String introduction,int studyAddEffection,int extraEffection,int type){
        this.name=name;
        this.price=price;
        this.secondHandPrice=(int)(price*0.75);
        this.introduction=introduction;
        this.studyAddEffection=studyAddEffection;
        this.extraEffection=extraEffection;
        this.type=type;
        this.number=0;
    }

    public int getType() {
        return type;
    }
    public int getNumber() {
        return number;
    }
    public int getSecondHandPrice() {
        return secondHandPrice;
    }
    public String getName() {
        return name;
    }
    public String getIntroduction() {
        return introduction;
    }
    public int getPrice() {
        return price;
    }
    public int getExtraEffection() {
        return extraEffection;
    }
    public int getStudyAddEffection() {
        return studyAddEffection;
    }
    public void setSecondHandPrice(int secondHandPrice) {
        this.secondHandPrice = secondHandPrice;
    }
    public void setNumber(int number) {
        this.number = number;
    }
}
