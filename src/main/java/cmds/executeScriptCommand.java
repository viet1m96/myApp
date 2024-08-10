package cmds;
import receiver.*;
import num.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class executeScriptCommand implements Command {
    public executeScriptCommand() {}
    private CollectionManager store;
    public void setCollection (CollectionManager store){
        this.store = store;
    }

    @Override
    public void execute(String s) {
        store.executing(Mode.KBOARD, s, new BufferedReader(new InputStreamReader(System.in)));
    }

}
