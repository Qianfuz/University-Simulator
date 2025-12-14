package system;

import model.Drug;
import model.Student;
import java.util.*;

public class Hospital {

    public String showDrugList(Student stu){
        List<Drug> drugs = stu.getDrugs();
        StringBuilder sb = new StringBuilder();
        sb.append("你可以购买：\n");
        for (int i = 0; i < drugs.size(); i++) {
            Drug d = drugs.get(i);
            sb.append(d.getName())
                    .append(" 价格 ").append(d.getPrice())
                    .append(" 效果 ").append(d.getHealthValue())
                    .append(" 当前拥有 ").append(d.getNumber())
                    .append("\n");
        }
        return sb.toString();
    }

    public String buy(Student stu, String drugName){
        Drug chosen = stu.findDrug(drugName);
        if(chosen == null){
            return "没有这种药";
        }

        stu.setMoney(stu.getMoney() - chosen.getPrice());
        chosen.setNumber(chosen.getNumber() + 1);

        if(stu.getMoney() < 0){
            return "你因病负债，借了校园贷，被爆通讯录... 游戏失败";
        }
        return "购买成功，你现在有 " + chosen.getNumber() + " 个 " + chosen.getName()
                + "，余额：" + stu.getMoney();
    }

    public String use(Student stu, String drugName){
        Drug chosen = stu.findDrug(drugName);
        if(chosen == null){
            return "你没有这种药";
        }
        if(chosen.getNumber() <= 0){
            return "你没有 " + chosen.getName() + " 了";
        }

        chosen.setNumber(chosen.getNumber() - 1);
        stu.setHealthValue(stu.getHealthValue() + chosen.getHealthValue());

        return "你吃了 " + chosen.getName()
                + "，健康值变化 " + chosen.getHealthValue()
                + "，当前健康值：" + stu.getHealthValue();
    }
}
