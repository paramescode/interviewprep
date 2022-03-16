package graph;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;


public class GraphDfsBfs {

     class Vertex {
         char label;
         boolean visited ;

          Vertex(char label, boolean visited){
             this.label = label;
             this.visited = visited;
         }
    }
     private final int MAX_VERTEX = 20;
     private  Vertex vertexArray [] ;
     private int edges [] [];
     private int numberofVertex;
     private Stack<Integer> stack;
     private Queue<Integer> queue;


    public GraphDfsBfs(){
        vertexArray = new Vertex[MAX_VERTEX];
        edges = new int [MAX_VERTEX][MAX_VERTEX];
        numberofVertex = 0;
        stack = new Stack<Integer>();
        queue = new LinkedList<Integer>();
    }


    public void addVertex(char label){

        Vertex vertex = new Vertex(label, false);
        vertexArray[numberofVertex ++] = vertex;
    }

    public void addEdge(int start , int end){

        edges[start] [end] = 1;
        edges[end] [start] = 1;
    }

    public void printVertex(int v){
        System.out.print(vertexArray[v].label + " ");
    }

    private int getAdjUnvisitedVertex(int peek) {

        for(int j =0; j < numberofVertex; j ++){
            if( edges[peek][j] == 1 && vertexArray[j].visited == false){
                return j;
            }
        }
        return  -1;
    }

    public void dfs(){
        vertexArray[0].visited = true;
        printVertex(0);
        stack.push(0);

        while(!stack.isEmpty()){
            int v = getAdjUnvisitedVertex(stack.peek());

            if(v == -1){
                stack.pop();
            }else{
                vertexArray[v].visited = true;
                printVertex(v);
                stack.push(v);
            }
        }
    }

    public void bfs(){
        vertexArray[0].visited = true;
        printVertex(0);
        queue.add(0);

        while(!queue.isEmpty()){

            int v1 = queue.remove();
            int v2 = getAdjUnvisitedVertex(v1);
            while(v2 != -1){
                vertexArray[v2].visited =true;
                printVertex(v2);
                queue.add(v2);
                v2 = getAdjUnvisitedVertex(v1);

            }

        }

    }

    public static void main(String[] args) {

        GraphDfsBfs graphDfsBfs = new GraphDfsBfs();
        graphDfsBfs.addVertex('A');
        graphDfsBfs.addVertex('B');
        graphDfsBfs.addVertex('C');
        graphDfsBfs.addVertex('D');
        graphDfsBfs.addVertex('E');
        graphDfsBfs.addVertex('F');

        graphDfsBfs.addEdge(0,1);
        graphDfsBfs.addEdge(1,2);
        graphDfsBfs.addEdge(0,3);
        graphDfsBfs.addEdge(3,4);
        graphDfsBfs.addEdge(4,5);
        graphDfsBfs.addEdge(1,4);

        System.out.println("BFS Visits: ");
        graphDfsBfs.bfs();
        System.out.println();

        //reset the visited to run DFS
        for (Vertex v: graphDfsBfs.vertexArray) {
             if(v != null )
                 v.visited = false ;

        }
        System.out.println("DFS Visits: ");
        graphDfsBfs.dfs();
        System.out.println();



    }











}
