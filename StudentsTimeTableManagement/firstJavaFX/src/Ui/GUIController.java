package Ui;

import Domain.*;
import Service.Controller;
import Service.Relation;
import javafx.beans.property.ReadOnlyIntegerWrapper;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableSet;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

import java.util.ArrayList;

public class GUIController {

    private Controller ctrl;

    public GUIController(Controller ctrl) {
        this.ctrl = ctrl;
    }

    public void set_controller(Controller ctrl) {
        this.ctrl = ctrl;
    }



    @FXML
    private TableView<Activity> activityTable;

    @FXML
    private TableColumn<Activity, String> activityTypeRow;

    @FXML
    private TableColumn<Activity, String> activityDayRow;

    @FXML
    private TableColumn<Activity, String> activityHourRow;

    @FXML
    private TableColumn<Activity, String> activityTeacherIdRow;

    @FXML
    private TableColumn<Activity, String> activityDisciplineIdRow;

    @FXML
    private TableColumn<Activity, String> activityIdRow;

    @FXML
    private Button getAllActivitiesB;

    @FXML
    private TextField activityTypeText;

    @FXML
    private TextField activityDayText;

    @FXML
    private TextField activityHourText;

    @FXML
    private TextField activityTeacherIdText;

    @FXML
    private TextField activityDisciplineIdText;

    @FXML
    private TextField activityIdText;

    @FXML
    private Button activityAddB;

    @FXML
    private Button activityDeleteB;

    @FXML
    private Button activityUpdateB;

    @FXML
    private TableColumn<?, ?> disciplineNameRow;

    @FXML
    private TableColumn<?, ?> disciplineCreditsRow;

    @FXML
    private TableColumn<?, ?> disciplineIdRow;

    @FXML
    private Button getAllDisciplinesB;

    @FXML
    private TextField disciplineNameText;

    @FXML
    private TextField disciplineCreditsText;

    @FXML
    private TextField disciplineIdText;

    @FXML
    private Button disciplineAddB;

    @FXML
    private Button disciplineDeleteB;

    @FXML
    private Button disciplineUpdateB;

    @FXML
    private Button getAllTeachersB;

    @FXML
    private TextField teacherNameText;

    @FXML
    private TextField teacherSurNameText;

    @FXML
    private TextField teacherEmailText;

    @FXML
    private TextField teacherRankText;

    @FXML
    private TextField teacherIdText;

    @FXML
    private Button teacherAddB;

    @FXML
    private Button teacherDeleteB;

    @FXML
    private Button teacherUpdateB;

    @FXML
    private TableColumn<?, ?> teacherNameRow;

    @FXML
    private TableColumn<?, ?> teacherSurnameRow;

    @FXML
    private TableColumn<?, ?> teacherEmailRow;

    @FXML
    private TableColumn<?, ?> teacherRankRow;

    @FXML
    private TableColumn<?, ?> teacherIdRow;

    @FXML
    private TableColumn<?, ?> formationTypeRow;

    @FXML
    private TableColumn<?, ?> formationStudentsRow;

    @FXML
    private TableColumn<?, ?> formationIdRow;

    @FXML
    private Button getAllFormationsB;

    @FXML
    private TextField formationTypeText;

    @FXML
    private TextField formationStudentsText;

    @FXML
    private TextField formationIdText;

    @FXML
    private Button formationAddB;

    @FXML
    private Button formationDeleteB;

    @FXML
    private Button formationUpdateB;

    @FXML
    private TableColumn<?, ?> roomBuildingRow;

    @FXML
    private TableColumn<?, ?> roomActivityTypesRow;

    @FXML
    private TableColumn<?, ?> roomIdRow;

    @FXML
    private Button getAllRoomsB;

    @FXML
    private TextField roomBuildingText;

    @FXML
    private TextField roomActivityTypesText;

    @FXML
    private TextField roomIdText;

    @FXML
    private Button roomAddB;

    @FXML
    private Button roomDeleteB;

    @FXML
    private Button roomUpdateB;

    @FXML
    private TableView<Relation> relationTable;

    @FXML
    private TableColumn<Relation, String> relationActivityRow;

    @FXML
    private TableColumn<Relation, String> relationFormationRow;

    @FXML
    private TableColumn<Relation, String> relationRoomRow;

    @FXML
    private Button getAllRoomsB1;

    @FXML
    private TextField relationActivityIdText;

