package cmds;
import num.Mode;
import receiver.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class update_idCommand implements Command {
    public update_idCommand(){}
    private CollectionManager store;
    public void setCollection (CollectionManager store){
        this.store = store;
    }

    @Override
    public void execute(String s) {
        store.updatingById(Mode.KBOARD, s, new BufferedReader(new InputStreamReader(System.in)));
    }
}
