package Repository;

import Domain.Discipline;
import Domain.Teacher;
import Utils.MyException;

import java.io.IOException;
import java.sql.*;

public class RepositoryTeacherDB extends Repository<Teacher> {
    private String fileName;
    private Connection conn=null;

    public RepositoryTeacherDB(Class<Teacher> type, String fileName){
        super(type);
        this.fileName=fileName;
        this.openConnection();
        this.createTableView();
        this.readTeachers();
    }

    private void openConnection() {
        try{
            if(conn==null || conn.isClosed())
                conn= DriverManager.getConnection("jdbc:sqlite:"+this.fileName);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void createTableView() {
        try{
            final Statement st=conn.createStatement();
            st.executeUpdate("CREATE TABLE IF NOT EXISTS Teacher([name] varchar(50),[surname] varchar(50),id int,[email] varchar(50),[rank] varchar(50))");
            st.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private void readTeachers() {
        try{
            PreparedStatement st=conn.prepareStatement("SELECT * FROM Teacher");
            ResultSet rs=st.executeQuery();
            while(rs.next())
                this.repo.add(new Teacher(rs.getString("name"),rs.getString("surname") ,rs.getInt("id"),rs.getString("email"),rs.getString("rank")));
            rs.close();
            st.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void add_object(Teacher d) throws MyException, IOException {
        super.add_object(d);
        try{
            PreparedStatement st=conn.prepareStatement("INSERT INTO Teacher VALUES(?,?,?,?,?)");
            st.setString(1,d.getName());
            st.setString(2,d.getSurName());
            st.setInt(3,d.getId());
            st.setString(4,d.getEmail());
            st.setString(5,d.getRank());
            st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete_object(Teacher givenObject) throws MyException, IOException {
        super.delete_object(givenObject);
        try{
            PreparedStatement st=conn.prepareStatement("DELETE FROM Teacher WHERE id=?");
            st.setInt(1,givenObject.getId());
            st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void set_at_index(Teacher givenObject, int index) throws MyException, IOException {
        super.set_at_index(givenObject, index);
        Teacher d=this.get_by_index(index);
        try{
            PreparedStatement st=conn.prepareStatement("UPDATE Teacher SET [name]=?,[surname]=?,id=?,[email]=?,[rank]=? WHERE id=?");
            st.setString(1,givenObject.getName());
            st.setString(2,givenObject.getSurName());
            st.setInt(3,givenObject.getId());
            st.setString(4,givenObject.getEmail());
            st.setString(5,givenObject.getRank());
            st.setInt(6,d.getId());
            st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
