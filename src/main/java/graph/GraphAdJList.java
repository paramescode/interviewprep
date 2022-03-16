package graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.Queue;

public class GraphAdJList {

    public class Vertex{
        int value;
        boolean visited;
        LinkedList<Vertex> edges;

        public Vertex(int value){
            this.value = value;
            boolean visited = false;
            edges = new LinkedList<>();
        }

    }

    private int numberOfVertex;
    private int size;
    private Vertex[] vertices ;
    private Stack<Vertex> stack;

    public GraphAdJList(int numberOfVertex){
        this.numberOfVertex = numberOfVertex;
        this.vertices = new Vertex[this.numberOfVertex];

    }

    private void addVertex(int value){
        Vertex vertex = new Vertex(value);
        this.vertices[value] = vertex;
        size ++;
    }

    public void addVertices(){
        for(int i=0; i < this.numberOfVertex ; i ++){
            addVertex(i);

        }
    }

    public void addEdge(int u, int v){
        this.vertices[u].edges.add(this.vertices[v]);

    }

    public void printVertex(int v){

        System.out.print(this.vertices[v].value + " ");

    }

    public void dfs(int value){

        stack = new Stack<>();
        this.vertices[value].visited = true;
        printVertex(value);
        stack.push(this.vertices[value]);

        while(!stack.isEmpty()){

            Vertex vertex = getEdge(stack.peek());
            if(vertex == null)
                stack.pop();
            else{
                this.vertices[vertex.value].visited = true;
                printVertex(vertex.value);
                stack.push(vertex);

            }

        }

    }

    public void bfs(int value){

        Queue<Vertex> queue = new LinkedList<>();
        this.vertices[value].visited = true;
        printVertex(value);
        queue.add(this.vertices[value]);

        while(! queue.isEmpty()){
            Vertex vertex = queue.remove();

            Vertex adjVertex = getEdge(vertex);

            while(adjVertex != null){
                this.vertices[adjVertex.value].visited = true;
                printVertex(adjVertex.value);
                queue.add(adjVertex);
                adjVertex = getEdge(vertex); // get all the child for the current node, vertex, that is breadth first
            }


        }

    }


    private Vertex getEdge(Vertex peek) {
        if(peek == null || peek.edges.size() ==0)
            return null ;

        Iterator<Vertex> ite = peek.edges.iterator();
        while(ite.hasNext()){
            Vertex nextVertex = ite.next();
            if(!nextVertex.visited)
                return nextVertex;

        }
        return null;

    }

    public void reset(){
        for(Vertex v : this.vertices)
            v.visited = false;
    }

    public boolean isCycleFound(){

        for (Vertex v :this.vertices) {
            if(detectCycle(v.value))
                return true;
        }

        return false;
    }

    private boolean detectCycle(int value) {

        if(this.vertices[value].visited)
            return true;

        this.vertices[value].visited = true;

        Iterator<Vertex> ite = this.vertices[value].edges.iterator();
        while(ite.hasNext()){
            Vertex v = ite.next();
            if(detectCycle(v.value))
                return true;

        }

        //IMP: if no more child mark the visited as false, otherwise node has 2 incoming route will fail.
        this.vertices[value].visited = false;

        return false;

    }

    public static void main(String[] args) {
        GraphAdJList g = new GraphAdJList(6);
        g.addVertices();

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("DFS .........");
        g.dfs(2);

        System.out.println();

        g.reset();

        System.out.println("BFS......");

        g.bfs(2);

        //DAG , directed acyclic Graph. topoLogoicalSort

        System.out.println();

        g.reset();

        System.out.println("Graph has Cycle ..." + g.isCycleFound());

        g = new GraphAdJList(2);

        g.addVertices();

        g.addEdge(0,1);
        g.addEdge(1,0);


        System.out.println("Graph has Cycle ..." + g.isCycleFound());




    }
}
