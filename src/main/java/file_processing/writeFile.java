package file_processing;

import java.io.FileWriter;
import java.io.IOException;

public class writeFile {
    private FileWriter fw;
    public writeFile(String fileName) {
        try {
            fw = new FileWriter(fileName);
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }

    public void writeToCSV(String[] org) {
        String text = "";
        for(int i = 0; i < org.length; i++) {
            text += org[i];
            if(i != org.length - 1) {
                text += ",";
            } else {
                text += "\n";
            }
        }
        try {
            fw.write(text);
            fw.flush();
            //fw.close();
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }
}
