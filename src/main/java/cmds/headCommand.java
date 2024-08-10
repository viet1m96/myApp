package cmds;
import receiver.*;

public class headCommand implements Command {
    public headCommand(){}
    private CollectionManager store;
    public void setCollection (CollectionManager store){
        this.store = store;
    }

    @Override
    public void execute() {
        store.printingHeadElement();
    }

    @Override
    public void execute(String s) {

    }
}
