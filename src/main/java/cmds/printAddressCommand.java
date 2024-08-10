package cmds;
import num.Mode;
import receiver.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class printAddressCommand implements Command {
    public printAddressCommand(){}
    private CollectionManager store;
    public void setCollection (CollectionManager store){
        this.store = store;
    }

    @Override
    public void execute(String s) {
        store.printingAddress(Mode.KBOARD, s, new BufferedReader(new InputStreamReader(System.in)));
    }
}
