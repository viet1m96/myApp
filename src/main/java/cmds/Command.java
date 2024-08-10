package cmds;
import receiver.*;

public interface Command {
    void setCollection(CollectionManager store);
    void execute();
    void execute(String s);
}
