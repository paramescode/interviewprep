package Matrix;

public class FindKthElementInNxNMatrix {

    public static int findKthElement(int [][] m, int k){

        int l = m.length;
        int low = m[0][0];
        int high = m[l - 1][l -1];

        while(low <= high){

            int mid = low + (high - low) / 2;

            int count = getLessOrEqualCount(m , mid);

            if(count < k){
                low = mid + 1;

            }else{
                high = mid - 1;
            }
        }

        return low;
    }

    private static int getLessOrEqualCount(int[][] m, int mid) {
        System.out.println("mid" + mid);
        int i=0, j = m.length -1, count =0;

        while(i < m.length && j >=0){
            if(mid >= m[i][j]){
                count += j + 1;
                i++;
            }else
                j--;
        }
        System.out.println(count);
        return count;
    }

    public static void main(String[] args) {
        System.out.println(findKthElement(new int[][] {{1,  5,  9},{10, 11, 13},{12, 13, 15}}, 8));
    }
}
