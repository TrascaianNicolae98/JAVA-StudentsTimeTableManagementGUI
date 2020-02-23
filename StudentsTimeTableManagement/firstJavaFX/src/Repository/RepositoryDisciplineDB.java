package Repository;

import Domain.Discipline;
import Utils.MyException;

import java.io.IOException;
import java.sql.*;

public class RepositoryDisciplineDB extends Repository<Discipline> {
    private String fileName;
    private Connection conn=null;

    public RepositoryDisciplineDB(Class<Discipline> type,String fileName){
        super(type);
        this.fileName=fileName;
        this.openConnection();
        this.createTableView();
        this.readDisciplines();
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
            st.executeUpdate("CREATE TABLE IF NOT EXISTS Discipline([name] varchar(50),nrOfCredits int,id int)");
            st.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private void readDisciplines() {
        try{
            PreparedStatement st=conn.prepareStatement("SELECT * FROM Discipline");
            ResultSet rs=st.executeQuery();
            while(rs.next())
                this.repo.add(new Discipline(rs.getString("name"), rs.getInt("nrOfCredits"),rs.getInt("id")));
            rs.close();
            st.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void add_object(Discipline d) throws MyException, IOException {
        super.add_object(d);
        try{
            PreparedStatement st=conn.prepareStatement("INSERT INTO Discipline VALUES(?,?,?)");
            st.setString(1,d.getName());
            st.setInt(2,d.getNrOfCredits());
            st.setInt(3,d.getId());
            st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete_object(Discipline givenObject) throws MyException, IOException {
        super.delete_object(givenObject);
        try{
            PreparedStatement st=conn.prepareStatement("DELETE FROM Discipline WHERE id=?");
            st.setInt(1,givenObject.getId());
            st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void set_at_index(Discipline givenObject, int index) throws MyException, IOException {
        super.set_at_index(givenObject, index);
        Discipline d=this.get_by_index(index);
        try{
            PreparedStatement st=conn.prepareStatement("UPDATE Discipline SET [name]=?,nrOfCredits=?,id=? WHERE id=?");
            st.setString(1,givenObject.getName());
            st.setInt(2,givenObject.getNrOfCredits());
            st.setInt(3,givenObject.getId());
            st.setInt(4,d.getId());
            st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
