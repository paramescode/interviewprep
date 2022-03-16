package Design.dependency.manager.impl;


import Design.dependency.Component;
import Design.dependency.manager.ComponentManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ComponentMangerImpl implements ComponentManager {

    public Map<String, Component> getComponentsMap() {
        return componentsMap;
    }

    Map<String, Component> componentsMap;
    DependencyGraph graph = new DependencyGraph();
    List<Component> installOrder = new ArrayList<>();

    public ComponentMangerImpl(){
        componentsMap = new HashMap<>();
    }


    @Override
    public void install(String componentName) {
        if(componentName == null || componentName.length() ==0 )
            return;

        Component component = getOrCreateComponent(componentName);
        if(component.isInstalled()){
            System.out.println(component.getName() + " is already installed");
            return;
        }
        component.setExplicit(true);
        component.setInstalled(true);
        for(Component dep : component.getDependencies()){
           if(!dep.isInstalled()){
               install(dep.getName());
               dep.setExplicit(false);
           }

        }
        installOrder.add(component);

        printOut("Installing ", componentName);
    }

    private void printOut(String s, String componentName) {
        System.out.println(s + componentName);
    }

    private Component getOrCreateComponent(String componentName) {
        Component component = componentsMap.get(componentName);
        if(component == null){
            component = new Component(componentName);
            componentsMap.put(componentName, component);
        }

        return component;

    }

    private boolean isDependencyExists(String componentName){
        Component component = getOrCreateComponent(componentName);
        for(String key : componentsMap.keySet()){
            Component dep = componentsMap.get(key);
            if(dep.getDependencies().contains(component))
                //TODO , what we need to print here
                return true;

        }

        return false;
    }

    @Override
    public void remove(String componentName) {
        if(componentName == null || componentName.length() ==0 )
            return;

        Component component = getOrCreateComponent(componentName);

        if(component == null || !component.isInstalled())
            printOut( componentName, " is not installed");
        else if(component.canBeRemoved(this, true))
            component.remove(this);
        else
            printOut(componentName, " is still needed");

    }

    public void updateInstallOrder(Component component){
        installOrder.remove(component);
    }

    @Override
    public void list() {
        for(Component c : installOrder){
            System.out.println(c.getName());
        }

    }

    /*
    * DEPEND TELNET TCPIP NETCARD
DEPEND TCPIP NETCARD
DEPEND NETCARD TCPIP
    *
    * */
    @Override
    public void addDependencies(String[] components){
        Component parent = getOrCreateComponent(components[1]);

        for(int i = components.length -1; i > 1; i--)
        {
            if(graph.loadDependencies(components[i], components[i-1])){
                System.out.println(components[i] + " depends on "+ components[i-1] +", ignoring command");
                graph.removeEdge(components[i], components[i -1]);
            }else{
                Component child = getOrCreateComponent(components[i]);
                parent.getDependencies().add(0,child);
            }
        }
    }


    public void print(String command, String component){
        StringBuilder sb = new StringBuilder(command);
        sb.append(" ");
        for(Component c : componentsMap.get(component).getDependencies()){
            sb.append(c.getName());
            sb.append(" ");
        }
        System.out.println(sb.toString());
    }


}