    @FXML
    private TextField relationFormationIdText;

    @FXML
    private TextField relationRoomIdText;

    @FXML
    private Button relationAddB;

    @FXML
    private Button relationDeleteB;

    @FXML
    private Button relationUpdateB;

    @FXML
    private Button GetTimeTableB;

    @FXML
    private TableView<Discipline> disciplineTable;

    @FXML
    private TableView<Teacher> teacherTable;

    @FXML
    private TableView<Formation> formationTable;

    @FXML
    private TableView<Room> roomTable;

    @FXML
    private TableView<Relation> timeTable;

    @FXML
    private TableColumn<Relation, String> timeTableMonday;

    @FXML
    private TableColumn<Relation, String> timeTableTuesday;

    @FXML
    private TableColumn<Relation, String> timeTableWednesday;

    @FXML
    private TableColumn<Relation, String> timeTableThursday;

    @FXML
    private TableColumn<Relation, String> timeTableFriday;





    @FXML
    void activity_add_handler(ActionEvent event) {
        String activityType,day,hour;
        int teacherId,disciplineId,activityId;
        activityType=this.activityTypeText.getText();
        day=this.activityDayText.getText();
        hour=this.activityHourText.getText();
        teacherId=Integer.parseInt(this.activityTeacherIdText.getText());
        disciplineId=Integer.parseInt(this.activityDisciplineIdText.getText());
        activityId=Integer.parseInt(this.activityIdText.getText());
        Activity a=new Activity(activityType,day,hour,activityId,teacherId,disciplineId);
        if(this.ctrl.check_teacher_activities(a)==false) {
            try {
                this.ctrl.add_activity_ctrl(a);
            } catch (Exception e) {
                Alert error = new Alert(Alert.AlertType.ERROR);
                error.setHeaderText("ERROR");
                error.setContentText(e.getMessage());
                error.showAndWait();

            }
        }
        else{
            Alert error = new Alert(Alert.AlertType.ERROR);
            error.setHeaderText("ERROR");
            error.setContentText("Can't have 2 teachers in 2 places at the same time");
            error.showAndWait();
        }

    }

    @FXML
    void activity_delete_handler(ActionEvent event) {
        int ActivityId=Integer.parseInt(this.activityIdText.getText());
        Activity a=new Activity("da","da","da",ActivityId,1,2);
        try{
            this.ctrl.delete_activity_ctrl(a);
        }catch (Exception e){
            Alert error=new Alert(Alert.AlertType.ERROR);
            error.setHeaderText("ERROR");
            error.setContentText(e.getMessage());
            error.showAndWait();

        }

    }

    @FXML
    void activity_update_handler(ActionEvent event) {
        int ActivityId=Integer.parseInt(this.activityIdText.getText());
        Activity a=new Activity("da","da","da",ActivityId,1,2);
        int index=this.ctrl.get_index_activity_ctrl(a);
        String activityType,day,hour;
        int teacherId,disciplineId;
        activityType=this.activityTypeText.getText();
        day=this.activityDayText.getText();
        hour=this.activityHourText.getText();
        teacherId=Integer.parseInt(this.activityTeacherIdText.getText());
        disciplineId=Integer.parseInt(this.activityDisciplineIdText.getText());
        Activity a1=new Activity(activityType,day,hour,ActivityId,teacherId,disciplineId);
        try{
            this.ctrl.update_activity_ctrl(a1,index);
        }catch (Exception e){
            Alert error=new Alert(Alert.AlertType.ERROR);
            error.setHeaderText("ERROR");
            error.setContentText(e.getMessage());
            error.showAndWait();
        }

    }

    @FXML
    void discipline_add_handler(ActionEvent event) {
        String name;
        int credits,id;
        name=this.disciplineNameText.getText();
        credits=Integer.parseInt(this.disciplineCreditsText.getText());
        id = Integer.parseInt(this.disciplineIdText.getText());
        try{
            this.ctrl.add_discipline_ctrl(new Discipline(name,credits,id));
        }catch (Exception e){
            Alert error=new Alert(Alert.AlertType.ERROR);
            error.setHeaderText("ERROR");
            error.setContentText(e.getMessage());
            error.showAndWait();
        }

    }

