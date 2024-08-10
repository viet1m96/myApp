package cmds;
import receiver.*;

public class removeLowerCommand implements Command {
    public removeLowerCommand(){}
    private CollectionManager store;
    public void setCollection (CollectionManager store){
        this.store = store;
    }

    @Override
    public void execute() {
        store.removeLower();
    }

    @Override
    public void execute(String s) {

    }
}
