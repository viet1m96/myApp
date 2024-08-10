package cmds;
import receiver.*;

public class showCommand implements Command {
    public showCommand(){}
    private CollectionManager store;
    public void setCollection (CollectionManager store){
        this.store = store;
    }

    @Override
    public void execute() {
        store.showAll();
    }

    @Override
    public void execute(String s) {

    }
}
