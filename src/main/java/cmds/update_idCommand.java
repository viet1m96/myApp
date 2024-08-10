package cmds;
import receiver.*;

public class update_idCommand implements Command {
    public update_idCommand(){}
    private CollectionManager store;
    public void setCollection (CollectionManager store){
        this.store = store;
    }

    @Override
    public void execute() {

    }

    @Override
    public void execute(String s) {
        store.updateById(s);
    }
}
