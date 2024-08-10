package receiver;
import cmds.*;

import java.io.*;
import java.util.*;

import faults.IdNotInTheSet;
import faults.InputNotANumber;
import file_processing.*;
import java.time.LocalDateTime;

public class CollectionManager {
    private Queue<Organization> collection;
    private LocalDateTime firstMoment;
    private readFile reader;
    private writeFile writer;
    private OrganizationBuild builder;

    public CollectionManager(String fileName){
        collection = new ArrayDeque<>();
        firstMoment = LocalDateTime.now();
        reader = new readFile(fileName);
        writer = new writeFile(fileName);
        builder = new OrganizationBuild();
    }

    public void loadingData() {
        Queue<String[]> data = reader.getDataFromFile();
        while(!data.isEmpty()) {
            Organization org = new Organization();
            org.setOrganization(data.poll());
            collection.add(org);
        }
    }

    public void addFromKeyboard() {
        String[] element = builder.buildFromKeyboard();
        Organization org = new Organization();
        org.setOrganization(element);
        collection.add(org);
        System.out.println("Add command was executed successfully");
    }

    public void addFromFile() {

    }

    public void clearing() {
        collection.clear();
        System.out.println("Clear command was executed successfully");
    }

    public void informationOfDS() {
        System.out.println("Type of DS: Queue");
        System.out.println("Moment of Initialization: " + firstMoment.toString());
        System.out.println("Current number of elements: " + collection.size());
        System.out.println("Info command was executed successfully");
    }

    public void printingHeadElement() {
        if(collection.isEmpty()) {
            System.out.println("Nothing to print");
        } else {
            Organization org = collection.peek();
            org.printEverythingOfAnElement();
        }
        System.out.println("Head command was executed successfully");
    }

    public void showAll() {
        for(Organization org : collection) {
            org.printEverythingOfAnElement();
        }
        System.out.println("Show command was executed successfully");
    }

    public void removeByID(String needExecuting) {
        builder.checkID(needExecuting);
        builder.removeID(needExecuting);
        collection.removeIf(org -> String.valueOf(org.getId()).equals(needExecuting));
        System.out.println("remove_by_id command was executed successfully");
    }

    public void updateById(String needExecuting) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        builder.checkID(needExecuting);
        String str = "";
        builder.checker.inputFromUser(br, str, "number", "Please enter the value", "Must be a number");
        for(Organization org : collection) {
            if(String.valueOf(org.getId()).equals(needExecuting)) {
                org.changeValOfTurnover(Float.parseFloat(str));
            }
        }
        System.out.println("update command was executed successfully");

    }

    public void printAll() {
        for(Organization org : collection) {
            System.out.println(org.getFullName() + " " + org.getAddress());
        }
        System.out.println("Print_unique_postal_address command was executed successfully");
    }

    public void filter(String head) {
        for(Organization org : collection) {
            String fullname = org.getFullName();
            if(fullname.contains(head)) {
                org.printEverythingOfAnElement();
            }
        }
        System.out.println("Filter_starts_with_full_name executed successfully");
    }

    public void saveIntoCSV() {
        for(Organization org : collection) {
            writer.writeToCSV(org.packagingToString());

        }
        System.out.println("save command was executed successfully.");
    }

    public void addIfMax() {
        String[] element = builder.buildFromKeyboard();
        Float mx = 0.0F;
        for(Organization org : collection) {
            mx = Math.max(mx, org.getAnnualTurnover());
        }
        if(Float.compare(Float.parseFloat(element[5]), mx) > 0) {
            Organization org = new Organization();
            org.setOrganization(element);
            collection.add(org);
            System.out.println("The element was added to the collection.");
        } else {
            System.out.println("The element was not added to the collection.");
        }
        System.out.println("add_if_max command was executed successfully");
    }

    public void removeLower() {
        String[] element = builder.buildFromKeyboard();
        collection.removeIf(org -> Float.compare(Float.parseFloat(element[5]), org.getAnnualTurnover()) > 0);
    }

}
