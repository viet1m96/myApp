package cmds;
import num.Mode;
import receiver.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class showCommand implements Command {
    public showCommand(){}
    private CollectionManager store;
    public void setCollection (CollectionManager store){
        this.store = store;
    }

    @Override
    public void execute(String s) {
        store.showingAll(Mode.KBOARD, s, new BufferedReader(new InputStreamReader(System.in)));
    }
}
