package String;

public class DecodedStringAtIndex {


    // not optimal
    public static String decodeAtIndex(String S, int K) {
        if(K == 1)
            return "" + S.charAt(0);

        StringBuilder sb = new StringBuilder();

        for(int i=0; i < S.length(); i++){
            if(S.charAt(i) - '0' >  0 && S.charAt(i) - '0' <= 9 ){
                String s = sb.toString();
                int t = S.charAt(i) - '0';
                t = t - 1; //d-1 more times in total.
                while(t > 0){
                    sb.append(s);
                    t--;
                }

            }else{
                //charStack.push(S.charAt(i));
                sb.append(S.charAt(i));
            }
        }

        String res = sb.toString();
        return res.substring(K - 1, K );

    }

    //optimal
    public static String decodeAtIndex1(String S, int K) {
        if(K == 1)
            return "" + S.charAt(0);


        for(int i=0; i < S.length(); i++){
            if(S.charAt(i) - '0' >  0 && S.charAt(i) - '0' <= 9 ){

                int t = S.charAt(i) - '0';
                t = i * t; // repeat t times i length str
                if(K > t){
                    K = K - t;
                }

            }
        }

         return "" + S.charAt(K);

    }

    public static void main(String[] args) {
        System.out.println(decodeAtIndex1("leet2code3", 10));

        System.out.println(decodeAtIndex1("ha22", 5));

        System.out.println(decodeAtIndex1("a2345678999999999999999", 1));

    }
}
