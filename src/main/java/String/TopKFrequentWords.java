package String;

import java.util.*;

public class TopKFrequentWords {

    public List<String> topKFrequent(String[] words, int k) {
        List<String> res = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();

        for(String w : words)
            map.put(w, map.getOrDefault(w, 0)  +1);

        Set<Map.Entry<String,Integer>> set = map.entrySet();
        List<Map.Entry<String, Integer>> list = new ArrayList<>(set);

        Collections.sort(list, new Comparator<Map.Entry<String,Integer>>(){

            public int compare(Map.Entry<String,Integer> e1, Map.Entry<String,Integer> e2){

                return e2.getValue() - e1.getValue();
            }
        });

        int i=0;
        for(Map.Entry<String, Integer> entry : list){
            if(i < k)
                break;
            res.add(entry.getKey());
            i++;

        }

        return res;


    }

}



