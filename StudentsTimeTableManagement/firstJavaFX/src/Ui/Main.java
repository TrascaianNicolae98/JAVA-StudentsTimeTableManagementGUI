package Ui;

import Domain.*;
import Repository.*;
import Service.Controller;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


import java.io.*;
import java.util.Properties;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{


        Repository<Activity> activityRepository;
        Repository<Teacher> teacherRepository;
        Repository<Discipline> disciplineRepository;
        Repository<Room> roomRepository;
        Repository<Formation> formationRepository;

        Properties properties=null;
        try{
            properties=readProperties("C:\\Users\\trasc\\IdeaProjects\\firstJavaFX\\src\\settings.properties");
        }catch (Exception e){
            e.printStackTrace();
        }

        activityRepository=new RepositoryBinary<Activity>(Activity.class,properties.getProperty("ActivitiesBinary"));
        disciplineRepository=new RepositoryDisciplineDB(Discipline.class,properties.getProperty("DisciplinesDB"));
        teacherRepository=new RepositoryTeacherDB(Teacher.class,properties.getProperty("TeachersDB"));
        roomRepository=new RepositoryBinary<Room>(Room.class,properties.getProperty("RoomsBinary"));
        formationRepository=new RepositoryBinary<Formation>(Formation.class,properties.getProperty("FormationsBinary"));

        Controller ctrl=new Controller(activityRepository,disciplineRepository,teacherRepository,roomRepository,formationRepository);

        FXMLLoader    loader        = new FXMLLoader(getClass().getResource("sample.fxml"));
        GUIController guiController = new GUIController(ctrl);
        loader.setController(guiController);
        Parent root = loader.load();

        primaryStage.setTitle("Time table");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

    private static Properties readProperties(String file) throws Exception {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(file));
        } catch (Exception e) {
            throw new Exception("cant read properties");
        }
        return properties;
    }
}
