package system;

import model.*;
import system.*;

import java.util.*;

public class ProfessionalSkillStudy {

    private Random random = new Random();

    // 返回一句话给 Main 打印
    public String studyProfessionalSkill(Student stu, String professionalSkillName){
        ProfessionalSkill p = stu.findProfessionalSkill(professionalSkillName);
        if(p == null){
            return "你并没有打算学习这个专业技能";
        }
        int cost = random.nextInt(20) + 1;
        stu.setEnergyValue(stu.getEnergyValue() - cost);
        p.study();
        return "学习 " + p.getName() + " 消耗了 " + cost + " 点精力，你还有 " + stu.getEnergyValue() + " 点精力";
    }
}
