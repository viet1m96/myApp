package cmds;
import receiver.*;

public class executeScriptCommand implements Command {
    public executeScriptCommand() {}
    private CollectionManager store;
    public void setCollection (CollectionManager store){
        this.store = store;
    }

    @Override
    public void execute() {

    }

    @Override
    public void execute(String s) {

    }

}
