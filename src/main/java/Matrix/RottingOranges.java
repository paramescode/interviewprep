package Matrix;

import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/rotting-oranges/

public class RottingOranges {


    static class Point {
        int row;
        int col;
        int round;

        public Point(int row, int col, int round) {
            this.row = row;
            this.col = col;
            this.round = round;
        }
    }
    public int orangesRotting(int[][] grid) {

        Queue<Point> q = new LinkedList<Point>();

        /**
         * First find all of the rotten oranges and put them into the queue.
         * This is the initial round and does not count towards the minutes.
         */
        int roundCount = 0;
        for (int r=0; r<grid.length; r++) {
            for (int c=0; c<grid[0].length; c++) {
                if (grid[r][c] == 2) {
                    Point p = new Point(r, c, roundCount);
                    q.add(p);
                }
            }
        }

        /**
         * Now go through the Queue.
         * As we go through the queue pop and keep track of the latest count.
         * As we store into the queue, we increment the counter from the last iteration.
         * The final dequeue will yield the minimum number of minutes required.
         */
        int count = 0;
        while (!q.isEmpty()) {
            Point p = q.poll();
            count = p.round;
            System.out.println(count);

            /**
             * The below we check in all 4 directions.
             * Remember that we need to mark the cell with a 1 to a 2 so that we don't keep coming
             * back to it and get stuck in an infinite loop.
             */
            // Check up
            if (p.row > 0 && grid[p.row-1][p.col] == 1 ) {
                q.add(new Point(p.row-1, p.col, p.round+1));
                grid[p.row-1][p.col] = 2;
            }

            // Check left
            if (p.col > 0 && grid[p.row][p.col-1] == 1) {
                q.add(new Point(p.row, p.col-1, p.round+1));
                grid[p.row][p.col-1] = 2;
            }

            // Check right
            if (p.col < grid[0].length-1 && grid[p.row][p.col+1] == 1) {
                q.add(new Point(p.row, p.col+1, p.round+1));
                grid[p.row][p.col+1] = 2;
            }

            // Check down
            if (p.row < grid.length-1 && grid[p.row+1][p.col] == 1) {
                q.add(new Point(p.row+1, p.col, p.round+1));
                grid[p.row+1][p.col] = 2;
            }
        }

        /**
         * This final sweep through the grid is to make sure that all of the oranges are rotten.
         * If there was an orange that couldn't been rotten, then it wasn't possible to make all of these oranges rotten.
         */
        for (int r=0; r<grid.length; r++) {
            for (int c=0; c<grid[0].length; c++) {
                if (grid[r][c] == 1) {
                    return -1;
                }
            }
        }

        return count;
    }


}