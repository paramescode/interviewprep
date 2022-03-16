package String;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0, count = 0;
        if(s == null || s.length() ==0){
            return max;
        }
        int[] charArr = new int[128];

        for(int index=0; index < s.length(); index++){

            if(charArr[s.charAt(index) ] == 0){
                charArr[s.charAt(index) ] = 1;
                count ++;
            }else{
                max = Math.max(max,count);
                charArr = new int[128];
                charArr[s.charAt(index) ] = 1;
                count = 1;
            }

        }

        return max;
    }

    public int divide(int dividend, int divisor) {
        int sign = 1;

        if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0))
            sign = -1;

        long ldividend = Math.abs((long) dividend);
        long ldivisor = Math.abs((long) divisor);

        if (ldivisor == 0) return Integer.MAX_VALUE;
        if ((ldividend == 0) || (ldividend < ldivisor))	return 0;

        if(divisor == 1 || divisor == -1){
            return (int)(sign * ldividend );
        }


        int count = 0;
        while(ldividend >= 1 ){
            ldividend = ldividend - ldivisor;
            count++;
        }

        int rst;
        if(count > Integer.MAX_VALUE)
            count = sign == 1 ? Integer.MAX_VALUE: Integer.MIN_VALUE;
        else
            count = (int) (sign * count);

        return count;


    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLongestSubstring("b!bb"));

        System.out.println(solution.divide(-2147483648,-1));
        System.out.println(solution.divide(-1,1));
    }
}
