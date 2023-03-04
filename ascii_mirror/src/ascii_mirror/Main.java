package ascii_mirror;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main implements Util {
    public static void main(String[] args) {
        System.out.println("Input the file path:");
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader r = new BufferedReader(new FileReader(reader.readLine()))) {

            List<String> li = new ArrayList<>(Util.fillList(r));

            Util.fixLength(li);
            Util.printMirror(li);

        } catch (IOException e) {
            System.out.println("File not found!");
        }
    }
}
