package Domain;

import java.io.Serializable;
import java.util.ArrayList;

public class Node<T> implements Serializable {
    private T data;
    private Node<T> parent;
    private ArrayList<Node<T>> children;

    public Node(){
        this.children=new ArrayList<Node<T>>();
    }


    public Node<T> getParent() {
        return parent;
    }

    public void setChildren(ArrayList<Node<T>> children) {
        this.children = children;
    }

    public void set_data(T data){
        this.data=data;
    }

    public void setParent(Node<T> parent) {
        this.parent = parent;
    }

    public void set_children(ArrayList<Node<T>> c){
        this.parent.children=c;

    }


    public T getData() {
        return data;
    }

    public ArrayList<Node<T>> getChildren() {
        return children;
    }

    public void add_children(Node<T> child){

        this.children.add(child);


    }

}
