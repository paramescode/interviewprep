package Design;


import java.util.Map;
import java.util.TreeMap;
import java.util.HashMap;

class TimeBasedKeyValueStore {
    Map<String, TreeMap<Integer, String>> timeMap;

    /** Initialize your data structure here. */
    public TimeBasedKeyValueStore() {
        timeMap = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if(timeMap.get(key) != null){
            TreeMap<Integer, String> map = timeMap.get(key);
            map.put(timestamp, value);
        }else{
            TreeMap<Integer, String> map = new TreeMap<>();
            map.put(timestamp, value);
            timeMap.put(key, map);
        }
    }

    public String get(String key, int timestamp) {
        if(timeMap.get(key) != null){
            TreeMap<Integer, String> map = timeMap.get(key);
            Integer k = map.floorKey(timestamp);
            if(k == null)
                return "";
            return map.get(k);
        }else{
            return "";
        }
    }


}