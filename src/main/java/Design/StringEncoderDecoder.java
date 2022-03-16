package Design;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/encode-and-decode-strings/

public class StringEncoderDecoder {


    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        if(strs == null || strs.size() ==0)
            return null;

        StringBuilder sb= new StringBuilder();
        for(int i=0;i < strs.size(); i++){

            sb.append(strs.get(i).length());
            sb.append(":");
            sb.append(strs.get(i));
        }
        System.out.print(sb.toString());
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {

        List<String> res = new ArrayList<>();
        if(s == null)
            return res;

        int start = 0;
        while(start < s.length()){
            int index = s.indexOf(":", start);
            int len = Integer.parseInt(s.substring(start, index));
            res.add(s.substring(index+1, index  + len+ 1));
            start = index + len +1;

        }

        return res;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));