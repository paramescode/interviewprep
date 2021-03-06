package graph;

import java.util.*;

/**
 * Given a list of airline tickets represented by pairs of departure and arrival airports [from, to], reconstruct the itinerary in order. All of the tickets belong to a man who departs from JFK. Thus, the itinerary must begin with JFK.

 Note:

 If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order when read as a single string. For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
 All airports are represented by three capital letters (IATA code).
 You may assume all tickets form at least one valid itinerary.

 Example 1:

 Input: [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
 Output: ["JFK", "MUC", "LHR", "SFO", "SJC"]

 Example 2:

 Input: [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
 Output: ["JFK","ATL","JFK","SFO","ATL","SFO"]
 Explanation: Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"].
 But it is larger in lexical order.

 * **/
//https://leetcode.com/problems/reconstruct-itinerary/
public class ReconstructItenary {

    HashMap<String, PriorityQueue<String>> ites = new HashMap<>();

    public List<String> findItinerary(List<List<String>> tickets) {
        for(List<String> ticket : tickets){
            if(ites.get(ticket.get(0)) == null){
                ites.put(ticket.get(0), new PriorityQueue<String>());
            }

            ites.get(ticket.get(0)).offer(ticket.get(1));
        }

        List<String> res = new ArrayList<>();
        //res.add("JFK");
        getValues("JFK", res);
        Collections.reverse(res);
        return res;
    }

    private void getValues(String key, List<String> res){

        PriorityQueue<String> des = ites.get(key);
        //ites.remove()
        //Collections.sort(des);
        if(des != null){
            while(!des.isEmpty()){
                getValues(des.poll(), res);
            }
        }

        res.add(key);

    }

    public static void main(String[] args) {

    }
}
