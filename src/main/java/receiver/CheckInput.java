package receiver;

import faults.InputNotRight;

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
        if(!str.equals("PUBLIC") && !str.equals("GOVERNMENT") && !str.equals("PRIVATE_LIMITED_COMPANY") && !str.equals("TRUST") && !str.equals("OPEN_JOINT_STOCK_COMPANY")) return false;
        return true;
    }

    public String inputFromUser(BufferedReader br, String tmp, String typeOf, String notice, String condition) {
        while(tmp.isEmpty()) {
            System.out.println(notice + '(' + condition + ')');
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
                    throw new InputNotRight();
                }
            } catch(IOException e) {
                System.out.println(e.toString());
            } catch(InputNotRight e) {
                System.out.println(e.toString());
            }
        }
        return tmp;
    }
}
