package Service;


import Domain.*;
import Repository.Repository;
import Utils.MyException;

import java.io.*;
import java.text.Normalizer;
import java.util.*;
import java.util.stream.Collectors;

public class Controller {
    private Repository<Activity> activities;
    private Repository<Discipline> disciplines;
    private Repository<Teacher> teachers;
    private Repository<Room> rooms;
    private Repository<Formation> groups;

    private Set<Relation> relationSet;

    public Controller(Repository<Activity> activities, Repository<Discipline> disciplines, Repository<Teacher> teachers, Repository<Room> rooms, Repository<Formation> group) throws FileNotFoundException {
        this.activities = activities;
        this.disciplines = disciplines;
        this.teachers = teachers;
        this.rooms = rooms;
        this.groups=group;
        relationSet = new LinkedHashSet<>();
        this.read_from_file_realtions();
    }

    public boolean check_relation(Activity a, Room r, Formation f) {
        boolean ok = true;
        if (this.get_index_activity_ctrl(a) == -1) {
            ok = false;
        }
        if (this.get_index_room_ctrl(r) == -1) {
            ok = false;
        }
        if (this.get_index_formation_ctrl(f) == -1) {
            ok = false;
        }
        return ok;

    }

    public void add_relation(Activity a, Room r, Formation f) throws MyException, IOException {
        if (this.check_relation(a, r, f) == false) {
            throw new MyException("Can't add relation -line 49-Controller");
        } else {
            try {
                this.relationSet.add(new Relation(a, r, f,this.teachers.get_list(),this.disciplines.get_list()));
                this.write_to_file_relations();
            } catch (Exception e) {
                throw e;
            }
        }

    }

    public void write_to_file_relations() throws IOException{
        FileOutputStream fos=new FileOutputStream("C:\\Users\\trasc\\IdeaProjects\\firstJavaFX\\res\\relations.bin");
        ObjectOutputStream oos=new ObjectOutputStream(fos);
        oos.writeObject(this.relationSet);
        oos.close();
        fos.close();
    }

