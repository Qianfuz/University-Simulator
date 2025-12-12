package Data;

public class Drug {
    private String name;
    private int number;
    private int healthValue;
    private int price;

    public Drug(String name,int number,int price,int healthValue){
        this.name=name;
        this.number=number;
        this.healthValue=healthValue;
        this.price=price;
    }

    public String getName() {
        return name;
    }

    public int getHealthValue() {
        return healthValue;
    }

    public int getPrice() {
        return price;
    }

    public int getNumber() {
        return number;
    }
    public void setNumber(int number){
        this.number=number;
    }

    //


}
