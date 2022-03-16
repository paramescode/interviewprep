package Design.TTLCache.controller;

import Design.TTLCache.datastore.DataStore;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TTLCache<K, V> implements ICache<K,V>{

    class DataNode{

        K key;
        long ttl;

        DataNode(K key, long ttl){
            this.key = key;
            this.ttl = ttl;
        }
    }

    private PriorityQueue<DataNode> ttlOrdedList = new PriorityQueue<>(new Comparator<DataNode>() {
        @Override
        public int compare(DataNode o1, DataNode o2) {
            return (int) (o1.ttl - o2.ttl);
        }
    });

    private boolean isEvictionStarted = false;

    private long evictionPeriod  = 1;

    private DataStore<K,V> dataStore;

    TTLCache(){
        this.dataStore = new DataStore<>();
    }

    @Override
    public void init() {

    }

    @Override
    public synchronized void start() {
        if(! this.isEvictionStarted){
            this.isEvictionStarted = true;
            startEvictionProcess();
        }
    }

    private void startEvictionProcess() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(isEvictionStarted){
                    synchronized (ttlOrdedList){
                        evictData();
                    }

                    try{
                        Thread.sleep(evictionPeriod);
                    }catch (InterruptedException ie){
                        Logger.getLogger(TTLCache.class.getName()).log(Level.SEVERE, "Error while evicting the elements from cache", ie);
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }).start();
    }

    private void evictData() {
        while(ttlOrdedList.size() > 0 && ttlOrdedList.peek().ttl <= System.currentTimeMillis()){
            DataNode dataNode = ttlOrdedList.poll();
            dataStore.remove(dataNode.key);
        }
    }

    @Override
    public synchronized void stop() {
        this.isEvictionStarted = false;
    }

    @Override
    public void put(K key, V value) {
        this.put(key, value, 0);
    }

    @Override
    public void put(K key, V value, long ttl) {
        start();

        ttl = ttl != 0 ? ttl : (1l * 365 * 24 * 60 * 60 * 1000) ;
        long cacheUpTo = System.currentTimeMillis() + ttl;

        synchronized (ttlOrdedList){
            dataStore.put(key, value, cacheUpTo);
            ttlOrdedList.add(new DataNode(key, cacheUpTo));
        }

    }

    @Override
    public V get(K key) {
        return dataStore.get(key);
    }

    @Override
    public long getExpirationTime(K key) {
        return dataStore.getExpiryTime(key);
    }

    @Override
    public synchronized void setEvictionTime(long evictionTime) {
        this.evictionPeriod = evictionTime;
    }


    @Override
    public void delete(K key) {
        dataStore.remove(key);
    }

    @Override
    public void deleteCache() {
        stop();
        dataStore.removeAll();
        this.ttlOrdedList.clear();
    }


}
