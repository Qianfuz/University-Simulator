package system;


import model.*;
import system.*;


import java.util.Random;

public class RandomEvent {
    private Random random = new Random();

    public String getRandomEvent(Student stu){
        int a = random.nextInt(100);
        if(a>=25 || stu.getEvents()==null || stu.getEvents().isEmpty()){
            return  "";
        }
        int b = random.nextInt(stu.getEvents().size());
        Event e = stu.getEvents().get(b);
        StringBuilder sb = new StringBuilder();
        sb.append(e.getIntroduction() );
        if(e.getMoney()!=0){
            stu.setMoney(stu.getMoney()+e.getMoney());
            if(e.getMoney()>0){
                sb.append("你获得了 ").append(e.getMoney()).append(" 元\n");
            } else {
                sb.append("你失去了 ").append(e.getMoney()*-1).append(" 元\n");
            }
        }
        //......
        if(e.getEnergyValue()!=0){
            stu.setEnergyValue(stu.getEnergyValue()+e.getEnergyValue());
            if(e.getEnergyValue()>0){
                sb.append("你获得了 ").append(e.getEnergyValue()).append(" 点精力值\n");
            } else {
                sb.append("你减少了 ").append(e.getEnergyValue()*-1).append(" 点精力值\n");
            }
        }

        if(e.getHealthValue()!=0){
            stu.setHealthValue(stu.getHealthValue()+e.getHealthValue());
            if(e.getHealthValue()>0){
                sb.append("你获得了 ").append(e.getHealthValue()).append(" 点体力值\n");
            } else {
                sb.append("你减少了 ").append(e.getHealthValue()*-1).append(" 点体力值\n");
            }
        }

        //happyValue

        if(e.getItems()!=null){
            Item i = stu.findItem(e.getItems());
            /*stu.setMoney(stu.getMoney()+i.getPrice());
            sb.append(store.buy(stu,i.getName())).append("\n");*/
            if(i!=null){
                i.setNumber(i.getNumber()+1);
                sb.append("你获得了 ").append(i.getName()).append("\n");
            }
        }
        if(e.getDrugs()!=null){
            Drug d = stu.findDrug(e.getDrugs());
            /*stu.setMoney(stu.getMoney()+d.getPrice());
            sb.append(hospital.buy(stu,d.getName())).append("\n");*/
            if(d!=null){
                d.setNumber(d.getNumber()+1);
                sb.append("你获得了 ").append(d.getName()).append("\n");
            }
        }


        return sb.toString();
    }
}