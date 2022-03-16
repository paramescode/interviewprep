package graph;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class FindCheapestFlightsWithKStops {

    //https://leetcode.com/problems/cheapest-flights-within-k-stops/

    /**
     * There are n cities connected by m flights. Each fight starts from city u and arrives at v with a price w.

     Now given all the cities and flights, together with starting city src and the destination dst, your task is to find the cheapest price from src to dst with up to k stops. If there is no such route, output -1.

     Example 1:
     Input:
     n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
     src = 0, dst = 2, k = 1
     Output: 200
     Explanation:
     The graph looks like this:


     The cheapest price from city 0 to city 2 with at most 1 stop costs 200, as marked red in the picture.

     Example 2:
     Input:
     n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
     src = 0, dst = 2, k = 0
     Output: 500
     Explanation:
     The graph looks like this:


     The cheapest price from city 0 to city 2 with at most 0 stop costs 500, as marked blue in the picture.
     *
     *
     * **/

    static class Node {

        int city;
        int price;
        int stops;
        Node(int city, int price){
            this.city = city;
            this.price = price;
        }

        Node(int city, int price, int stops){
            this.city = city;
            this.price = price;
            this.stops = stops;
        }
    }

    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        if(n <=0 || flights == null || flights.length ==0 || K < 0 || src == dst)
            return -1;

        Queue<Node> queue = new LinkedList<>();

        Node srcNode = new Node(src, 0);
        queue.add(srcNode);

        int sum = Integer.MAX_VALUE;
        int stops =0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0; i < size ; i++){
                Node node = queue.poll();
                int currCity = node.city;
                int price = node.price;
                if(currCity == dst){
                    //System.out.println(currCity +" " + dst + " " + price + " " + sum);
                    sum = Math.min(price, sum);
                }
                for(int j =0; j < flights.length ; j++){
                    int[] flight = flights[j];
                    if(price + flight[2] > sum)
                        continue;

                    if(flight[0] == currCity){
                        Node next = new Node(flight[1], price+flight[2]);
                        queue.add(next);
                    }
                }
            }

            if(stops > K) break;
            stops++;

        }

        return sum == Integer.MAX_VALUE ? -1: sum;
    }

    //Dijikstra algorithm using PQ
    public static int findCheapestPricePQ(int n, int[][] flights, int src, int dst, int K) {
        if(n <=0 || flights == null || flights.length ==0 || K < 0 || src == dst)
            return -1;

        Queue<Node> queue = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.price - o2.price;
            }
        });

        Node srcNode = new Node(src, 0, 0);
        queue.add(srcNode);

        int sum = Integer.MAX_VALUE;
        while(!queue.isEmpty()){

                Node node = queue.poll();
                int currCity = node.city;
                int price = node.price;
                int stops = node.stops;
                if(currCity == dst){
                    //System.out.println(currCity +" " + dst + " " + price + " " + sum);
                    sum = Math.min(price, sum);
                }
                if(stops <= K){
                    for(int j =0; j < flights.length ; j++){
                        int[] flight = flights[j];
                        if(price + flight[2] > sum)
                            continue;

                        if(flight[0] == currCity){
                            Node next = new Node(flight[1], price+flight[2], stops+1);
                            queue.add(next);
                        }
                    }
                }

        }

        return sum == Integer.MAX_VALUE ? -1: sum;
    }



    public static void main(String[] args) {
        int[][] in = new int[][]{{0,1,100},{1,2,100},{0,2,500}};

        System.out.println(findCheapestPrice(3, in, 0,2, 0));

        System.out.println(findCheapestPricePQ(3, in, 0,2, 0));
    }
}
