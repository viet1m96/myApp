package cmds;
import receiver.*;

public class addMaxCommand implements Command {
    public addMaxCommand(){}
    private CollectionManager store;
    public void setCollection (CollectionManager store){
        this.store = store;
    }

    @Override
    public void execute() {
        store.addIfMax();
    }
    @Override
    public void execute(String s) {

    }

}
