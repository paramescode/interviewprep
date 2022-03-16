package graph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class DirectedAcyclicGraph {

    public class Vertex{

        int value;
        boolean visited;
        List<Vertex> edges;

        public Vertex(int value){
            this.value = value;
            boolean visited = false;
            this.edges = new ArrayList<>();
        }

    }

    private int numberOfVertex ;
    private Vertex[] vertices;

    public DirectedAcyclicGraph(int numberOfVertex){
        this.numberOfVertex = numberOfVertex;
        vertices = new Vertex[numberOfVertex];
    }

    public void addVertices(int value){
        for(int i =0; i < this.numberOfVertex ; i ++){
            addVertex(i);
        }

    }

    private void addVertex(int value){
        Vertex v = new Vertex(value);
        this.vertices[value] = v;
    }

    public void addAVertex(int value){
        addVertex(value);

    }

    public void addEdge(int u, int v){
        this.vertices[u].edges.add(this.vertices[v]);

    }

    public void reset(){
        for(Vertex v : this.vertices)
            v.visited = false;
    }


    private void topoLogicalSortUtil(Stack<Vertex> stack, Vertex vertex){

        vertex.visited = true;

        Iterator<Vertex> ite = vertex.edges.iterator();
        while(ite.hasNext()){
            Vertex adjVertex = ite.next();
            if(!adjVertex.visited)
                topoLogicalSortUtil(stack, adjVertex);

        }

        stack.push(vertex);
    }

    public void topoLogicalSort(){
        Stack<Vertex> stack = new Stack<>();

        for(Vertex v : this.vertices){
            if( ! v.visited)
                topoLogicalSortUtil(stack, v);

        }

        while( !stack.isEmpty()){
            System.out.print(stack.pop().value + " ");
        }

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
        System.out.println("DAG topologocal order sorting .........");

        DirectedAcyclicGraph g = new DirectedAcyclicGraph(6);


        g.addVertices(6);

        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);

        g.topoLogicalSort();

        g.reset();

        System.out.println("Graph has Cycle ..." + g.isCycleFound());

        g = new DirectedAcyclicGraph(2);

        g.addVertices(2);

        g.addEdge(0,1);
        g.addEdge(1,0);


        System.out.println("Graph has Cycle ..." + g.isCycleFound());





    }

}
