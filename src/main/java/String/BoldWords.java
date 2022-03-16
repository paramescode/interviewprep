package String;

//https://leetcode.com/problems/bold-words-in-string/

/** Given a set of keywords words and a string S, make all appearances of all keywords in S bold.
 * Any letters between <b> and </b> tags become bold.

 The returned string should use the least number of tags possible,
 and of course the tags should form a valid combination.

 For example, given that words = ["ab", "bc"] and S = "aabcd", we should return "a<b>abc</b>d".
 Note that returning "a<b>a<b>b</b>c</b>d" would use more tags, so it is incorrect.
 *
 * */
public class BoldWords {

    public static String boldWords(String[] words, String S) {

        // Idea here is to find the match and mark all the chars index as true
        // and
        boolean [] bold = new boolean[S.length()];

        int lastIndex = 0;
        for(String w : words){
            lastIndex = 0;
            while(lastIndex < S.length()){
                lastIndex =  S.indexOf(w, lastIndex) ;
                if(lastIndex <0){
                    break;
                }
                int i= lastIndex;
                for(; i < lastIndex + w.length(); i++){
                    bold[i]  =true;
                }
                lastIndex = lastIndex + 1; // next lookup from next location of prevIndex
            }

        }

        StringBuilder sb = new StringBuilder();
        boolean open = false;
        for(int i=0; i < S.length() ;i++){

            if(bold[i] && !open){
                sb.append("<b>");
                open = true;
            }else if(!bold[i] && open){
                sb.append("</b>");
                open = false;
            }

            sb.append(S.charAt(i));
        }
        if(open)
            sb.append("</b>");

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(boldWords(new String[]{"ab" , "bc"},  "aabcd"));
    }
}
