package Design.dependency.manager.impl;

import java.util.ArrayList;
import java.util.HashMap;

public class DependencyGraph {

    public DependencyGraph(){
        vertices = new ArrayList<>();
        vertexLookup = new HashMap<>();
    }

    public ArrayList<Vertex> vertices;
    HashMap<String, Vertex> vertexLookup;

    public class Vertex{
        String name;
        ArrayList<Vertex> dependencies;

        private Vertex(String name){
            this.name = name;
            this.dependencies = new ArrayList<Vertex>();
        }

    }

    public Vertex getVertex(String libName){
        Vertex v = this.vertexLookup.get(libName);
        if(v == null){
            v = new Vertex(libName);
            this.vertexLookup.put(libName, v);
            this.vertices.add(v);
        }
        return v;
    }

    public void removeEdge(String p, String c){
        Vertex parent = this.vertexLookup.get(p);
        Vertex child = this.vertexLookup.get(c);
        if(p != null && parent.dependencies.size() >0 && c != null){
            parent.dependencies.remove(child);
        }
    }

    enum State{
        LOADED, LOADING, NOT_LOADED
    }



    public boolean loadDependencies(String parentName, String childName){

        Vertex parent = this.getVertex(parentName);
        //for(int i=2;i < args.length ;i++){
            Vertex child = this.getVertex(childName);
            if(!parent.dependencies.contains(child))
                parent.dependencies.add(child);
        //}

        //construct the list for return
        ArrayList<String> results = new ArrayList<String>(this.vertices.size());
        HashMap<String, State> loadState = new HashMap<String, State>();

        for(int i = 0; i < this.vertices.size(); i++){
            if(tryLoad(this.vertices.get(i), results, loadState )){
                return true;
            }
        }


        return false;
    }

    private boolean tryLoad(Vertex v, ArrayList<String> results, HashMap<String, State> loadState) {
        State state = loadState.get(v.name);
        if(state == State.LOADING){
            return true;
        }
        if(state == State.LOADED){
            return false;
        }
        loadState.put(v.name, State.LOADING);

        for(Vertex child : v.dependencies){
            if(tryLoad(child, results, loadState))
                return true;
        }
        results.add(v.name);
        loadState.put(v.name, State.LOADED);

        return false;
    }


}
