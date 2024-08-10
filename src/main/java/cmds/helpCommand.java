package cmds;
import receiver.*;

public class helpCommand implements Command {
    public helpCommand(){}
    private CollectionManager store;
    public void setCollection (CollectionManager store){
        this.store = store;
    }

    @Override
    public void execute() {
        System.out.println("help : display help on available commands\n" +
                "info : display information about the collection (type, initialization date, number of elements, etc.) to standard output\n" +
                "show : display all elements of the collection as strings to standard output\n" +
                "add {element} : add a new element to the collection\n" +
                "update id {element} : update the value of the collection element whose id is equal to the specified one\n" +
                "remove_by_id id : remove an element from the collection by its id\n" +
                "clear : clear the collection\n" +
                "save : save the collection to a file\n" +
                "execute_script file_name : read and execute a script from the specified file. The script contains commands in the same form in which the user enters them interactively.\n" +
                "exit : exit the program (without saving to file)\n" +
                "head : print the first element of the collection\n" +
                "add_if_max {element} : add a new element to the collection if its value is greater than the value of the largest element of this collection\n" +
                "remove_lower {element} : remove all elements from the collection that are smaller than the specified\n" +
                "min_by_creation_date : print any object from the collection whose creationDate field value is the minimum\n" +
                "filter_starts_with_full_name fullName : print elements whose fullName field value starts with the specified substring\n" +
                "print_unique_postal_address : print the unique values \u200B\u200Bof the postalAddress field of all elements in the collection");

    }

    @Override
    public void execute(String s) {

    }
}
