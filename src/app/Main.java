package app;

import core.GameEngine;
import model.Student;
import system.*;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Study studySystem = new Study();
        Hospital hospital = new Hospital();
        Canteen canteen = new Canteen();
        Store store = new Store();
        Bank bank = new Bank();
        RandomEvent randomEvent = new RandomEvent();
        AchievementSystem achievementSystem = new AchievementSystem();

        GameEngine engine = new GameEngine(studySystem, hospital, canteen,store, bank,randomEvent,achievementSystem);

        System.out.println("请输入你的名字");
        Student s1 = new Student(sc.next(),"开朗",100,100,2000);
        engine.run(s1,15, sc);

    }
}