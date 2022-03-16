package Tree;

//https://leetcode.com/problems/smallest-common-region/

/*
*You are given some lists of regions where the first region of each list includes all other regions in that list.

Naturally, if a region X contains another region Y then X is bigger than Y. Also by definition a region X contains itself.

Given two regions region1, region2, find out the smallest region that contains both of them.

If you are given regions r1, r2 and r3 such that r1 includes r3, it is guaranteed there is no r2 such that r2 includes r3.

It's guaranteed the smallest region exists.



Example 1:

Input:
regions = [["Earth","North America","South America"],
["North America","United States","Canada"],
["United States","New York","Boston"],
["Canada","Ontario","Quebec"],
["South America","Brazil"]],
region1 = "Quebec",
region2 = "New York"
Output: "North America"

*
* */
import java.util.*;

public class LowestCommonAncesstorII {

    public static String findSmallestRegion(List<List<String>> regions, String region1, String region2) {

        Map<String, String> parents = new HashMap<>();

        for(List<String> region :  regions){
            int size = region.size();
            for(int i = size - 1; i >0; i-- ){
                parents.put(region.get(i), region.get(0));
            }

        }


        String parent = region1;

        Set<String> path = new HashSet<>();

        while(parent != null){
            path.add(parent);
            parent = parents.get(parent);

        }

        parent = region2;

        while(parent != null){
            if(path.contains(parent))
                return parent;

            path.add(parent);
            parent = parents.get(parent);

        }

        return "";

    }



}
