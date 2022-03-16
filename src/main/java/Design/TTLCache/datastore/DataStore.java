package Design.TTLCache.datastore;

import java.util.concurrent.ConcurrentHashMap;

public class DataStore<K, V>{


    class ValueNode{

        V value;
        long ttl;

        ValueNode( V value, long ttl){
            this.value = value;
            this.ttl = ttl;
        }
    }


    private ConcurrentHashMap<K, ValueNode> map ;

    public DataStore(){
        map = new ConcurrentHashMap<>();
    }

    public void put(K key, V value, long ttl){
        map.put(key, new ValueNode(value, ttl));
    }

    public void put(K key, V value){
        put(key, value, 0);
    }

    public V get(K key){
        return map.get(key) != null ? map.get(key).value : null;
    }

    public void remove(K key){
        map.remove(key);
    }

    public void removeAll(){
        map.clear();
    }

    public long getExpiryTime(K key){
        return map.get(key) != null ? map.get(key).ttl : Long.MAX_VALUE;
    }
}
