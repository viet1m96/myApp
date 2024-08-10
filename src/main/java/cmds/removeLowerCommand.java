package cmds;
import num.Mode;
import receiver.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class removeLowerCommand implements Command {
    public removeLowerCommand(){}
    private CollectionManager store;
    public void setCollection (CollectionManager store){
        this.store = store;
    }

    @Override
    public void execute(String s) {
        store.removingLower(Mode.KBOARD, s, new BufferedReader(new InputStreamReader(System.in)));
    }
}