    @FXML
    void discipline_delete_handler(ActionEvent event) {
        int id=Integer.parseInt(this.disciplineIdText.getText());
        try{
            this.ctrl.delete_discipline_ctrl(new Discipline("da",2,id));
        }catch (Exception e){
            Alert error=new Alert(Alert.AlertType.ERROR);
            error.setHeaderText("ERROR");
            error.setContentText(e.getMessage());
            error.showAndWait();
        }

    }

    @FXML
    void discipline_update_handler(ActionEvent event) {
        int id=Integer.parseInt(this.disciplineIdText.getText());
        String name;
        int credits;
        name=this.disciplineNameText.getText();
        credits=Integer.parseInt(this.disciplineCreditsText.getText());
        int index=this.ctrl.get_index_discipline_ctrl(new Discipline("da",2,id));
        try{
            this.ctrl.update_discipline_ctrl(new Discipline(name,credits,id),index);
        }catch (Exception e){
            Alert error=new Alert(Alert.AlertType.ERROR);
            error.setHeaderText("ERROR");
            error.setContentText(e.getMessage());
            error.showAndWait();
        }



    }

    @FXML
    void formation_Delete_handler(ActionEvent event) {
        int id=Integer.parseInt(this.formationIdText.getText());
        try{
            this.ctrl.delete_formation_ctrl(new Formation(2,id,"da"));
        }catch (Exception e){
            Alert error=new Alert(Alert.AlertType.ERROR);
            error.setHeaderText("ERROR");
            error.setContentText(e.getMessage());
            error.showAndWait();
        }



    }

    @FXML
    void formation_add_handler(ActionEvent event) {
        String type;
        int students,id;
        id=Integer.parseInt(this.formationIdText.getText());
        students=Integer.parseInt(this.formationStudentsText.getText());
        type=this.formationTypeText.getText();
        try{
            this.ctrl.add_formation_ctrl(new Formation(students,id,type));
        }catch (Exception e){
            Alert error=new Alert(Alert.AlertType.ERROR);
            error.setHeaderText("ERROR");
            error.setContentText(e.getMessage());
            error.showAndWait();
        }


    }

    @FXML
    void formation_update_handler(ActionEvent event) {
        String type;
        int students,id;
        id=Integer.parseInt(this.formationIdText.getText());
        students=Integer.parseInt(this.formationStudentsText.getText());
        type=this.formationTypeText.getText();
        int index=this.ctrl.get_index_formation_ctrl(new Formation(2,id,"da"));
        try{
            this.ctrl.update_formation_ctrl(new Formation(students,id,type),index);
        }catch (Exception e){
            Alert error=new Alert(Alert.AlertType.ERROR);
            error.setHeaderText("ERROR");
            error.setContentText(e.getMessage());
            error.showAndWait();
        }

    }

    @FXML
    void get_all_activities_handler(ActionEvent event) {
        for(Activity a:this.ctrl.get_list_activities_ctrl())
            System.out.println(a);
        System.out.println();
        System.out.println();
        this.activityTable.refresh();
        ArrayList<Activity> array=this.ctrl.get_list_activities_ctrl();
        ObservableList<Activity> obsActivity=FXCollections.observableArrayList(array);
        this.activityTable.setItems(obsActivity);
        this.activityTypeRow.setCellValueFactory(new PropertyValueFactory("activityType"));
        this.activityDayRow.setCellValueFactory(new PropertyValueFactory("day"));
        this.activityHourRow.setCellValueFactory(new PropertyValueFactory("hour"));
        this.activityTeacherIdRow.setCellValueFactory(new PropertyValueFactory("teacherId"));
        this.activityDisciplineIdRow.setCellValueFactory(new PropertyValueFactory("disciplineId"));
        this.activityIdRow.setCellValueFactory(new PropertyValueFactory("id"));




    }

    @FXML
    void get_all_disciplines_handler(ActionEvent event) {
        for(Discipline d:this.ctrl.get_list_disciplines_ctrl())
            System.out.println(d);
        System.out.println();
        System.out.println();
        this.disciplineTable.refresh();
        ArrayList<Discipline> array=this.ctrl.get_list_disciplines_ctrl();
        ObservableList<Discipline> obsDisciplines=FXCollections.observableArrayList(array);
        this.disciplineTable.setItems(obsDisciplines);
        this.disciplineNameRow.setCellValueFactory(new PropertyValueFactory("name"));
        this.disciplineCreditsRow.setCellValueFactory(new PropertyValueFactory("nrOfCredits"));
        this.disciplineIdRow.setCellValueFactory(new PropertyValueFactory("id"));


    }

