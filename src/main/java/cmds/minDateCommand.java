package cmds;
import num.Mode;
import receiver.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class minDateCommand implements Command {
    public minDateCommand(){}
    private CollectionManager store;
    public void setCollection (CollectionManager store){
        this.store = store;
    }

    @Override
    public void execute(String s) {
        store.printingHeadElement(Mode.KBOARD, s, new BufferedReader(new InputStreamReader(System.in)));
    }
}
