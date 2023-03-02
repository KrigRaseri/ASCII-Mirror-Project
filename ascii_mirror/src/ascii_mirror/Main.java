package ascii_mirror;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Input the file path:");
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader r = new BufferedReader(new FileReader(reader.readLine()))) {

            String line;
            while ((line = r.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            System.out.println("File not found!");
        }
    }
}
