package Design.dependency.manager;


import Design.dependency.Component;

import java.util.Map;

public interface ComponentManager {

    public void install(String component);

    public void remove(String component);

    public void list();

    public void addDependencies(String[] parts);

    public void print(String out1, String out2);

    public Map<String, Component> getComponentsMap();

    public void updateInstallOrder(Component component);

}
