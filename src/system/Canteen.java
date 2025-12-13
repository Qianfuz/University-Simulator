package system;

import model.Student;

public class Canteen {
    // Main 负责输入 choice，这里只负责规则 + 改数值 + 返回一句话
    public String eat(Student stu, String choice){

        if(choice.equalsIgnoreCase("汉堡")){
            stu.setMoney(stu.getMoney() - 30);
            stu.setEnergyValue(stu.getEnergyValue() + 2);
            return "你吃了 汉堡，花费30元，精力+2。余额：" + stu.getMoney() + " 精力：" + stu.getEnergyValue();

        } else if(choice.equalsIgnoreCase("面")){
            stu.setMoney(stu.getMoney() - 20);
            stu.setEnergyValue(stu.getEnergyValue() + 1);
            return "你吃了 面，花费20元，精力+1。余额：" + stu.getMoney() + " 精力：" + stu.getEnergyValue();

        } else if(choice.equalsIgnoreCase("米饭")){
            stu.setMoney(stu.getMoney() - 25);
            stu.setEnergyValue(stu.getEnergyValue() + 1);
            return "你吃了 米饭，花费25元，精力+1。余额：" + stu.getMoney() + " 精力：" + stu.getEnergyValue();

        } else if(choice.equalsIgnoreCase("不吃")){
            stu.setEnergyValue(stu.getEnergyValue() - 20);
            stu.setHealthValue(stu.getHealthValue() - 5);
            return "你没吃饭，精力-20，健康-5。精力：" + stu.getEnergyValue() + " 健康：" + stu.getHealthValue();

        } else { // 下馆子 / 其它输入都按这个算
            stu.setMoney(stu.getMoney() - 120);
            stu.setEnergyValue(stu.getEnergyValue() + 8);
            stu.setHealthValue(stu.getHealthValue() - 1);
            return "你下馆子，花费120元，精力+8，健康-1。余额：" + stu.getMoney()
                    + " 精力：" + stu.getEnergyValue() + " 健康：" + stu.getHealthValue();
        }
    }
}
