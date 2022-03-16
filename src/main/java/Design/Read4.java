package Design;


import java.util.LinkedList;

//https://leetcode.com/problems/read-n-characters-given-read4-ii-call-multiple-times/

//see the leetcode link for the running solution as we dont have the super class method read4 here
public class Read4 {

    LinkedList<Character> dq = new LinkedList<>();
    public int read(char[] buf, int n) {

        int m = n;
        int k=0;
        while(m > 0 && !dq.isEmpty()){
            buf[k++] = dq.pollFirst();
            m--;
        }

        int l =0;
        while(m > 0){

            char[] rbuf = new char[4];
            l= read4(rbuf);

            for(int j=0; j < l;j++){
                dq.offerLast(rbuf[j]);
            }

            while(m > 0 && !dq.isEmpty()){
                buf[k++] = dq.pollFirst();
                m--;
            }

            if(l < 4)
                return n - m;

        }
        return n;
    }

    //implemneted in super class
    private int read4(char[] rbuf) {

        return 0;
    }
}
