package cmds;
import receiver.*;

public class clearCommand implements Command{
    public clearCommand(){}
    private CollectionManager store;
    public void setCollection (CollectionManager store){
        this.store = store;
    }

    @Override
    public void execute() {
        store.clearing();
    }
    @Override
    public void execute(String s) {

    }
}
