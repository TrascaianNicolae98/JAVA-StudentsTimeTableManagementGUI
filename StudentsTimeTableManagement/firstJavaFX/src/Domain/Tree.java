package Domain;

import java.io.Serializable;
import java.util.LinkedList;

public class Tree<T> implements Serializable {
    private Node<T> parent;

    public Tree(){

    }

    public Tree(T init){
        this.parent=new Node<T>();
        // this.parent=null;
        this.parent.set_data(init);
    }

    public Node<T> find(Node<T> tata,T data) {
        if(tata.getData().equals(data)){
            return tata;
        }
        for (Node<T> node : tata.getChildren()) {
            Node<T> found = this.find(node,data);
            if (found != null) {
                return found;
            }
        }
        return null; // Not found.


    }

    public boolean insert(T parentData, T data) {
        if(this.parent.getData() == null){
            this.parent.set_data(data);
            return true;
        }
        Node dummy = new Node<T>();
        dummy.set_data(data);
        Node<T> found = find(this.parent,parentData);
        if (found .equals( null)) {
            return false;
        }
        Node child = new Node<T>();
        child.set_data(data);
        child.setParent(found);
        found.add_children(child);
        return true;
    }

    public Node<T> getParent(){
        return this.parent;
    }

    public T getParentData(){
        return this.parent.getData();
    }

    public String traversal_in_order() {
        int curlevel = 1;
        int nextlevel = 0;
        String s="";

        LinkedList<Node<T>> queue=new LinkedList<Node<T>>();
        queue.add(this.parent);

        while(!queue.isEmpty()) {
            Node<T> node = queue.remove(0);

            if (curlevel == 0) {
                s+="\n";
                curlevel = nextlevel;
                nextlevel = 0;
            }

            for(Node<T> n : node.getChildren()) {
                queue.addLast(n);
                nextlevel++;
            }

            curlevel--;
            s+=node.getData().toString()+"  ";
        }
        return s;
    }
}
