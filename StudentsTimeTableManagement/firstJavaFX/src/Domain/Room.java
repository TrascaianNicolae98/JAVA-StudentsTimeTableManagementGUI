package Domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Room extends Entity implements Serializable {
    private String Building;
    private ArrayList<String> activityTypes=new ArrayList<String>();

    public Room() {
    }

    public Room(String s){
        String token[]=s.split(",");
        this.setId(Integer.parseInt(token[0].strip()));
        this.setBuilding(token[1].strip());
        String token2[]=token[2].split(" ");
        for(String s1:token2)
            this.activityTypes.add(s1.strip());


    }

    public Room(int n, String b, List<String> a) {
        this.setId(n);
        this.Building = b;
        this.activityTypes = new ArrayList<>(a);
    }


    public String getBuilding() {
        return Building;
    }



    public ArrayList<String> getActivityTypes() {
        return activityTypes;
    }

    public void setActivityTypes(List<String> a){
        this.activityTypes=new ArrayList<>(a);
    }


    public void setActivityTypes(ArrayList<String> activityTypes) {
        this.activityTypes = activityTypes;
    }

    public void setBuilding(String building) {
        Building = building;
    }

    @Override
    public String toString() {
        String s = "";
        for (String s1 : activityTypes) {
            s += " " + s1;
        }
        return "Room{" +
                "Building='" + Building + '\'' +
                ", activityTypes=" + s+",room id:"+this.getId()+
                '}';
    }

    public void update_room(Room r) {
        this.setId(r.getId());
        this.Building = r.getBuilding();
        this.activityTypes = r.getActivityTypes();
    }


}