package system;

import model.Student;
import model.Item;
import model.Subject;
import java.util.*;

public class Store {
    public String showItemList(Student stu){
        List<Item> items = stu.getItems();
        StringBuilder sb = new StringBuilder();
        sb.append("你可以购买：\n");
        for (int k = 0; k < items.size(); k++) {
            Item i = items.get(k);
            sb.append(i.getName())
                    .append(" 价格 ").append(i.getPrice())
                    .append(" 介绍 ").append(i.getIntroduction())
                    .append(" 当前拥有 ").append(i.getNumber())
                    .append("\n");

        }
        return sb.toString();
    }

    public String buy(Student stu,String itemName){
       Item chosen = stu.findItem(itemName);
       if(chosen==null) {
           return "商店正在上新中...";
       }

       stu.setMoney(stu.getMoney()-chosen.getPrice());
       chosen.setNumber(chosen.getNumber()+1);
       if(chosen.getType()==1){
           List<Subject> subjects = stu.getSubjects();
           for (int i = 0; i < subjects.size(); i++) {
               Subject s = subjects.get(i);
               s.setGain(s.getGain()+chosen.getStudyAddEffection());
           }
       } else if(chosen.getType()==2){
           stu.setHealthValue(stu.getHealthValue()+chosen.getExtraEffection());
       }

        if(stu.getMoney() < 0){
            return "你因虚荣负债，借了校园贷，被爆通讯录... 游戏失败";
        }
        return "购买成功，你现在有 " + chosen.getNumber() + " 个 " + chosen.getName()
                + "，余额：" + stu.getMoney();
    }

}