    @FXML
    void get_all_formations_handler(ActionEvent event) {
        for(Formation f:this.ctrl.get_list_formation_ctrl())
            System.out.println(f);
        System.out.println();
        System.out.println();
        this.formationTable.refresh();

        ObservableList<Formation> obsFormation=FXCollections.observableArrayList(this.ctrl.get_list_formation_ctrl());
        this.formationTable.setItems(obsFormation);
        this.formationTypeRow.setCellValueFactory(new PropertyValueFactory("type"));
        this.formationStudentsRow.setCellValueFactory(new PropertyValueFactory("nrOfStudents"));
        this.formationIdRow.setCellValueFactory(new PropertyValueFactory("id"));


    }

    @FXML
    void get_all_rooms_handler(ActionEvent event) {
        for(Room r:this.ctrl.get_list_rooms_ctrl())
            System.out.println(r);
        System.out.println();
        System.out.println();
        this.roomTable.refresh();

        ObservableList<Room> obsRooms=FXCollections.observableArrayList(this.ctrl.get_list_rooms_ctrl());
        this.roomTable.setItems(obsRooms);
        this.roomBuildingRow.setCellValueFactory(new PropertyValueFactory("Building"));
        this.roomActivityTypesRow.setCellValueFactory(new PropertyValueFactory("activityTypes"));
        this.roomIdRow.setCellValueFactory(new PropertyValueFactory("id"));


    }

    @FXML
    void get_all_teachers_handler(ActionEvent event) {
        for(Teacher t:this.ctrl.get_list_teacher_ctrl())
            System.out.println(t);
        System.out.println();
        System.out.println();
        this.teacherTable.refresh();
        ObservableList<Teacher> obs=FXCollections.observableArrayList(this.ctrl.get_list_teacher_ctrl());
        this.teacherTable.setItems(obs);
        this.teacherNameRow.setCellValueFactory(new PropertyValueFactory("name"));
        this.teacherSurnameRow.setCellValueFactory(new PropertyValueFactory("surName"));
        this.teacherEmailRow.setCellValueFactory(new PropertyValueFactory("email"));
        this.teacherRankRow.setCellValueFactory(new PropertyValueFactory("rank"));
        this.teacherIdRow.setCellValueFactory(new PropertyValueFactory("id"));


    }

    @FXML
    void get_all_relations_handler(ActionEvent event) {
        ArrayList<Relation> aux1=new ArrayList<>();
        for(Relation r:this.ctrl.get_relations()){
            aux1.add(r);
            System.out.println(r);
        }


        System.out.println();
        System.out.println();
        this.relationTable.refresh();
        ObservableList<Relation> obs=FXCollections.observableArrayList(aux1);
        this.relationTable.setItems(obs);
        this.relationActivityRow.setCellValueFactory(r->new ReadOnlyStringWrapper(r.getValue().getActivity().getActivityType()));
        this.relationFormationRow.setCellValueFactory(r->new ReadOnlyStringWrapper(Integer.toString(r.getValue().getFormation().getId())));
        this.relationRoomRow.setCellValueFactory(r->new ReadOnlyStringWrapper(Integer.toString(r.getValue().getRoom().getId())));

    }

    @FXML
    void room_add_handler(ActionEvent event) {
        String building;
        ArrayList<String> activityTypes;
        int id;
        building=this.roomBuildingText.getText();
        String s=this.roomActivityTypesText.getText();
        String token[]=s.split(",");
        ArrayList<String> array=new ArrayList<>();
        for(String s1:token)
            array.add(s1);
        id = Integer.parseInt(this.roomIdText.getText());
        try{
            this.ctrl.add_room_ctrl(new Room(id,building,array));
        }catch (Exception e){
            Alert error=new Alert(Alert.AlertType.ERROR);
            error.setHeaderText("ERROR");
            error.setContentText(e.getMessage());
            error.showAndWait();
        }


    }

    @FXML
    void room_delete_handler(ActionEvent event) {
        int id=Integer.parseInt(this.roomIdText.getText());
        try{
            this.ctrl.delete_room_ctrl(new Room(id,"da",new ArrayList<String>()));
        }catch (Exception e){
            Alert error=new Alert(Alert.AlertType.ERROR);
            error.setHeaderText("ERROR");
            error.setContentText(e.getMessage());
            error.showAndWait();
        }

    }

