package file_processing;
import java.io.*;
import java.util.*;
import receiver.*;

public class readFile {
    BufferedReader br;

    public readFile(String fileName) {
        try {
            br = new BufferedReader(new FileReader(fileName));
        } catch(FileNotFoundException e) {
            System.out.println(e.toString());
        }
    }

    public Queue<String[]> getDataFromFile() {
        String line = "";
        String splitBy = ",";
        Queue<String[]> data = new ArrayDeque<>();
        try {
            while((line = br.readLine()) != null) {
                String[] tmp = line.split(splitBy);
                data.add(tmp);
            }
        } catch (IOException e) {
            System.out.println(e.toString());
        }
        return data;
    }


}
