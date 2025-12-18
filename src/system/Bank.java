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

    public String buy(Student stu,String economicName,int number){
        Economic chosen = stu.findEconomic(economicName);
        StringBuilder sb = new StringBuilder();
        if(chosen==null){
            return "没有这种理财产品";
        }
        long Money=stu.getMoney();
        int Rate=chosen.getRate();
        long Price=chosen.getPrice();
        if(chosen.getType()==2){
            Price*=number;
        }
        if(chosen.getType()==3){
            Price*=number;
            Rate=random.nextInt(50)+51;
        }

        int p = random.nextInt(100)+1;
        if(Price==0){
            if(p>chosen.getProbably()){
                stu.setMoney(Money*(100+Rate)/100);
                sb.append("你投资成功了！");
            } else {
                stu.setMoney(Money*(100-Rate)/100);
                sb.append("投资有风险，你失败了！");
            }
        } else {
            long a=0;
            stu.setMoney(Money-Price);
            if(p>chosen.getProbably()){
                a = Price*(100+Rate)/100;
                sb.append("你投资成功了！");
            } else {
                sb.append("投资有风险，你失败了！");
            }
            stu.setMoney(stu.getMoney()+a);
        }

        if(stu.getMoney() < 0){
            return "你因病负债，借了校园贷，被爆通讯录... 游戏失败";
        }

        sb.append("你现在有 余额： ").append(stu.getMoney());
        return sb.toString();
    }

}

