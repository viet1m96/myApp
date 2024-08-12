package file_processing;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class writeFile {
    private BufferedWriter fw;
    private String fileName;

    public writeFile(){}
    public writeFile(String fileName) {
        this.fileName = fileName;
    }

    public void setPointer() {
        try {
            fw = new BufferedWriter(new FileWriter(fileName, false));
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
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }

    public void shutDown() {
        try {
            fw.close();
        } catch(IOException e) {
            System.out.println(e.toString());
        }
    }
}
