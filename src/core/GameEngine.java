package core;

import model.Student;
import system.*;

import java.util.*;

public class GameEngine {

    private final Random random = new Random();

    private final Study studySystem;
    private final Hospital hospital;
    private final Canteen canteen;
    private final Store store;
    private final Bank bank;
    private final RandomEvent randomEvent;
    private final AchievementSystem achievementSystem;
    private final Company company;

    public GameEngine(Study studySystem, Hospital hospital, Canteen canteen, Store store,Bank bank,RandomEvent randomEvent,AchievementSystem achievementSystem,Company company) {
        this.studySystem = studySystem;
        this.hospital = hospital;
        this.canteen = canteen;
        this.store = store;
        this.bank=bank;
        this.randomEvent=randomEvent;
        this.achievementSystem=achievementSystem;
        this.company=company;
    }

    // 跑 N 天游玩
    public void run(Student s1, int days, Scanner sc) {
        System.out.println("因为你成绩优异，被奖励 50000 奖学金，你可以购买一件物品");
        s1.setMoney(50000);
        s1.setMoney(1000000000);
        System.out.println(s1.getName() + " 同学你好，每天睡醒，请输入一门科目，进行学习 English Java Math Chinese Algorithm");
        System.out.println(store.showItemList(s1));
        System.out.println(store.buy(s1,sc.next()));
        for (int i = 0; i < days; i++) {
            System.out.println("今天是第" + (i + 1) + "天");
            // 起床回血精力
            int a = random.nextInt(20) + 1;
            s1.setEnergyValue(s1.getEnergyValue() + a);
            System.out.println("一觉醒来，你回复了一些精力，你目前的精力为 " + s1.getEnergyValue());

            // 学习
            if(i%7!=6 && i%7!=0){
                System.out.println("请输入你要学习的科目");
                String sub = sc.next();
                System.out.println(studySystem.study(s1, sub));
            }

            // 吃饭
            System.out.println("到中午了，你该吃饭了，你想吃什么");
            System.out.println("今天的食堂有 汉堡 30元 面 20元 米饭 25元 不吃 0元");
            System.out.println("你也可以选择下馆子 120元");
            String food = sc.next();
            System.out.println(canteen.eat(s1, food));
            //System.out.println(randomEvent.getRandomEvent(s1));
            String work1 = sc.next();
            System.out.println(company.doWork(s1,work1));
            // 健康事件 & 医院
            int d = random.nextInt(20) + 1;
            if (d > 18) {
                if (d % 2 == 0) {
                    s1.setHealthValue(s1.getHealthValue() - 50);
                    System.out.println("最近天气冷，你感冒了，请注意保暖，你目前的健康值为 " + s1.getHealthValue());
                } else {
                    s1.setHealthValue(s1.getHealthValue() - 80);
                    System.out.println("你似乎有些头晕，睡了一觉，你目前的健康值为 " + s1.getHealthValue());
                }

                System.out.println(hospital.showDrugList(s1));
                System.out.println("输入你要买的药名：");
                System.out.println(hospital.buy(s1, sc.next()));

                System.out.println("是否吃药？1吃 2不吃");
                int choose = sc.nextInt();
                if (choose == 1) {
                    System.out.println("输入你要吃的药名：");
                    System.out.println(hospital.use(s1, sc.next()));
                }
            }
            //买东西
            if(i%2==0){
                System.out.println(store.showItemList(s1));
                System.out.println(store.buy(s1,sc.next()));
            } else {
                System.out.println(bank.showEconomics(s1));
                System.out.println(bank.buy(s1, sc.next(),sc.nextInt()));
            }

            System.out.println(randomEvent.getRandomEvent(s1));
        }

        System.out.println("放假啦");
        System.out.println(achievementSystem.showAchievement(s1));
    }
}