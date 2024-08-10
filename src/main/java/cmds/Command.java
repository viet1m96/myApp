package cmds;
import receiver.*;
import num.*;

public interface Command {
    void setCollection(CollectionManager store);
    void execute(String str);
}
