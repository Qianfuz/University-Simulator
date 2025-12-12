import Data.Student;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你的名字");
        Student s1 = new Student(sc.next(),"开朗",100,100,2000);
        Random random = new Random();
        System.out.println(s1.getName() + " 同学你好，请输入一门科目，进行学习" + "    " + "English Java Math Chinese algorithm");
        for (int i = 0; i < 3; i++) {
            System.out.println("今天是第" + (i+1) + "天");

            int a = random.nextInt(20)+1;
            s1.setEnergyValue(s1.getEnergyValue()+a);
            System.out.println("一觉醒来，你回复了一些精力，你目前的精力为 " + s1.getEnergyValue());
            System.out.println("请输入你要学习的科目");
            s1.study(sc.next());
            s1.lunchTime();
            int d = random.nextInt(20)+1;
            if(d>12){
                if(d%2==0){
                    s1.setHealthValue(s1.getHealthValue()-20);
                    System.out.println("最近天气冷，你感冒了，请注意保暖，你目前的健康值为 " + s1.getHealthValue());
                } else {
                    s1.setHealthValue(s1.getHealthValue()-10);
                    System.out.println("你似乎有些头晕，睡了一觉，你目前的健康值为 " + s1.getHealthValue());
                }
                s1.buyDrugs();
                s1.useDrugs();

            }
        }
        System.out.println("放假啦");
    }
}