package iostream;
import cmds.*;
import num.Mode;

public class Invoker {
    private Command command;

    public Invoker(){}

    public void setCommand(Command command) {
        this.command = command;
    }
    public void call(String s) {command.execute(s);}
}
