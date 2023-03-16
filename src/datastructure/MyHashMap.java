package datastructure;

import java.lang.reflect.Array;
//More the N, more the time of every operation
//approaches to O(1)
public class MyHashMap<K, V> {
    private int size;
    private final int N = 1000;
    DoublyLinkedList<MapNode<K,V>>[] map;
    public MyHashMap() {
        size = 0;
        map =  (DoublyLinkedList<MapNode<K, V>>[]) Array.newInstance(DoublyLinkedList.class, N);
    }

    public int size() {
        return size;
    }

    public void put(K key, V value){
        int index = Math.abs(key.hashCode()) % N;
        if(map[index] == null) map[index] = new DoublyLinkedList<>();
        MapNode<K, V> node = new MapNode<>(key, value);
        size -= map[index].size();
        map[index].remove(node);
        map[index].add(node);
        size += map[index].size();
    }

    public void remove(K key){
        int index = Math.abs(key.hashCode()) % N;
        if(map[index] == null) return;
        MapNode<K, V> node = new MapNode<>(key);
        size -= map[index].size();
        map[index].remove(node);
        size += map[index].size();
    }

    public boolean containsKey(K key){
        int index = Math.abs(key.hashCode()) % N;
        MapNode<K, V> node = new MapNode<>(key);
        return map[index].contains(node);
    }
    public V get(K key){
        int index = Math.abs(key.hashCode()) % N;
        MapNode<K, V> node = map[index].containsK(new MapNode<>(key));
        if(node == null) return null;
        return node.value;
    }
    public void forEach(ForEach<MapNode<K, V>> func){
        for(var a: map){
            if(a == null) continue;
            for(var element: a){
                func.run(element);
            }
        }
    }

    public void forEachKey(ForEach<K> func){
        for(var a: map){
            if(a == null) continue;
            for(var element: a){
                func.run(element.getKey());
            }
        }
    }

    public void forEachValue(ForEach<V> func){
        for(var a: map){
            if(a == null) continue;
            for(var element: a){
                func.run(element.value);
            }
        }
    }

}
