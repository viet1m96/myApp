package receiver;

import java.io.*;
import java.util.*;

import faults.DataNotCorrect;
import file_processing.*;
import num.Mode;

import java.lang.reflect.*;
import java.time.LocalDateTime;

public class CollectionManager {
    private Queue<Organization> collection;
    private LocalDateTime firstMoment;
    private readFile reader;
    private writeFile writer;
    private OrganizationBuild builder;
    private Map<String, String> cmd;

    public CollectionManager(String fileName) {
        collection = new ArrayDeque<>();
        firstMoment = LocalDateTime.now();
        reader = new readFile(fileName);
        writer = new writeFile(fileName);
        builder = new OrganizationBuild();
    }

    public void loadingData() {
        Queue<String[]> data = reader.getDataFromFile();
        while (!data.isEmpty()) {
            Organization org = new Organization();
            org.setOrganization(data.poll());
            collection.add(org);
        }
    }

    public void init() {
        cmd = new HashMap<>();
        cmd.put("add", "adding");
        cmd.put("add_if_max", "addingIfMax");
        cmd.put("clear", "clearing");
        cmd.put("execute_script", "executing");
        cmd.put("exit", "exiting");
        cmd.put("filter_starts_with_full_name", "filtering");
        cmd.put("head", "printingHeadElement");
        cmd.put("info", "informationOfDS");
        cmd.put("min_by_creation_date", "printingHeadElement");
        cmd.put("print_unique_postal_address", "printingAddress");
        cmd.put("remove_by_id", "removingByID");
        cmd.put("remove_lower", "removingLower");
        cmd.put("save", "savingIntoCSV");
        cmd.put("show", "showingAll");
        cmd.put("update", "updatingById");
    }

    public void adding(Mode a, String s, BufferedReader br) {
        try {
            String[] element = builder.buildFromKeyboard(a, br);
            for (String str : element) {
                if (str.isEmpty()) throw new DataNotCorrect();
            }
            Organization org = new Organization();
            org.setOrganization(element);
            collection.add(org);
            System.out.println("Add command was executed successfully");
        } catch (DataNotCorrect e) {
            System.out.println(e.Error());
        }

    }

    public void helping(Mode a, String s, BufferedReader br) {
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

    public void exiting(Mode a, String s, BufferedReader br) {
        writer.shutDown();
        System.exit(0);
    }

    public void clearing(Mode a, String s, BufferedReader br) {
        collection.clear();
        System.out.println("Clear command was executed successfully");
    }

    public void informationOfDS(Mode a, String s, BufferedReader br) {
        System.out.println("Type of DS: Queue");
        System.out.println("Moment of Initialization: " + firstMoment.toString());
        System.out.println("Current number of elements: " + collection.size());
        System.out.println("Info command was executed successfully");
    }

    public void printingHeadElement(Mode a, String s, BufferedReader br) {
        if (collection.isEmpty()) {
            System.out.println("Nothing to print");
        } else {
            Organization org = collection.peek();
            org.printEverythingOfAnElement();
        }
        System.out.println("Head command was executed successfully");
    }

    public void showingAll(Mode a, String s, BufferedReader br) {
        for (Organization org : collection) {
            org.printEverythingOfAnElement();
        }
        System.out.println("Show command was executed successfully");
    }

    public void printingAddress(Mode a, String s, BufferedReader br) {
        for (Organization org : collection) {
            System.out.println(org.getFullName() + " " + org.getAddress());
        }
        System.out.println("Print_unique_postal_address command was executed successfully");
    }

    public void savingIntoCSV(Mode a, String s, BufferedReader br) {
        for (Organization org : collection) {
            writer.writeToCSV(org.packagingToString());

        }
        System.out.println("save command was executed successfully.");
    }

    public void addingIfMax(Mode a, String s, BufferedReader br) {
        try {
            String[] element = builder.buildFromKeyboard(a, br);
            for (String str : element) {
                if (str.isEmpty()) throw new DataNotCorrect();
            }
            Float mx = 0.0F;
            for (Organization org : collection) {
                mx = Math.max(mx, org.getAnnualTurnover());
            }
            if (Float.compare(Float.parseFloat(element[5]), mx) > 0) {
                Organization org = new Organization();
                org.setOrganization(element);
                collection.add(org);
                System.out.println("The element was added to the collection.");
            } else {
                System.out.println("The element was not added to the collection.");
            }
            System.out.println("add_if_max command was executed successfully");
        } catch (DataNotCorrect e) {
            System.out.println(e.Error());
        }
    }

    public void removingLower(Mode a, String s, BufferedReader br) {
        try {
            String[] element = builder.buildFromKeyboard(a, br);
            for (String str : element) {
                if (str.isEmpty()) throw new DataNotCorrect();
            }
            collection.removeIf(org -> Float.compare(Float.parseFloat(element[5]), org.getAnnualTurnover()) > 0);
        } catch (DataNotCorrect e) {
            System.out.println(e.Error());
        }
    }


    public void removingByID(Mode a, String s, BufferedReader br) {
        String needExecuting = builder.checker.gettingString(a, s, br);
        if (builder.checkID(needExecuting)) {
            builder.removeID(needExecuting);
            collection.removeIf(org -> String.valueOf(org.getId()).equals(needExecuting));
        } else {
            System.out.println("The ID does not exist in the collection.");
        }
        System.out.println("remove_by_id command was executed successfully");
    } // type 2

    public void updatingById(Mode a, String s, BufferedReader br) {
        String needExecuting = builder.checker.gettingString(a, s, br);
        if (builder.checkID(needExecuting)) {
            try {
                String[] element = builder.buildFromKeyboard(a, br);
                for (String str : element) {
                    if (str.isEmpty()) throw new DataNotCorrect();
                }
                for (Organization org : collection) {
                    if (String.valueOf(org.getId()).equals(needExecuting)) {
                        element[0] = needExecuting;
                        org.setOrganization(element);
                        break;
                    }
                }
            } catch (DataNotCorrect e) {
                System.out.println(e.Error());
            }
        } else {
            System.out.println("The ID does not exist in the collection.");
        }
        System.out.println("update command was executed successfully");

    } // type 2

    public void filtering(Mode a, String s, BufferedReader br) {
        String head = builder.checker.gettingString(a, s, br);
        for (Organization org : collection) {
            String full = org.getFullName();
            if (full.contains(head)) {
                org.printEverythingOfAnElement();
            }
        }
        System.out.println("Filter_starts_with_full_name executed successfully");
    } // type 2

    public void executing(Mode a, String s, BufferedReader br) {
        String fileName = builder.checker.gettingString(a, s, br);
        try {
            BufferedReader exeFile = new BufferedReader(new FileReader(fileName));
            Class[] set = new Class[]{Mode.class, String.class, BufferedReader.class};
            String line = "";
            while ((line = exeFile.readLine()) != null) {
                if (cmd.containsKey(line)) {
                    Method method = this.getClass().getDeclaredMethod(cmd.get(line), set);
                    method.invoke(this, Mode.FILE, s, exeFile);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        } catch (IOException e) {
            System.out.println("Error reading file.");
        } catch (NoSuchMethodException e) {
            System.out.println("Method not found.");
        } catch (InvocationTargetException e) {
            System.out.println("Invocation target exception.");
        } catch (IllegalAccessException e) {
            System.out.println("Illegal access.");
        }
    } // type 2


}
