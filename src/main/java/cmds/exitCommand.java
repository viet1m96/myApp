package cmds;
import receiver.*;
import num.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class exitCommand implements Command {
    public exitCommand(){}
    private CollectionManager store;
    public void setCollection (CollectionManager store){
        this.store = store;
    }

    @Override
    public void execute(String s) {
        store.exiting(Mode.KBOARD, s, new BufferedReader(new InputStreamReader(System.in)));
    }
}
