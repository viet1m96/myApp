package receiver;


import faults.*;
import num.Mode;

import java.io.BufferedReader;
import java.io.IOException;

public class CheckInput {
    public CheckInput() {}

    public boolean checkString(String str) {
        return !str.isEmpty();
    }
    public boolean checkNumber(String str) {
        if(str.isEmpty()) return false;
        if(str.charAt(0) == '.' || str.charAt(str.length()-1) == '.') return false;
        int cnt = 0;
        for(int i = 0; i < str.length(); i++) {
            char tmp = str.charAt(i);
            if(tmp == '.') cnt++;
            if(cnt > 1) return false;
            if((tmp < '0' || tmp > '9') && tmp != '.') return false;
        }
        return true;
    }
    public boolean checkType(String str) {
        if(str.isEmpty()) return false;
        return str.equals("PUBLIC") || str.equals("GOVERNMENT") || str.equals("PRIVATE_LIMITED_COMPANY") || str.equals("TRUST") || str.equals("OPEN_JOINT_STOCK_COMPANY");
    }


    public String gettingString(Mode a, String s, BufferedReader br) {
        String str = "";
        try {
            if(a == Mode.FILE) {
                str = br.readLine();
            } else {
                char target = ' ';
                int idx = s.indexOf(target);
                str = s.substring(idx);
                str = str.replaceAll("\\s", "");
            }
        } catch (IOException e) {
            System.out.println("The data is invalid.");
        }
        return str;
    }

    public String inputFromUser(Mode a, BufferedReader br, String tmp, String typeOf, String notice, String condition) {
        while(tmp.isEmpty()) {
            if(a == Mode.KBOARD) System.out.println(notice + '(' + condition + ')');
            try {
                String str = br.readLine();
                boolean check;
                if(typeOf.equals("number")) {
                    check = checkNumber(str);
                } else if(typeOf.equals("string")) {
                    check = checkString(str);
                } else {
                    check = checkType(str);
                }
                if(check) {
                    tmp = str;
                    break;
                } else {
                    throw new IOException();
                }
            } catch(IOException e) {
                System.out.println("The input was invalid.");
            }
            if(a == Mode.FILE) break;
        }
        return tmp;
    }


}
