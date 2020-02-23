/*package Domain;

import Utils.MyException;

import java.io.Serializable;
import java.util.Scanner;



public class TreeFormation extends Entity implements Serializable {
    private Tree<Formation> treeFormation;


    public TreeFormation(int id) {
        this.treeFormation = new Tree<Formation>(null);
        this.setId(id);

    }

    public Node<Formation> get_nodeFormation(Formation f){
        return this.treeFormation.find(this.treeFormation.getParent(),f);
    }


    public void add_group(Formation parent, Formation group) throws MyException {
        this.treeFormation.insert(parent,group);

    }

    public Formation get_by_id(int id){
        Formation f=new Formation(5,id,Domain.Formation.Type.valueOf("group"));
        return this.treeFormation.find(this.treeFormation.getParent(),f).getData();
    }

    public boolean equals(Node<Formation> node) {
        return treeFormation.getParent().getData().getId() == node.getData().getId();
    }

    public Formation get_root() {
        return treeFormation.getParent().getData();
    }

    public void set_root(Formation f){
        this.treeFormation.insert(null,f);
    }
    @Override
    public String toString() {
        return  this.treeFormation.traversal_in_order()+",formation id:"+this.getId();
    }

}*/
