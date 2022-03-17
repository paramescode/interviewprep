package Design.dependency.CommandExecutor.impl;

import Design.dependency.CommandExecutor.CommandProcessor;
import Design.dependency.manager.ComponentManager;
import Design.dependency.manager.impl.ComponentMangerImpl;


public class CommandProcessorImpl implements CommandProcessor {

    ComponentManager componentManager = null;

    public CommandProcessorImpl(){
        this.componentManager = new ComponentMangerImpl();
        this.dependencyResolver = new DependencyResolver()
    }

    DependencyResolver dependencyResolver = null;

    @Override
    public void process(String cmd) {

            System.out.println(cmd);

            String[] parts = cmd.split("\\s+");
            if(parts.length <= 0)
            {
                return;
            }
            String command = parts[0].toUpperCase();

            if(command.equals("DEPEND"))
            {
                //componentManager.addDependencies(parts);
                String[] in = new String[parts.length -1];
                for(int i=0; i < parts.length -1 ; i++){
                    in[i] = parts[i+1];
                }

                dependencyResolver.depend(in);
            }
            else if(command.equals("INSTALL"))
            {
                //componentManager.install(parts[1]);
                dependencyResolver.install(parts[1], true);
            }
            else if(command.equals("REMOVE"))
            {
                //componentManager.remove(parts[1]);
                dependencyResolver.remove(parts[1]);
            }
            else if(command.equals("LIST"))
            {
                //componentManager.list();
                dependencyResolver.list();
            }


    }
}
