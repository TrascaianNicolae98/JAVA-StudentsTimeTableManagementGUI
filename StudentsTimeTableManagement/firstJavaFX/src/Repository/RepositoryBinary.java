package Repository;

import Domain.Entity;
import Utils.MyException;

import java.io.*;
import java.util.ArrayList;

public class RepositoryBinary<O extends Entity> extends Repository<O>{
    private String fileName;

    public RepositoryBinary(Class<O> type,String fileName) throws IOException {
        super(type);
        this.fileName=fileName;
        this.read_from_file_binary();

    }


    public void read_from_file_binary() throws FileNotFoundException {
        FileInputStream fstream=new FileInputStream(fileName);
        try{
            ObjectInputStream ostream=new ObjectInputStream(fstream);
            this.repo=(ArrayList<O>) ostream.readObject();
            ostream.close();
            fstream.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public void write_to_file_binary() throws IOException {
        FileOutputStream fos=new FileOutputStream(fileName);
        ObjectOutputStream oos=new ObjectOutputStream(fos);
        oos.writeObject(this.repo);
        oos.close();
        fos.close();
    }

    @Override
    public void add_object(O givenObject) throws MyException, IOException {
        super.add_object(givenObject);
        this.write_to_file_binary();
    }

    @Override
    public void delete_object(O givenObject) throws MyException, IOException {
        super.delete_object(givenObject);
        this.write_to_file_binary();
    }

    @Override
    public void set_at_index(O givenObject, int index) throws MyException, IOException {
        super.set_at_index(givenObject, index);
        this.write_to_file_binary();
    }
}
