package app;

import core.GameEngine;
import model.Student;
import system.Store;
import system.StudySystem;
import system.Hospital;
import system.Canteen;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        StudySystem studySystem = new StudySystem();
        Hospital hospital = new Hospital();
        Canteen canteen = new Canteen();
        Store store = new Store();

        GameEngine engine = new GameEngine(studySystem, hospital, canteen,store);

        System.out.println("请输入你的名字");
        Student s1 = new Student(sc.next(),"开朗",100,100,2000);

        engine.run(s1, 3, sc);

    }
}