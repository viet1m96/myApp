package cmds;
import receiver.*;

public class saveCommand implements Command {
    public saveCommand(){}
    private CollectionManager store;
    public void setCollection (CollectionManager store){
        this.store = store;
    }

    @Override
    public void execute() {
        store.saveIntoCSV();
    }

    @Override
    public void execute(String s) {

    }
}
