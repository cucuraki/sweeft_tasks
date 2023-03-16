package datastructure;

import java.util.Iterator;

public class Node<T> {
    public T val;
    public Node<T> next;
    public Node<T> parent;
    public Node(){}
    public Node(T val){this.val = val;}
    public Node(T val, Node<T> parent){
        this.val = val;
        this.parent = parent;
    }
    public Node(T val, Node<T> parent, Node<T> next){
        this.val = val;
        this.parent = parent;
        this.next = next;
    }

    @Override
    public String toString(){
        return this.val.toString();
    }
}



