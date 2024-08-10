package cmds;
import receiver.*;

public class exitCommand implements Command {
    public exitCommand(){}
    private CollectionManager store;
    public void setCollection (CollectionManager store){
        this.store = store;
    }

    @Override
    public void execute() {
        System.exit(0);// còn thiếu đóng file các kiểu con đà điểu nữa
    }

    @Override
    public void execute(String s) {

    }
}
