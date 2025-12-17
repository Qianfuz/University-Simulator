package system;

import java.util.*;
import model.*;
import system.*;


public class AchievementSystem {
    public String showAchievement(Student stu) {
        StringBuilder sb = new StringBuilder();
        sb.append("你完成的成就有\n");
        List<Achievement> a = stu.getAchievements();
        int p = 0;
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i).getMoney() != 0) {
                if (stu.getMoney() < a.get(i).getMoney()) {
                    continue;
                }
            }
            if (a.get(i).getEnergyValue() != 0) {
                if (stu.getEnergyValue() < a.get(i).getEnergyValue()) {
                    continue;
                }
            }

            if (a.get(i).getHealthValue() != 0) {
                if (stu.getHealthValue() < a.get(i).getHealthValue()) {
                    continue;
                }
            }
            if (a.get(i).getHappyValue() != 0) {
                if (stu.getHappyValue()<a.get(i).getHappyValue()) {
                    continue;
                }
            }
            if (a.get(i).getItems() != null) {
                Item I = stu.findItem(a.get(i).getItems());
                if (I.getNumber() == 0) {
                    continue;
                }
            }
                sb.append(i+1).append(" ").append(a.get(i).getName()).append(" ").append(a.get(i).getIntroduction()).append("\n");
                p=1;
        }
        if(p==0){
            sb.append("隐藏成就: 人生输家 \n");
        }
        return sb.toString();
    }
}

