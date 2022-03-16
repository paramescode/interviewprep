package Matrix;

import java.util.ArrayList;
import java.util.List;


//https://leetcode.com/problems/queens-that-can-attack-the-king/
public class QueenAttackKing {

    public static List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        List<List<Integer>> res  =new ArrayList<>();
        int[] xDir = new int[]{0,1,1,1,0,-1,-1,-1};
        int[] yDir = new int[]{1,1,0,-1,-1,-1,0,1};

        int board[][] = new int[8][8];
        for(int[] queen : queens ){
            int x= queen[0], y = queen[1];
            board[x][y] = 1;
        }

        // 3 elements in board, 1 = queen, 2 = king, and 0 = empty

        board[king[0]][king[1]] = 2;

        for(int i=0; i < 8; i++){
            int kx = king[0];
            int ky = king[1];
            while(true){
                kx += xDir[i];
                ky += yDir[i];
                if(kx > 7 || kx < 0 || ky < 0 || ky > 7 || board[kx][ky] == 2)
                    break;

                if(board[kx][ky] == 1){
                    List<Integer> t = new ArrayList<>();
                    t.add(kx);
                    t.add(ky);
                    res.add(t);
                    break;
                }
            }
        }

        return res;

    }

    public static void main(String[] args) {
        List<List<Integer>> res = queensAttacktheKing(new int[][]{{0,1},{1,0},{4,0},{0,4},{3,3},{2,4}}, new int[]{0,0});
        for(List<Integer> l : res){
            for(Integer i: l){
                System.out.print(i+ " ");
            }
            System.out.println();
        }
    }
}
