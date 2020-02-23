package Domain;

import java.io.Serializable;

public class Teacher extends Entity implements Serializable {
    private String name;
    private String surName;
    private String email;
    private String rank;

    public Teacher(){}

    public Teacher(String n, String s, int i, String e,String r){
        this.name=n;
        this.surName=s;
        this.setId(i);
        this.email=e;
        this.rank=r;
    }

    public Teacher(String s){
        String token[]=s.split(",");
        this.name=token[0].strip();
        this.surName=token[1].strip();
        this.email=token[2].strip();
        this.setId(Integer.parseInt(token[3].strip()));
        this.rank=token[4].strip();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public void update_teacher(Teacher t){
        this.name=t.getName();
        this.surName=t.getSurName();
        this.setId(t.getId());
        this.email=t.getEmail();
        this.rank=t.getRank();
    }


    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                ", email='" + email + '\'' +
                ", rank='" + rank + '\'' +",teacher id:"+this.getId()+
                '}';
    }
}