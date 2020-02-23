package Repository;

import Domain.Entity;
import Utils.MyException;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

public class Repository<O extends Entity>   {
    protected ArrayList<O> repo;
    Class<O> type;

    public Repository(){}

    public Repository(Class<O> type){
        this.type = type;
        this.repo=new ArrayList<O>();
    }

    public int get_index(O givenObject){
        return this.repo.indexOf(givenObject);
    }

    public void add_object(O givenObject) throws MyException, IOException {
        if(this.get_index(givenObject)==-1){
            this.repo.add(givenObject);
        }
        else{
            throw new MyException("Object exist; line 23-Repository");
        }
    }

    public void delete_object(O givenObject) throws MyException, IOException {
        if(this.get_index(givenObject)!=-1){
            this.repo.remove(this.get_index(givenObject));
        }

        else{
            throw new MyException("Object doesn't exist; line 33-Repository");
        }
    }

    public void set_at_index(O givenObject,int index) throws MyException, IOException {
        if(index<0 || index> repo.size()){
            throw new MyException("Index out of bound ;line 45-Repository");
        }
        else{
            this.repo.set(index,givenObject);
        }
    }

    public O get_by_index(int index){
        return this.repo.get(index);
    }

    public ArrayList<O> get_list(){
        return this.repo;
    }

}
