package Data;

public class Subject {

    private String name;
    private int gain;
    private int progress;
    private int maxProgress;

    public Subject(String name,int gain,int maxProgress){
        this.name=name;
        this.gain=gain;
        this.maxProgress=maxProgress;
        this.progress=0;
    }

    public String getName(){
        return name;
    }

    public int getGain() {
        return gain;
    }

    public int getMaxProgress() {
        return maxProgress;
    }

    public void study(){
        if(progress>=maxProgress){
            System.out.println("你已经精通这个科目了");
        } else {
            progress+=gain;
        }
    }
}
