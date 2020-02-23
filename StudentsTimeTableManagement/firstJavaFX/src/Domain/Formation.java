package Domain;

import java.io.Serializable;

public class Formation extends Entity implements Serializable {

    private String type;
    private int nrOfStudents;
    public Formation(){

    }



    public Formation(int n,int i,String t){
        this.nrOfStudents=n;
        this.setId(i);
        this.type=t;
    }


    public int getNrOfStudents() {
        return nrOfStudents;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setNrOfStudents(int nrOfStudents) {
        this.nrOfStudents = nrOfStudents;
    }

    @Override
    public String toString() {
        return "Formation{" +
                "type=" + type +
                ", nrOfStudents=" + nrOfStudents +",group id:"+this.getId()+
                '}';
    }
}
