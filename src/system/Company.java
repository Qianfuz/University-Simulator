package system;

import model.*;
import system.*;
import java.util.*;


public class Company {

    public String doWork(Student stu, String workName) {
        StringBuilder sb = new StringBuilder();
        Work chosen = stu.findWork(workName);
        if (chosen == null) {
            return "没有这个工作";
        }

        Subject chosenSub = stu.findSubject(chosen.getSkill());
        ProfessionalSkill chosenPro = stu.findProfessionalSkill(chosen.getSkill());
        if (chosenSub != null) {
            if (chosenSub.getProgress() < chosenSub.getMaxProgress()) {
                return "你学艺不精，请继续学习 " + chosenSub.getName();
            }
        }
        if (chosenPro != null) {
            if (chosenPro.getProgress() < chosenPro.getMaxProgress()) {
                return "你学艺不精，请继续学习 " + chosenPro.getName();
            }
        }
        if(chosen != null && chosenSub == null && chosenPro == null){
            return "你的技能树和该工作不匹配";
        }
        stu.setMoney(stu.getMoney() + chosen.getMoney());
        sb.append("你获得了 ").append(chosen.getMoney()).append(" 元\n");
        if (chosen.getHealthValue() != 0) {
            stu.setHealthValue(stu.getHealthValue() + chosen.getHealthValue());
            if (chosen.getHealthValue() > 0) {
                sb.append("你获得了 ").append(chosen.getHealthValue()).append(" 点体力值\n");
            } else {
                sb.append("你减少了 ").append(chosen.getHealthValue() * -1).append(" 点体力值\n");
            }
        }
        if (chosen.getEnergyValue() != 0) {
            stu.setEnergyValue(stu.getEnergyValue() + chosen.getEnergyValue());
            if (chosen.getEnergyValue() > 0) {
                sb.append("你获得了 ").append(chosen.getEnergyValue()).append(" 点精力值\n");
            } else {
                sb.append("你减少了 ").append(chosen.getEnergyValue() * -1).append(" 点精力值\n");
            }
        }
        if (chosen.getHappyValue() != 0) {
            stu.setHappyValue(stu.getHappyValue() + chosen.getHappyValue());
            if (chosen.getHappyValue() > 0) {
                sb.append("你获得了 ").append(chosen.getHappyValue()).append(" 点开心值\n");
            } else {
                sb.append("你减少了 ").append(chosen.getHappyValue()*-1).append(" 点开心值\n");
            }
        }
        return sb.toString();
    }
}

