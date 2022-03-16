package Design.dependency;


import Design.dependency.manager.ComponentManager;

import java.util.ArrayList;
import java.util.List;

public class Component{

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDependencies(List<Component> dependencies) {
        this.dependencies = dependencies;
    }

    private String name;
    private List<Component> dependencies;
    private boolean isInstalled = false;
    private boolean isExplicit = false;

    public boolean isInstalled() {
        return isInstalled;
    }

    public void setInstalled(boolean isInstalled) {
        this.isInstalled = isInstalled;
    }

    public boolean isExplicit() {
        return isExplicit;
    }

    public void setExplicit(boolean explicit) {
        isExplicit = explicit;
    }



    public Component(String name){
        this.name = name;
        dependencies = new ArrayList<>();

    }

    public void addDependencyComponent(Component component){
        this.dependencies.add(component);
    }

    public List<Component> getDependencies(){
        return this.dependencies;
    }


    public boolean canBeRemoved(ComponentManager componentManager, boolean isExplicit) {
        if(!isExplicit && this.isExplicit ){
            return false;
        }

        for(Component dep :componentManager.getComponentsMap().values() ){
            if(dep.isInstalled && dep.hasDependency(this))
                return false;
        }

        return true;
    }

    private boolean hasDependency(Component component) {

        for(Component c : this.dependencies){
            if(c == component ||c.hasDependency(component))
                return true;
        }

        return false;

    }

    public void remove(ComponentManager componentManager){

        System.out.println("Removing " + this.getName());
        this.isInstalled = false;
        this.isExplicit  = false;
        componentManager.updateInstallOrder(this);

        for(Component dep : this.dependencies){
            if(dep.canBeRemoved(componentManager, false)){
                dep.remove(componentManager);
            }else{
                return;
            }


        }


    }

    public void addDependency(Component dComp) {
        if(dComp.getDependencies() != null && !dComp.hasDependency(this)){
            this.dependencies.add(dComp);
        }
    }
}
