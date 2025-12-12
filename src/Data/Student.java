package Data;

import java.util.*;

public class Student {
    private String name;
    private String character;
    private int energyValue;
    private int healthValue;
    private int money;
    Random random = new Random();
    Scanner sc = new Scanner(System.in);
    private List<Subject>subjects=new ArrayList<>();
    private List<Item>items=new ArrayList<>();
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
    public Subject getSubjectByName(String name){
        for (int i = 0; i < subjects.size(); i++) {
            if(subjects.get(i).getName().equalsIgnoreCase(name)) {
                return subjects.get(i);
            }
        }
        return null;
    }

    public void study(String name){
        Subject s = getSubjectByName(name);
        if(s==null){
            System.out.println("你并没有选修这门科目");
            return;
        }
        int a = random.nextInt(20)+1;
        energyValue-=a;
        System.out.println("学习 " + name + " 消耗了 " + a + " 点精力，你还有 " + energyValue + " 点精力");
        s.study();
    }

    public void buyDrugs(){
        System.out.println("每天，你可以选择买一种药，以备不时之需，今天你是否选择购买药品，你有如下选择");
        for (int i = 0; i < drugs.size(); i++) {
            Drug d = drugs.get(i);
            System.out.println(d.getName() + " 价格 " + d.getPrice() + " 元 " + " 效果 增加 " + d.getHealthValue() +" 点健康值" + " 你目前拥有 " + d.getNumber() + "个");
        }
        String index = sc.next();
        Drug chosen = null;
        for (int i = 0; i < drugs.size(); i++) {
            Drug d = drugs.get(i);
            if(d.getName().equalsIgnoreCase(index)){
                chosen=d;
                break;
            }
        }
        if(chosen==null){
            System.out.println("没有这种药");
            return;
        }
        money-=chosen.getPrice();
        chosen.setNumber(chosen.getNumber()+1);

        if(money<0){
            System.out.println("你因病负债，借了校园贷，被爆通讯录，失去尊严，不敢告诉父母，利滚利，最终你流落街头，游戏失败");
        }

    }

    public void useDrugs(){
        System.out.println("你是否想吃药，如果是，请输入 1 ,如果不是，请输入 2 ");
        int a = sc.nextInt();
        if(a!=1){
            return;
        }
        int cnt=0;
        for (int i = 0; i < drugs.size(); i++) {
            Drug d = drugs.get(i);
            if(d.getNumber()>0){
                System.out.println("你有 " + d.getNumber() + " 个 " + d.getName());
                cnt++;
            }
        }
        if(cnt==0){
            System.out.println("没钱买药你吃什么药");
            return;
        } else {
            String index = sc.next();
            Drug chosen = null;
            for (int i = 0; i < drugs.size(); i++) {
                Drug d = drugs.get(i);
                if(d.getName().equalsIgnoreCase(index)){
                    chosen=d;
                    break;
                }
            }
            if(chosen==null){
                System.out.println("不会吃药可以不吃");
                return;
            } else {
                healthValue+=chosen.getHealthValue();
                chosen.setNumber(chosen.getNumber()-1);
                System.out.println("你吃了 " + chosen.getName() + " 健康值增加 " + chosen.getHealthValue() +" 点，注意身体");
            }
        }
    }

    public void lunchTime(){
        System.out.println("到中午了，你该吃饭了，你想吃什么");
        System.out.println("今天的食堂有 汉堡 30元 面 20元 米饭 25元 不吃 0元");
        System.out.println("你也可以选择下馆子 120元");
        String food = sc.next();
        if(food.equalsIgnoreCase("汉堡")){
            setMoney(getMoney()-30);
            setEnergyValue(getEnergyValue()+2);
            System.out.println("你吃了 " + food + "今天消费 " + 30 + " 元");
            System.out.println("你还有 " + getMoney() + " 元");
            System.out.println("你很开心，回复了 2 点精力值，你的精力值为 " + getEnergyValue());
        } else if(food.equalsIgnoreCase("面")){
            setMoney(getMoney()-20);
            setEnergyValue(getEnergyValue()+1);
            System.out.println("你吃了 " + food + "今天消费 " + 20 + " 元");
            System.out.println("你还有 " + getMoney() + " 元");
            System.out.println("你很开心，回复了 1 点精力值，你的精力值为 " + getEnergyValue());
        } else if(food.equalsIgnoreCase("米饭")){
            setMoney(getMoney()-25);
            setEnergyValue(getEnergyValue()+1);
            System.out.println("你吃了 " + food + "今天消费 " + 25 + " 元");
            System.out.println("你还有 " + getMoney() + " 元");
            System.out.println("你很开心，回复了 1 点精力值，你的精力值为 " + getEnergyValue());
        } else if(food.equalsIgnoreCase("不吃")){
            setEnergyValue(getEnergyValue()-20);
            System.out.println("你很不开心，扣除 20 点精力值，你的精力值为 " + getEnergyValue());
            setHealthValue(getHealthValue()-5);
            System.out.println("这是不健康的行为，你扣除 5 点健康值，你的健康值为 " + getHealthValue());
        } else{
            setMoney(getMoney()-120);
            setEnergyValue(getEnergyValue()+8);
            System.out.println("你吃了 " + food + "今天消费 " + 120 + " 元");
            System.out.println("你还有 " + getMoney() + " 元");
            System.out.println("你很开心，回复了 8 点精力值，你的精力值为 " + getEnergyValue());
            setHealthValue(getHealthValue()-1);
            System.out.println("你大吃一顿，太饱了，这并不健康，扣除了 1 点健康值，你的健康值为 " + getHealthValue());
        }


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




}
