package Domain;

import java.io.Serializable;

public class Activity extends Entity implements Serializable {
    private String activityType;
    private String day;
    private String hour;
    private int teacherId;
    private int disciplineId;


    public Activity(){

    }

    public Activity(String s){
        String token[]=s.split(",");
        this.activityType=token[0].strip();
        this.day=token[1].strip();
        this.hour=token[2].strip();
        this.setId(Integer.parseInt(token[3].strip()));
        this.teacherId=Integer.parseInt(token[4].strip());
        this.disciplineId = Integer.parseInt(token[5].strip());
    }

    public Activity(String s,String day,String h, int i,int teacherId,int disciplineId){

        this.activityType=s;
        this.day=day;
        this.hour=h;
        this.setId(i);
        this.teacherId=teacherId;
        this.disciplineId=disciplineId;
    }

    public int getDisciplineId() {
        return disciplineId;
    }

    public void setDisciplineId(int disciplineId) {
        this.disciplineId = disciplineId;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public String getActivityType() {
        return activityType;
    }

    public void setActivityType(String activityType) {
        this.activityType = activityType;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public void update_activity(Activity a){
        this.activityType=a.getActivityType();
        this.setId(a.getId());
        this.hour=a.getHour();
        this.day=a.getDay();
        this.teacherId=a.getTeacherId();
        this.disciplineId=a.getDisciplineId();
    }

    @Override
    public String toString() {
        return "Activity{" +
                "activityType='" + activityType + '\'' +
                ", day='" + day + '\'' +
                ", hour=" + hour +
                ", teacherId=" + teacherId +
                ", disciplineId=" + disciplineId +",activity id:"+this.getId()+
                '}';
    }
}

