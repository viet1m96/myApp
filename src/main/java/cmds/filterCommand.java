package cmds;
import receiver.*;

public class filterCommand implements Command {
    public filterCommand(){}
    private CollectionManager store;
    public void setCollection (CollectionManager store){
        this.store = store;
    }

    @Override
    public void execute() {

    }

    @Override
    public void execute(String s) {
        store.filter(s);
    }
}
