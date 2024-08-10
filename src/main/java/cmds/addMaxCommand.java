package cmds;
import receiver.*;
import num.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class addMaxCommand implements Command {
    public addMaxCommand(){}
    private CollectionManager store;
    public void setCollection (CollectionManager store){
        this.store = store;
    }

    @Override
    public void execute(String s) {
        store.addingIfMax(Mode.KBOARD, s, new BufferedReader(new InputStreamReader(System.in)));
    }

}
