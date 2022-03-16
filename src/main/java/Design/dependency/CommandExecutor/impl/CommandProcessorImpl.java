package Design.dependency.CommandExecutor.impl;

import Design.dependency.CommandExecutor.CommandProcessor;
import Design.dependency.manager.ComponentManager;
import Design.dependency.manager.impl.ComponentMangerImpl;


public class CommandProcessorImpl implements CommandProcessor {

    ComponentManager componentManager = null;

    public CommandProcessorImpl(){
        this.componentManager = new ComponentMangerImpl();
    }

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
                componentManager.addDependencies(parts);
            }
            else if(command.equals("INSTALL"))
            {
                componentManager.install(parts[1]);
            }
            else if(command.equals("REMOVE"))
            {
                componentManager.remove(parts[1]);
            }
            else if(command.equals("LIST"))
            {
                componentManager.list();
            }


    }
}
