package datastructure;

public class MapNode<K, V> {
    private K key;
    V value;
    public MapNode(){}
    public MapNode(K k){
        this.key = k;
    }

    public K getKey() {
        return key;
    }

    public MapNode(K k, V v){
        this.key = k;
        this.value = v;
    }
    @Override
    public boolean equals(Object o){
        if(o.getClass() != MapNode.class) return false;
        var k = ((MapNode<?, ?>) o).key;
        return k.equals(key);
    }

    @Override
    public String toString() {
        return this.key.toString() + " -> " + this.value.toString();
    }
}

