package String;


import java.util.*;

// https://leetcode.com/problems/analyze-user-website-visit-pattern/
class AnaluzeUserVisitorPattern {
    public static List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        List<String> pages = new ArrayList<>();

        Map<String, TreeMap<Integer, String>> visitesByUser = new HashMap<>();

        for(int i=0; i < timestamp.length;i++){
            visitesByUser.putIfAbsent(username[i], new TreeMap<Integer,String>());
            visitesByUser.get(username[i]).put(timestamp[i], website[i]);
        }

        Map<String, Integer> noOfVisites = new HashMap<>();
        int max=0;
        String res= "";

        for(String key : visitesByUser.keySet()){
            if(visitesByUser.get(key) !=null && visitesByUser.get(key).size() >=3 ){
                //get all unique paths for a user...
                Set<String> paths = getAllPaths(key, visitesByUser.get(key));
                for(String path : paths){
                    noOfVisites.put(path, noOfVisites.getOrDefault(path, 0) + 1);
                    int count = noOfVisites.get(path);

                    if(count > max || (count == max && path.compareTo(res) < 0)){
                        max = count;
                        res= path;
                    }
                }
            }
        }

        String[] temp = res.split("_");
        for(String t : temp)
            pages.add(t);

        return pages;

    }

    private static Set<String> getAllPaths(String key, TreeMap<Integer, String> twMap){
        Set<String> paths = new HashSet<String>();

        StringBuilder sb = new StringBuilder();
        List<String> values = new ArrayList(twMap.values());
        for(int i=0;i < values.size() -2 ; i++){

            for(int j= i + 1; j < values.size() -1; j++ ){


                for(int k = j +1; k < values.size(); k++){
                    sb.append(values.get(i));

                    sb.append("_");
                    sb.append(values.get(j));

                    sb.append("_");
                    sb.append(values.get(k));
                    //System.out.println(sb.toString());
                    paths.add(sb.toString());
                    sb.setLength(0);
                }

            }
        }
        return paths;
    }
    public static void main(String[] args) {

        String[] username = new String[]{"h","eiy","cq","h","cq","txldsscx","cq","txldsscx","h","cq","cq"};
        int[] time = new int[]{527896567,334462937,517687281,134127993,859112386,159548699,51100299,444082139,926837079,317455832,411747930};
        String[] website = new String[]{"hibympufi","hibympufi","hibympufi","hibympufi","hibympufi","hibympufi","hibympufi","hibympufi","yljmntrclw","hibympufi","yljmntrclw"};
        List<String> res = mostVisitedPattern(username, time, website);
        res.forEach(x -> System.out.println(x));
    }
}