    public void read_from_file_realtions() throws FileNotFoundException {
        FileInputStream fstream=new FileInputStream("C:\\Users\\trasc\\IdeaProjects\\firstJavaFX\\res\\relations.bin");
        try{
            ObjectInputStream ostream=new ObjectInputStream(fstream);
            this.relationSet=(Set<Relation>)ostream.readObject();
            ostream.close();
            fstream.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void delete_relation(Activity a, Room r, Formation f) {
        Relation relation = new Relation(a, r, f,this.teachers.get_list(),this.disciplines.get_list());
        try {
            this.relationSet.remove(relation);
        } catch (Exception e) {
            throw  e;
        }
    }


    public int get_index_activity_ctrl(Activity a) {
        return this.activities.get_index(a);
    }

    public Activity get_by_index_activity(int index) {
        return this.activities.get_by_index(index);
    }

    public int get_index_discipline_ctrl(Discipline a) {
        return this.disciplines.get_index(a);
    }


    public int get_index_teacher_ctrl(Teacher a) {
        return this.teachers.get_index(a);
    }

    public int get_index_room_ctrl(Room a) {
        return this.rooms.get_index(a);
    }

    public Room get_by_index_room(int index) {
        return this.rooms.get_by_index(index);
    }

    public int get_index_formation_ctrl(Formation a) {
        return this.groups.get_index(a);
    }

    public Formation get_by_index_formation(int index) {
        return this.groups.get_by_index(index);
    }

    public void add_activity_ctrl(Activity a) throws MyException, IOException {

        this.activities.add_object(a);

    }

    public void delete_activity_ctrl(Activity a) throws MyException, IOException {
        try {
            this.activities.delete_object(a);
        } catch (MyException e) {
            throw e;
        }
    }

    public void update_activity_ctrl(Activity a, int index) throws MyException, IOException {
        this.activities.set_at_index(a, index);

    }


    public void add_discipline_ctrl(Discipline a) throws IOException, MyException {
        this.disciplines.add_object(a);

    }

    public void delete_discipline_ctrl(Discipline a) throws MyException, IOException {

        this.disciplines.delete_object(a);

    }

    public void update_discipline_ctrl(Discipline a, int index) throws MyException, IOException {

        this.disciplines.set_at_index(a, index);

    }

    public void add_teacher_ctrl(Teacher a) throws IOException, MyException {

        this.teachers.add_object(a);
    }

    public void delete_teacher_ctrl(Teacher a) throws MyException, IOException {
        this.teachers.delete_object(a);
    }

    public void update_teacher_ctrl(Teacher a, int index) throws MyException, IOException {
        this.teachers.set_at_index(a, index);
    }

    public void add_room_ctrl(Room a) throws IOException, MyException {
        this.rooms.add_object(a);
    }

    public void delete_room_ctrl(Room a) throws MyException, IOException {
        this.rooms.delete_object(a);
    }

    public void update_room_ctrl(Room a, int index) throws MyException, IOException {
        this.rooms.set_at_index(a, index);
    }

    public void add_formation_ctrl(Formation a) throws IOException, MyException {
        this.groups.add_object(a);
    }

    public void delete_formation_ctrl(Formation a) throws MyException, IOException {
        this.groups.delete_object(a);
    }

    public void update_formation_ctrl(Formation a, int index) throws MyException, IOException {
        this.groups.set_at_index(a, index);
    }

    public void add_group(Formation g) throws IOException, MyException {
        this.groups.add_object(g);
    }

    public void delete_group(Formation g) throws IOException, MyException {
        this.groups.delete_object(g);
    }

    public int get_index_group(Formation g){
        return this.groups.get_index(g);
    }

    public Formation get_by_index(int index){
        return this.groups.get_by_index(index);
    }

    public ArrayList<Activity> get_list_activities_ctrl() {
        return this.activities.get_list();
    }

    public ArrayList<Discipline> get_list_disciplines_ctrl() {
        return this.disciplines.get_list();
    }

    public ArrayList<Teacher> get_list_teacher_ctrl() {
        return this.teachers.get_list();
    }

    public ArrayList<Room> get_list_rooms_ctrl() {
        return this.rooms.get_list();
    }

    public ArrayList<Formation> get_list_formation_ctrl() {
        return this.groups.get_list();
    }

    public Set<Relation> get_relations(){
        return this.relationSet;
    }

    public boolean check_formation_activities(Relation r){
        ArrayList<String> aux = new ArrayList<>();
        aux.add("monday");
        aux.add("tuesday");
        aux.add("wednesday");
        aux.add("thursday");
        aux.add("friday");
        String s1=""+aux.indexOf(r.getActivity().getDay())+r.getActivity().getHour();
       for(Relation r1:this.relationSet){
           if(r.getFormation().equals(r1.getFormation()))
           {
               String s2=""+aux.indexOf(r1.getActivity().getDay())+r1.getActivity().getHour();
               if(s1.equals(s2)){
                   return true;
               }

           }
       }
       return false;

    }

    public boolean check_teacher_activities(Activity a){
        ArrayList<String> aux = new ArrayList<>();
        aux.add("monday");
        aux.add("tuesday");
        aux.add("wednesday");
        aux.add("thursday");
        aux.add("friday");
        String s1=""+aux.indexOf(a.getDay())+a.getHour();
        for(Activity a1:this.activities.get_list())
        {
            if(a1.getTeacherId()==a.getTeacherId()){
                String s2=""+aux.indexOf(a1.getDay())+a1.getHour();
                if(s1.compareTo(s2)==0)
                    return true;
            }
        }
        return false;
    }

    public boolean cheack_room_activities(Relation r){
        ArrayList<String> aux = new ArrayList<>();
        aux.add("monday");
        aux.add("tuesday");
        aux.add("wednesday");
        aux.add("thursday");
        aux.add("friday");
        String s1=""+aux.indexOf(r.getActivity().getDay())+r.getActivity().getHour();
        for(Relation r1:this.relationSet){
            if(r1.getRoom().equals(r.getRoom())) {
                String s2 =""+aux.indexOf(r1.getActivity().getDay())+r1.getActivity().getHour();
                if (s1.compareTo(s2) == 0)
                    return true;
            }
        }
        return false;
    }

    public ArrayList<Teacher> teacher_filter_rank_sorted_name(String rank) {
        return (ArrayList<Teacher>) this.teachers.get_list().stream()
                .filter(teacher -> teacher.getRank().equals(rank))
                .sorted((o1, o2) -> {
                    String fullname1 = o1.getSurName() + o1.getName();
                    String fullname2 = o2.getSurName() + o2.getName();
                    return fullname1.compareTo(fullname2);
                })
                .collect(Collectors.toList());
    }

    public ArrayList<Activity> activities_by_room_sorted_time(Room r) {
        ArrayList<String> aux = new ArrayList<>();
        aux.add("monday");
        aux.add("tuesday");
        aux.add("wednesday");
        aux.add("thursday");
        aux.add("friday");

        return (ArrayList<Activity>) this.relationSet.stream().filter(relation -> relation.getRoom().equals(r)).
                sorted((o1, o2) -> {
                    int day1 = aux.indexOf(o1.getActivity().getDay());
                    int day2 = aux.indexOf(o2.getActivity().getDay());
                    String fullDate1 = "" + day1 + o1.getActivity().getHour();
                    String fullDate2 = "" + day2 + o2.getActivity().getHour();
                    return fullDate1.compareTo(fullDate2);
                })
                .map(relation -> relation.getActivity())
                .collect(Collectors.toList());


    }

    public ArrayList<Relation> get_time_table(Formation formation){
        ArrayList<String> aux = new ArrayList<>();
        aux.add("monday");
        aux.add("tuesday");
        aux.add("wednesday");
        aux.add("thursday");
        aux.add("friday");
        return (ArrayList<Relation>) this.relationSet.stream().filter(relation -> relation.getFormation().equals(formation)).
                sorted((o1, o2) -> {
                    int day1 = aux.indexOf(o1.getActivity().getDay());
                    int day2 = aux.indexOf(o2.getActivity().getDay());
                    String fullDate1 = "" + day1 + o1.getActivity().getHour();
                    String fullDate2 = "" + day2 + o2.getActivity().getHour();
                    return fullDate1.compareTo(fullDate2);
                }).collect(Collectors.toList());
    }
}
