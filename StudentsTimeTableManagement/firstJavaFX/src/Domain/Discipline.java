package Domain;

import java.io.Serializable;

public class Discipline extends Entity implements Serializable {
    private String name;
    private int nrOfCredits;

    public Discipline() {}

    public Discipline(String s){
        String token[]=s.split(",");
        this.name=token[0].strip();
        this.nrOfCredits=Integer.parseInt(token[1].strip());
        this.setId(Integer.parseInt(token[2].strip()));
    }

    public Discipline(String n, int nr, int i){
        this.name=n;
        this.nrOfCredits=nr;
        this.setId(i);
    }

    @Override
    public String toString() {
        return "Discipline{" +
                "name='" + name + '\'' +
                ", nrOfCredits=" + nrOfCredits +",discipline id:"+this.getId()+
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNrOfCredits() {
        return nrOfCredits;
    }


    public void update_discipline(Discipline d){
        this.name=d.getName();
        this.nrOfCredits=d.getNrOfCredits();
        this.setId(d.getId());
    }



    public void setNrOfCredits(int nrOfCredits) {
        this.nrOfCredits = nrOfCredits;
    }
}
