package Design.dependency;

import java.util.*;

public class DependencyResolver {

    private List<String> installOrder = new ArrayList<>();
    private Map<String, Set<String>> graph;
    private Map<String, Boolean> explicitInstall;
    private boolean print = false;

    public DependencyResolver() {

        graph = new HashMap<>();
        explicitInstall =  new HashMap<>();
    }

    public static void main(String[] args) {
        DependencyResolver dependencyResolver = new DependencyResolver();
     //See SampleIInputTest Class to test this program.
    }

    private Map<String, Set<String>> copy() {
        Map<String, Set<String>> copy = new HashMap<>();
        for (Map.Entry<String, Set<String>> entry : graph.entrySet()) {
            copy.put(entry.getKey(), new HashSet<>(entry.getValue()));
        }

        return copy;
    }

    public void depend(String[] components) {

        Map<String, Set<String>> graphCopy = copy();
        String c1 = components[0];
        for(int i=1; i < components.length;i++){
            addToGraph(graphCopy,c1, components[i]);
            if (isCyclic(graphCopy)){
                System.out.println( components[i] + " depends on " + c1 +", ignoring command");
                return;
            }

        }
        graph = graphCopy;


        //return Arrays.toString(components);
    }

    // A -> B -> C
    // B -> A
    // C -> B
    // A B C

    private void addToGraph(Map<String, Set<String>> graphCopy, String component1, String component2) {
        graphCopy.putIfAbsent(component1, new HashSet<>());
        graphCopy.putIfAbsent(component2, new HashSet<>());
        graphCopy.get(component1).add(component2);

    }

    private boolean isCyclic(Map<String, Set<String>> g) {
        Map<String, Status> status = new HashMap<>();
        for (String each : g.keySet()) {
            status.put(each, Status.NOT_VISITED);
        }

        for (String each : g.keySet()) {
            if (isCyclic(g, each, status)) {
                return true;
            }
        }
        return false;
    }

    enum Status {
        VISITING, VISITED, NOT_VISITED
    }


    private boolean isCyclic(Map<String, Set<String>> g, String each, Map<String, Status> status) {

        if (status.get(each) == Status.VISITED)
            return false;

        if (status.get(each) == Status.VISITING)
            return true;

        status.put(each, Status.VISITING);

        for (String adj : g.get(each)) {
            if (isCyclic(g, adj, status))
                return true;
        }
        status.put(each, Status.VISITED);
        return false;
    }

    /*
    A

     */
    public String install(String component, boolean explicit) {
        if (!graph.containsKey(component)) {
            graph.put(component, new HashSet<>());
            System.out.println("Installing " + component);
            installOrder.add(component);
            explicitInstall.put(component, Boolean.TRUE);
            return component;
        }

        if(installOrder.contains(component) && explicit){
            System.out.println(component +" is already installed");
            return component;
        }

        if (graph.containsKey(component)) {
            Set<String> dependencies = graph.get(component);
            for (String dependency :dependencies) {
                if(!installOrder.contains(dependency))
                    install(dependency, false);

            }

        }

        if(explicit ){
            installOrder.add(component);
            System.out.println("Installing " + component);
            explicitInstall.put(component, Boolean.TRUE);
        }else {
            System.out.println("Installing " + component);
            installOrder.add(component);
            return component;
        }


        return null;
    }

    public void list() {
        installOrder.forEach(e -> System.out.println(e));
    }

    public void remove(String component) {
        if(graph.get(component) == null){
            System.out.println(component+" is not installed");
            return;
        }


        if(canBeRemoved(component)){
            System.out.println("Removing "+ component);
            installOrder.remove(component);
            Set<String> adjs  = graph.remove(component);
            if(adjs == null)
                return;

            for(String adjComp : adjs){
                if (canBeRemoved(adjComp) && !explicitInstall.containsKey(adjComp)){
                    graph.remove(adjComp);
                    installOrder.remove(adjComp);
                    System.out.println("Removing "+ adjComp);
                }

            }
        }else{
            System.out.println(component + " is still needed");
        }


    }

    private boolean canBeRemoved(String component) {

        for(String adj : graph.keySet()){
            if(graph.get(adj).contains(component))
                return false;
        }

        return true;
    }

}
