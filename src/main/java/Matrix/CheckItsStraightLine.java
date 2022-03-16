package Matrix;

//https://leetcode.com/problems/check-if-it-is-a-straight-line/submissions/
public class CheckItsStraightLine {

    public static boolean checkStraightLine(int[][] a) {
        int[] first = a[0];
        int[] last = a[a.length - 1];

        double slop = (double)(last[1] - first[1]) / (double)(last[0] - first[0]);

        for(int i =1;i < a.length - 1; i++){
            int[] curr = a[i];
            double cslop = (double)(last[1] - curr[1]) / (double)(last[0] - curr[0]);
            if(slop != cslop)
                return false;
        }

        return true;
    }

    public static void main(String[] args) {

    }
}
