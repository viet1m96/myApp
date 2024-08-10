package cmds;
import receiver.*;

public class infoCommand implements Command {
    public infoCommand(){}
    private CollectionManager store;
    public void setCollection (CollectionManager store){
        this.store = store;
    }

    @Override
    public void execute() {
        store.informationOfDS();
    }

    @Override
    public void execute(String s) {

    }
}