    @FXML
    void room_update_handler(ActionEvent event) {
        String building;
        ArrayList<String> activityTypes;
        int id;
        building=this.roomBuildingText.getText();
        String s=this.roomActivityTypesText.getText();
        String token[]=s.split(",");
        ArrayList<String> array=new ArrayList<>();
        for(String s1:token)
            array.add(s1);
        id = Integer.parseInt(this.roomIdText.getText());
        int index=this.ctrl.get_index_room_ctrl(new Room(id,"da",new ArrayList<String>()));
        try{
            this.ctrl.update_room_ctrl(new Room(id,building,array),index);
        }catch (Exception e){
            Alert error=new Alert(Alert.AlertType.ERROR);
            error.setHeaderText("ERROR");
            error.setContentText(e.getMessage());
            error.showAndWait();
        }

    }

    @FXML
    void teacher_add_handler(ActionEvent event) {
        String name,surname,email,rank;
        int id;
        name=this.teacherNameText.getText();
        surname=this.teacherSurNameText.getText();
        email=this.teacherEmailText.getText();
        rank=this.teacherRankText.getText();
        id=Integer.parseInt(this.teacherIdText.getText());
            try {
                this.ctrl.add_teacher_ctrl(new Teacher(name, surname, id, email, rank));
            } catch (Exception e) {
                Alert error = new Alert(Alert.AlertType.ERROR);
                error.setHeaderText("ERROR");
                error.setContentText(e.getMessage());
                error.showAndWait();
            }
        }


    @FXML
    void teacher_delete_handler(ActionEvent event) {
        int id;
        id=Integer.parseInt(this.teacherIdText.getText());
        try{
            this.ctrl.delete_teacher_ctrl(new Teacher("da","da",id,"da","da"));
        }catch (Exception e){
            Alert error=new Alert(Alert.AlertType.ERROR);
            error.setHeaderText("ERROR");
            error.setContentText(e.getMessage());
            error.showAndWait();
        }

    }

    @FXML
    void teacher_update_handler(ActionEvent event) {
        String name,surname,email,rank;
        int id;
        name=this.teacherNameText.getText();
        surname=this.teacherSurNameText.getText();
        email=this.teacherEmailText.getText();
        rank=this.teacherRankText.getText();
        id=Integer.parseInt(this.teacherIdText.getText());
        int index=this.ctrl.get_index_teacher_ctrl(new Teacher("da","da",id,"da","da"));
        try{
            this.ctrl.update_teacher_ctrl(new Teacher(name,surname,id,email,rank),index);

        }catch (Exception e){
            Alert error=new Alert(Alert.AlertType.ERROR);
            error.setHeaderText("ERROR");
            error.setContentText(e.getMessage());
            error.showAndWait();
        }

    }

    @FXML
    void relation_add_handler(ActionEvent event) {
        int activityId,roomId,formationId;
        activityId=Integer.parseInt(this.relationActivityIdText.getText());
        roomId=Integer.parseInt(this.relationRoomIdText.getText());
        formationId=Integer.parseInt(this.relationFormationIdText.getText());
        int indexActivity=this.ctrl.get_index_activity_ctrl(new Activity("da","da","da",activityId,1,2));
        int indexRoom=this.ctrl.get_index_room_ctrl(new Room(roomId,"da",new ArrayList<String>()));
        int indexFormation=this.ctrl.get_index_formation_ctrl(new Formation(2,formationId,"da"));
        Relation r=new Relation(this.ctrl.get_by_index_activity(indexActivity),this.ctrl.get_by_index_room(indexRoom),this.ctrl.get_by_index_formation(indexFormation),this.ctrl.get_list_teacher_ctrl(),this.ctrl.get_list_disciplines_ctrl());
        if(this.ctrl.cheack_room_activities(r)==false && this.ctrl.check_formation_activities(r)==false) {
            try {
                this.ctrl.add_relation(this.ctrl.get_by_index_activity(indexActivity), this.ctrl.get_by_index_room(indexRoom), this.ctrl.get_by_index_formation(indexFormation));
            } catch (Exception e) {
                Alert error = new Alert(Alert.AlertType.ERROR);
                error.setHeaderText("ERROR");
                error.setContentText(e.getMessage());
                error.showAndWait();
            }
        }
        else{
            Alert error = new Alert(Alert.AlertType.ERROR);
            error.setHeaderText("ERROR");
            error.setContentText("Formation with 2 activities at the same time or room with 2 activities at the same time");
            error.showAndWait();
        }

    }

