package system;

import model.Student;
import model.Subject;
import java.util.*;

public class StudySystem {
    private Random random = new Random();


    // 返回一句话给 Main 打印
    public String study(Student stu, String subjectName){
        Subject s = stu.findSubject(subjectName);
        if(s == null){
            return "你并没有选修这门科目";
        }
        int cost = random.nextInt(20) + 1;
        stu.setEnergyValue(stu.getEnergyValue() - cost);
        s.study();
        return "学习 " + s.getName() + " 消耗了 " + cost + " 点精力，你还有 " + stu.getEnergyValue() + " 点精力";
    }

}
