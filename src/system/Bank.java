package system;

import model.Student;
import model.Economic;

import java.util.*;

public class Bank {

    private Random random = new Random();

    public String showEconomics(Student stu){
        List<Economic> economics = stu.getEconomics();
        StringBuilder sb = new StringBuilder();
        sb.append("你可以购买：\n");
        for (int i = 0; i < economics.size(); i++) {
            Economic e = economics.get(i);
            sb.append(e.getName())
                    .append("  ").append(e.getIntroduce())
                    .append(" 价格 ").append(e.getPrice())
                    .append(" 利率 ").append(e.getRate())
                    .append(" 风险 ").append(e.getProbably()).append(" %").append("\n");

        }
        return sb.toString();
    }

    public String buy(Student stu,String economicName){
        Economic chosen = stu.findEconomic(economicName);
        StringBuilder sb = new StringBuilder();
        if(chosen==null){
            return "没有这种理财产品";
        }
        int p = random.nextInt(100)+1;
        if(chosen.getPrice()==0){
            if(p>chosen.getProbably()){
                stu.setMoney(stu.getMoney()*(100+chosen.getRate())/100);
                sb.append("你投资成功了！");
            } else {
                stu.setMoney((stu.getMoney()*(100-chosen.getRate())/100));
                sb.append("投资有风险，你失败了！");
            }
        } else {
            int a=0;
            stu.setMoney(stu.getMoney()-chosen.getPrice());
            if(p>chosen.getProbably()){
                a = chosen.getPrice()*(100+chosen.getRate())/100;
                sb.append("你投资成功了！");
            } else {
                sb.append("投资有风险，你失败了！");
            }
            stu.setMoney(stu.getMoney()+a);
        }

        if(stu.getMoney() < 0){
            return "你因病负债，借了校园贷，被爆通讯录... 游戏失败";
        }

        sb.append("你现在有 余额： " + stu.getMoney());
        return sb.toString();
    }

}

