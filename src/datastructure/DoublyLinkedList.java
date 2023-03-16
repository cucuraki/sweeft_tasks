package datastructure;

import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;


//After finding node removing it needs O(1) time, so if the node is
//given removing is O(1) time operation
public class DoublyLinkedList<T> implements Collection<T> {
    private int size = 0;
    private Node<T> head;
    private Node<T> tail;

    public DoublyLinkedList(){
        head = new Node<>();
        tail = head;
        tail.next = head;
    }
    public DoublyLinkedList(T... arr) {
        if (arr.length == 0) return;
        head = new Node<>();
        var temp = head;
        for (int i = 0; i < arr.length; i++) {
            temp.next = new Node<>(arr[i], temp);
            temp = temp.next;
            size++;
        }
        tail = temp;
        tail.next = head;
    }

    public DoublyLinkedList(Iterable<T> arr){
        head = new Node<>();
        var temp = head;
        for(var a: arr){
            temp.next = new Node<>(a);
            temp = temp.next;
            size++;
        }
        tail = temp;
    }
    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        var temp = head.next;
        while (temp != head) {
            if(o.equals(temp.val)) return true;
            temp = temp.next;
        }
        return false;
    }
    T containsK(T element){
        var temp = head.next;
        while (temp != head) {
            if(element.equals(temp.val)) return temp.val;
            temp = temp.next;
        }
        return null;
    }
    @NotNull
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            final Node<T> head = DoublyLinkedList.this.head;
            Node<T> temp = head.next;
            @Override
            public boolean hasNext() {
                return temp != head;
            }

            @Override
            public T next() {
                T val = temp.val;
                temp = temp.next;
                return val;
            }
        };
    }

    @NotNull
    @Override
    public Object[] toArray() {
        Object[] ret = new Object[size];
        var temp = head.next;
        int i = 0;
        while(temp != head){
            ret[i] = temp.val;
            i++;
            temp = temp.next;
        }
        return ret;
    }

    @NotNull
    @Override
    public <T1> T1[] toArray(@NotNull T1[] a) {
        return a;
    }

    @Override
    public boolean add(T t) {
        tail.next = new Node<>(t, tail);
        tail = tail.next;
        tail.next = head;
        size++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        if(size == 0) return false;
        var temp = head.next;
        while(temp != head){
            if(o.equals(temp) || o.equals(temp.val)){
                temp.parent.next = temp.next;
                temp.next.parent = temp.parent;
                size--;
                if(tail == temp) {
                    tail = temp.parent;
                    tail.next = head;
                }
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    @Override
    public boolean containsAll(@NotNull Collection<?> c) {
        for(var a: c){
            if(!contains(a)) return false;
        }
        return true;
    }

    @Override
    public boolean addAll(@NotNull Collection<? extends T> c) {
        for(var a: c){
            add(a);
        }
        return true;
    }

    @Override
    public boolean removeAll(@NotNull Collection<?> c) {
        boolean removed = true;
        for(var a: c){
            if(!remove(a)) removed = false;
        }
        return removed;
    }

    @Override
    public boolean retainAll(@NotNull Collection<?> c) {
        HashSet<Object> set = new HashSet<>(c);
        var temp = head.next;
        while(temp != head){
            if(set.contains(temp.val))
                removeNode(temp);
            temp = temp.next;
        }
        return true;
    }

    @Override
    public void clear() {
        head = new Node<>();
        tail = head;
        tail.next = head;
        size = 0;
    }

    private void removeNode(Node<T> node){
        node.next.parent = node.parent;
        node.parent.next = node.next;
        if(node == tail){
            tail = node.parent;
            tail.next = head;
        }
        size--;
    }
}
