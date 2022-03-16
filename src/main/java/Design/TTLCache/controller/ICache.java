package Design.TTLCache.controller;

public interface ICache<K,V> {

    public void init();
    public void start();
    public void stop();
    public void put(K key, V value);
    public void put(K key, V value, long ttl);
    public V get(K key);
    public long getExpirationTime(K key);
    public void setEvictionTime(long evictionTime);

    public void delete(K key);
    public void deleteCache();

}
