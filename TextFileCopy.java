// 18.	Create a file A.txt and copy the content of A.txt to B.txt.

import java.io.*;

public class TextFileCopy {
    public static void main(String[] args) {
        // Create and write to A.txt
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("A.txt"))){
            writer.write("This is the content of file A.txt\n");
            writer.write("Second line of text\n");
            writer.write("Third line of text");
            System.out.println("File A.txt created successfully!");
        } catch (IOException e) {
            System.out.println("Error creating A.txt: " + e.getMessage());
        }

        // Copy the contents of A.txt to B.txt
        try (BufferedReader reader = new BufferedReader(new FileReader("A.txt"));
             BufferedWriter writer = new BufferedWriter(new FileWriter("B.txt"))) {

            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine(); // maintain line breaks
            }
            System.out.println("Content copied to B.txt successfully!");

        }catch (FileNotFoundException e) {
            System.out.println("File A.txt not found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error creating B.txt: " + e.getMessage());
        }
    }
}
