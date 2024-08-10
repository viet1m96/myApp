package iostream;
import cmds.*;

public class Invoker {
    private Command command;

    public Invoker(){}

    public void setCommand(Command command) {
        this.command = command;
    }
    public void callT1() {
        command.execute();
    }
    public void callT2(String s) {command.execute(s);}
}
