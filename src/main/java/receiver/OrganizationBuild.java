package receiver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import faults.*;

public class OrganizationBuild {
    private Set<String> setOfId;
    public CheckInput checker;
    public OrganizationBuild() {
        checker = new CheckInput();
        setOfId = new HashSet<>();
    }


    public void checkID(String id) {
        try {
            if(!setOfId.contains(id)) throw new IdNotInTheSet();
            if(!(checker.checkNumber(id))) throw new InputNotANumber();
        } catch(IdNotInTheSet e) {
            System.out.println(e.toString());
        } catch(InputNotANumber e) {
            System.out.println(e.toString());
        }
    }
    public void removeID(String id) {setOfId.remove(id);}



    public String[] buildFromKeyboard() {
        String[] result = new String[10];
        Random rnd = new Random();
        int n = 100000 + rnd.nextInt(900000);
        while(setOfId.contains(String.valueOf(n))) {
            n = 100000 + rnd.nextInt(900000);
        }
        setOfId.add(String.valueOf(n));
        for(int i = 0; i < 10; i++) result[i] = "";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String tmp = "";
        result[1] = checker.inputFromUser(br, tmp, "string", "Name", "Must not be empty");
        result[2] = checker.inputFromUser(br, tmp, "number", "Coordinates X", "Must be a number and not be empty");
        result[3] = checker.inputFromUser(br, tmp, "number", "Coordinates Y", "Must be a number and not be empty");
        result[5] = checker.inputFromUser(br, tmp, "number", "Annual Turnover", "Must be a number and not be empty");
        result[6] = checker.inputFromUser(br, tmp, "string", "Full Name", "Must not be empty");
        result[7] = checker.inputFromUser(br, tmp, "number", "Number of Employees", "Must be a number and not be empty");
        result[8] = checker.inputFromUser(br, tmp, "type", "Type HERE one of these following types: PUBLIC, GOVERNMENT, TRUST, PRIVATE_LIMITED_COMPANY, OPEN_JOINT_STOCK_COMPANY", "Must not be empty");
        result[9] = checker.inputFromUser(br, tmp, "string", "Address", "Must not be empty");
        result[4] = LocalDateTime.now().toString();
        result[0] = Integer.toString(n);
        return result;
    }


}
