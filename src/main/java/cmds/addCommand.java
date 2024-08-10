package cmds;

import receiver.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collection;
import num.*;

public class addCommand implements Command {
    public addCommand(){}
    private CollectionManager store;
    public void setCollection (CollectionManager store){
        this.store = store;
    }

    @Override
    public void execute(String s) {
        store.adding(Mode.KBOARD, s, new BufferedReader(new InputStreamReader(System.in)));
    }
}
