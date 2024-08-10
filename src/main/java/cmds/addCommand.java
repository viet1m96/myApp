package cmds;

import receiver.*;

import java.util.Collection;

public class addCommand implements Command {
    public addCommand(){}
    private CollectionManager store;
    public void setCollection (CollectionManager store){
        this.store = store;
    }

    @Override
    public void execute() {
        store.addFromKeyboard();
    }

    @Override
    public void execute(String s) {

    }
}
