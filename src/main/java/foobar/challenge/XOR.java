package foobar.challenge;

public class XOR {

    public static int solution(int start, int length) {
        //Your code goes here.
        int result = 0;
        for(int i =0 ; i < length; i ++){
            for(int j=0; j < length - i; j ++){
                result = result ^ start;
                System.out.println(start);
                start ++;
            }
            start = start + i;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(solution(0,3));
        System.out.println(solution(17,4));
    }
}
