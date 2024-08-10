package cmds;
import receiver.*;
import num.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class headCommand implements Command {
    public headCommand(){}
    private CollectionManager store;
    public void setCollection (CollectionManager store){
        this.store = store;
    }

    @Override
    public void execute(String s) {
        store.printingHeadElement(Mode.KBOARD, s, new BufferedReader(new InputStreamReader(System.in)));
    }
}
