package Service;
import Domain.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;


public class Relation implements Serializable {
    private Activity activity;
    private Room room;
    private Formation formation;
    private ArrayList<Teacher> teachers;
    private ArrayList<Discipline> disciplines;

    public Relation(){}

    public Relation(Activity a, Room r, Formation f, ArrayList<Teacher> t,ArrayList<Discipline> d){
        this.activity=a;
        this.room=r;
        this.formation=f;
        this.teachers=t;
        this.disciplines=d;
    }

    public Activity getActivity() {
        return activity;
    }

    public String get_teacher_full_name(){
        String fullName="";
        for(Teacher t:this.teachers){
            if(t.getId()==activity.getTeacherId()){
                fullName=t.getName()+" "+t.getSurName();
                return fullName;
            }
        }
        return fullName;

    }

    public String get_discipline_name(){
        String name="";
        for(Discipline d:this.disciplines){
            if(d.getId()==activity.getDisciplineId()){
                name=d.getName();
                return name;
            }
        }
        return name;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Formation getFormation() {
        return formation;
    }

    public void setFormation(Formation formation) {
        this.formation = formation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Relation relation = (Relation) o;
        return activity.equals(relation.activity) &&
                room.equals(relation.room) &&
                formation.equals(relation.formation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(activity, room, formation);
    }

    @Override
    public String toString() {
        return "Relation{" +
                "activity=" + activity.toString() +
                ", room=" + room.toString() +
                ", formation=" + formation.toString() +
                '}';
    }
}
