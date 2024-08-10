package cmds;
import receiver.*;
public class printAddressCommand implements Command {
    public printAddressCommand(){}
    private CollectionManager store;
    public void setCollection (CollectionManager store){
        this.store = store;
    }

    @Override
    public void execute() {
        store.printAll();
    }

    @Override
    public void execute(String s) {

    }
}
