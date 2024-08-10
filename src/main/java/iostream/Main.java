package iostream;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {
    public static void main(String[] args) throws IOException {
        Handle hand = new Handle("/home/cun/IdeaProjects/Application/src/main/resources/data.csv");
        hand.init();
        hand.running();
    }
}