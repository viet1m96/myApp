package cmds;
import receiver.*;

public class remove_by_idCommand implements Command {
    public remove_by_idCommand() {}
    private CollectionManager store;
    public void setCollection (CollectionManager store){
        this.store = store;
    }

    @Override
    public void execute() {

    }

    @Override
    public void execute(String s) {
        store.removeByID(s);
    }
}
