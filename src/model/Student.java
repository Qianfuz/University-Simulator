package model;

import java.util.*;

public class Student {
    private String name;
    private String character;
    private int energyValue;
    private int healthValue;
    private int happyValue;
    private long money;

    private List<Subject>subjects=new ArrayList<>();
    private List<Item>items=new ArrayList<>();
    private List<Drug>drugs=new ArrayList<>();
    private List<Economic>economics=new ArrayList<>();
    private List<Event>events=new ArrayList<>();
    private List<Achievement>achievements=new ArrayList<>();

    public Student(String name,String character,int energyValue,int healthValue,long money) {
        this.name = name;
        this.character = character;
        this.energyValue = energyValue;
        this.healthValue = healthValue;
        this.money = money;
        this.happyValue=0;

        subjects.add(new Subject("English", 5, 100));
        subjects.add(new Subject("Math", 6, 100));
        subjects.add(new Subject("Java", 4, 100));
        subjects.add(new Subject("Chinese", 10, 100));
        subjects.add(new Subject("Algorithm", 3, 500));

        drugs.add(new Drug("感冒药", 0, 200, 5));
        drugs.add(new Drug("头孢克肟", 0, 300, 8));
        drugs.add(new Drug("神奇药丸", 0, 10000, 999));
        drugs.add(new Drug("扛着", 0, 0, -15)); // 特殊药，反向扣血

        items.add(new Item("iPhone17ProMax", 9999, "综合最强手机，拥有它你的学习效率会大幅提高！甚至会有额外的加成！", 10, 5, 1));
        items.add(new Item("iPadPro", 8999, "超级大的平板,拥有它你的学习效率会中幅提高！甚至会有额外的加成！", 7, 4, 1));
        items.add(new Item("AppleWatch", 2999, "健康功能很强的手表，你会更注意健康，甚至会有额外的加成！", 1, 15, 1));
        items.add(new Item("HUAWEIMate80Pro", 7999, "很好的手机，拥有它你的学习效率会中幅提高！甚至会有额外的加成！", 8, 4, 1));
        items.add(new Item("Xiaomi17", 1999, "超级性价比，学习效率提高", 4, 0, 1));
        items.add(new Item("七度空间", 5, "额...包扎伤口的重要道具，可以止血", 0, 8, 2));
        items.add(new Item("创可贴", 5, "包扎伤口的重要道具，可以止血", 0, 5, 2));
        items.add(new Item("卫生纸", 200, "特殊道具，可以进入神奇的状态，提高开心值！", 0, -10, 2));//未完善
        items.add(new Item("保时捷", 500000, "拥有他是不是可以找到妹妹？", 0, 100, 3));//未
        items.add(new Item("武林秘籍", 99999999, "你感受到了古老的气息...", 0, 10000, 3));//w

        economics.add(new Economic("定期存款", "风险极低，收益少", 0, 2, 1,1));
        economics.add(new Economic("基金","风险极低，收益少",0,3,3,1));
        economics.add(new Economic("彩票", "低门槛，高收益", 200, 4000, 99,2));
        economics.add(new Economic("刮刮乐", "高收益", 200, 5000, 99,2));
        economics.add(new Economic("A股", "高风险，高收益", 5000, 750, 70,1));
        economics.add(new Economic("美股", "高风险，高收益", 8000, 1500, 85,1));
        economics.add(new Economic("期货", "极高风险，极高收益", 30000, 15000, 98,1));
        economics.add(new Economic("大额存单", "大客户的特殊产品", 500000, 6, 2,1));
        economics.add(new Economic("大额存单B", "大客户的特殊产品", 1000000, 8, 2,1));
        economics.add(new Economic("大额存单C", "大客户的特殊产品", 3000000, 10, 1,1));
        economics.add(new Economic("国债", "???", 1000000, 6, 0,1));
        economics.add(new Economic("国债B", "???", 100000000, 8,0 ,1));
        economics.add(new Economic("BTC", "谁也不知道是亏是赚", 350000, 0,50 ,3));
        economics.add(new Economic("Doge", "门槛低", 500, 0,70 ,3));
        economics.add(new Economic("Trump", "门槛略低", 1500, 0,60 ,3));



        events.add(new Event("你在路上捡到了5000元，很开心",5000,0,0,20,null,null));
        events.add(new Event("经济危机，你损失了10000元",-10000,-10,-10,-10,null,null));
        events.add(new Event("你抽中了新手机",0,0,0,20,"iPhone17ProMax",null));
        events.add(new Event("你给校花表白被拒绝，被羞辱",-250,-5,-5,-25,null,null));
        events.add(new Event("你遇到了神医传人，他给了你一个神秘的盒子",0,0,10,5,null,"神奇药丸"));
        events.add(new Event("你捡到了一本书，定眼一看，上面写着...",0,0,0,0,"武林秘籍",null));
        events.add(new Event("你出了车祸，但对方跟你私了了",50000,-30,-60,30,"保时捷",null));
        events.add(new Event("你摔了一跤，好痛",-300,-5,-10,-5,null,null));
        events.add(new Event("你被一张布糊脸了",0,0,-1,-20,"七度空间",null));
        events.add(new Event("你感到今天很幸运",0,0,0,1,null,null));
        events.add(new Event("你去医院检查，发现自己有小毛病，打折购买了一块表",-2000,0,0,1,"AppleWatch",null));
        events.add(new Event("你获得了一个神秘道具，但是路上不小心丢了",0,0,0,50,null,null));

        achievements.add(new Achievement("人生赢家","资产达到500万",5000000,0,0,0,null));
        achievements.add(new Achievement("快乐最重要","快乐值达到1000",0,0,0,1000,null));
        achievements.add(new Achievement("养生派","健康值达到1000",0,0,1000,0,null));
        achievements.add(new Achievement("活力达人","精力值达到1000",0,1000,0,0,null));
        achievements.add(new Achievement("驾考宝典","获得了保时捷",0,0,0,0,"保时捷"));
        achievements.add(new Achievement("武当派","获得了武林秘籍",0,0,0,0,"武林秘籍"));
        achievements.add(new Achievement("白手起家","资产达到1000000000",1000000000,0,0,0,null));
        achievements.add(new Achievement("体修，启动！","体力值达到50000",0,0,50000,0,null));
        achievements.add(new Achievement("魂修，启动！","精力值达到50000",0,50000,0,0,null));
        achievements.add(new Achievement("全能派","你达到了中产水平",500000,300,300,300,null));
        //achievements.add(new Achievement("测试","精力值达到50000",1,0,1,0,null));

    }

    //

    public void setMoney(long money) {
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
    public long getMoney(){
        return money;
    }
    public void setHappyValue(int happyValue) {
        this.happyValue = happyValue;
    }
    public int getHappyValue() {
        return happyValue;
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

    public Item findItem(String name){
        for (int k = 0; k < items.size(); k++) {
            Item i = items.get(k);
            if(i.getName().equalsIgnoreCase(name)){
                return i;
            }
        }
        return null;
    }

    public Economic findEconomic(String name){
        for (int k = 0; k < economics.size(); k++) {
            Economic e = economics.get(k);
            if(e.getName().equalsIgnoreCase(name)){
                return e;
            }
        }
        return null;
    }
    //
    public List<Drug> getDrugs() {
        return drugs;
    }
    public List<Item> getItems() {
        return items;
    }
    public List<Subject> getSubjects() {
        return subjects;
    }
    public List<Economic> getEconomics(){
        return economics;
    }
    public List<Event> getEvents(){
        return events;
    }
    public List<Achievement>getAchievements(){
        return achievements;
    }
    //


}
