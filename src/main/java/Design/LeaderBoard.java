package Design;

import java.util.*;
import java.util.HashMap;

public class LeaderBoard {


    class Node{
        int id;
        int score;

        Node(int id, int score){
            this.id = id;
            this.score = score;
        }
    }

    Map<Integer, Node> map ;
    PriorityQueue<Node> pq;


    public LeaderBoard() {
        this.map = new HashMap<>();
        this.pq = new PriorityQueue<>(new Comparator<Node>(){

            public int compare(Node n1, Node n2){
                System.out.println(n1.score + " " + n2.score);
                return n1.score - n2.score;
            }
        });
    }

    public void addScore(int playerId, int score) {
        Node n = map.get(playerId);
        //System.out.println(score);
        if(n == null){
            n = new Node(playerId, score);
            map.put(playerId, n);
            pq.add(n);

        }else{
            pq.remove(n);
            n.score += score;
            pq.add(n);
        }

    }

    public int top(int K) {
        int topScore = 0;

        int index=0;
        int size = pq.size();
        index= size - K;

        Iterator<Node> ite = pq.iterator();
        int i=0;
        while(i < size && ite.hasNext()){
            int score = ite.next().score;
            System.out.println(score);
            if(i >= index)
                topScore += score;

            i++;
        }
        return topScore;
    }

    public void reset(int playerId) {
        Node n = map.remove(playerId);
        pq.remove(n);
        //pq.add(n);

    }
}

/**
 * Your Leaderboard object will be instantiated and called as such:
 * Leaderboard obj = new Leaderboard();
 * obj.addScore(playerId,score);
 * int param_2 = obj.top(K);
 * obj.reset(playerId);
 */