    @FXML
    void relation_delete_handler(ActionEvent event) {
        int activityId,roomId,formationId;
        activityId=Integer.parseInt(this.relationActivityIdText.getText());
        roomId=Integer.parseInt(this.relationRoomIdText.getText());
        formationId=Integer.parseInt(this.relationFormationIdText.getText());
        try{
            this.ctrl.delete_relation(new Activity("da","da","da",activityId,1,2),new Room(roomId,"da",new ArrayList<String>()),new Formation(2,formationId,"da"));

        }catch (Exception e){
            Alert error=new Alert(Alert.AlertType.ERROR);
            error.setHeaderText("ERROR");
            error.setContentText(e.getMessage());
            error.showAndWait();
        }

    }

    @FXML
    void relation_update_handler(ActionEvent event) {

    }

    @FXML
    void getTimeTable_handler(ActionEvent event) throws InterruptedException {
        Formation f=new Formation();
        int id=Integer.parseInt(this.relationFormationIdText.getText());
        f=this.ctrl.get_by_index_formation(this.ctrl.get_index_formation_ctrl(new Formation(5,id,"da")));
        ArrayList<Relation> relations=new ArrayList<>();
        relations=this.ctrl.get_time_table(f);


        ObservableList<Relation> obs=FXCollections.observableArrayList(relations);
        this.timeTable.setItems(obs);
        this.timeTableMonday.setCellValueFactory(r->{
            if(r.getValue().getActivity().getDay().equals("monday"))
                return new ReadOnlyStringWrapper(r.getValue().getActivity().getHour().toString()+" : "+r.getValue().get_discipline_name()+" "+r.getValue().getActivity().getActivityType()+"\n"
                        +"Professor: "+r.getValue().get_teacher_full_name()+"\n"+
                        "Room: "+r.getValue().getRoom().getId()+" "+r.getValue().getRoom().getBuilding());
            return null;
        });



        this.timeTableTuesday.setCellValueFactory(r->{
            if(r.getValue().getActivity().getDay().equals("tuesday"))
                return new ReadOnlyStringWrapper(r.getValue().getActivity().getHour().toString()+" : "+r.getValue().get_discipline_name()+" "+r.getValue().getActivity().getActivityType()+"\n"
                        +"Professor: "+r.getValue().get_teacher_full_name()+"\n"+
                        "Room: "+r.getValue().getRoom().getId()+" "+r.getValue().getRoom().getBuilding());
            return null;
        });

        this.timeTableWednesday.setCellValueFactory(r->{
            if(r.getValue().getActivity().getDay().equals("wednesday"))
                return new ReadOnlyStringWrapper(r.getValue().getActivity().getHour().toString()+" : "+r.getValue().get_discipline_name()+" "+r.getValue().getActivity().getActivityType()+"\n"
                        +"Professor: "+r.getValue().get_teacher_full_name()+"\n"+
                        "Room: "+r.getValue().getRoom().getId()+" "+r.getValue().getRoom().getBuilding());
            return null;
        });

        this.timeTableThursday.setCellValueFactory(r->{
            if(r.getValue().getActivity().getDay().equals("thursday"))
                return new ReadOnlyStringWrapper(r.getValue().getActivity().getHour().toString()+" : "+r.getValue().get_discipline_name()+" "+r.getValue().getActivity().getActivityType()+"\n"
                        +"Professor: "+r.getValue().get_teacher_full_name()+"\n"+
                        "Room: "+r.getValue().getRoom().getId()+" "+r.getValue().getRoom().getBuilding());
            return null;
        });

        this.timeTableFriday.setCellValueFactory(r->{
            if(r.getValue().getActivity().getDay().equals("friday"))
                return new ReadOnlyStringWrapper(r.getValue().getActivity().getHour().toString()+" : "+r.getValue().get_discipline_name()+" "+r.getValue().getActivity().getActivityType()+"\n"
                        +"Professor: "+r.getValue().get_teacher_full_name()+"\n"+
                        "Room: "+r.getValue().getRoom().getId()+" "+r.getValue().getRoom().getBuilding());
            return null;
        });
    }

}