package iostream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import faults.*;
import java.util.*;
import cmds.*;
import receiver.*;

public class Handle  {
    public  BufferedReader br;
    private  Map<String, Command> commandT1;
    private  Map<String, Command> commandT2;
    private Invoker caller;
    private CollectionManager store;
    Handle(String fileName) {
        System.out.println("Hello! Welcome to my Application!");
        System.out.println("Please type 'help' to read the instruction or type 'exit' to shut down the program.");
        br = new BufferedReader(new InputStreamReader(System.in));
        commandT1 = new HashMap<>();
        commandT2 = new HashMap<>();
        caller = new Invoker();
        store = new CollectionManager(fileName);
    }
    void init() {
        commandT1.put("add", new addCommand());
        commandT1.put("add_if_max", new addMaxCommand());
        commandT1.put("clear", new clearCommand());
        commandT1.put("exit", new exitCommand());
        commandT1.put("head", new headCommand());
        commandT1.put("help", new helpCommand());
        commandT1.put("info", new infoCommand());
        commandT1.put("min_by_creation_date", new minDateCommand());
        commandT1.put("print_unique_postal_address", new printAddressCommand());
        commandT1.put("remove_lower", new removeLowerCommand());
        commandT1.put("save", new saveCommand());
        commandT1.put("show", new showCommand());

        commandT2.put("update", new update_idCommand());
        commandT2.put("remove_by_id", new remove_by_idCommand());
        commandT2.put("execute_script", new executeScriptCommand());
        commandT2.put("filter_starts_with_full_name", new filterCommand());
    }

    void running() throws IOException {
        store.loadingData();
        while(true) {
            try {
                String s = br.readLine();
                boolean exist = false;
                if(commandT1.containsKey(s)) {
                    exist = true;
                    handleCommandT1(s);
                } else {
                    for(String key : commandT2.keySet()) {
                        if(s.contains(key)) {
                            exist = true;
                            handleCommandT2(key, s);
                            break;
                        }
                    }
                }
                if(!exist) throw new CannotRecognizedInput();
            } catch(IOException e) {
                System.out.println(e.toString());
            } catch(CannotRecognizedInput e) {
                System.out.println(e.toString());
            }
        }
    }

    void handleCommandT1(String s) {
        Command command = commandT1.get(s);
        command.setCollection(store);
        caller.setCommand(command);
        caller.callT1();
    }

    void handleCommandT2(String nameOfCommand, String needExecuting) {
        Command command = commandT2.get(nameOfCommand);
        needExecuting = needExecuting.replace(nameOfCommand, "");
        needExecuting = needExecuting.replaceAll("\\s", "");
        command.setCollection(store);
        caller.setCommand(command);
        caller.callT2(needExecuting);
    }

}
