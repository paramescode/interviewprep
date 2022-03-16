package String;

import java.util.HashMap;
import java.util.Map;

public class DomainCount {

    public static Map<String, Integer> domainCount(String[] counts){

        Map<String, Integer> res = new HashMap<>();
        if(counts == null || counts.length ==0)
            return res;
        StringBuilder sb = new StringBuilder();
        for(String count : counts){

            String[] clicksByDomain = count.split("\\,");
            String[] domains = clicksByDomain[1].split("\\.");

            for( int index = domains.length - 1; index >=0; index--){

                if(sb.length() > 0)
                    sb.insert(0, ".");

                sb.insert(0, domains[index]);

                res.put(sb.toString(), res.getOrDefault(sb.toString(), 0)  + Integer.parseInt(clicksByDomain[0]));
            }
            sb.setLength(0);

        }


        return res;

    }

    public static void main(String[] args) {
        String[] counts = new String[]{
                "900,google.com", "100,mail.google.com" ,"1,google.co.uk"
        };

        Map<String , Integer> res = domainCount(counts);

        for(Map.Entry<String, Integer> entry : res.entrySet()){
            System.out.println(entry.getValue() + " " + entry.getKey());
        }
    }
}
