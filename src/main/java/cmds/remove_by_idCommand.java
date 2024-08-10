package cmds;
import num.Mode;
import receiver.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class remove_by_idCommand implements Command {
    public remove_by_idCommand() {}
    private CollectionManager store;
    public void setCollection (CollectionManager store){
        this.store = store;
    }

    @Override
    public void execute(String s) {
        store.removingByID(Mode.KBOARD, s, new BufferedReader(new InputStreamReader(System.in)));
    }
}
