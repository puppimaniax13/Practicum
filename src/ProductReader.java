import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

import static java.nio.file.StandardOpenOption.CREATE;



public class ProductReader {
    public static void main(String[] args) {
        JFileChooser chooser = new JFileChooser();
        File selectedFile;
        String rec;

        try {
            File workingDirectory = new File(System.getProperty("user.dir"));

            chooser.setCurrentDirectory(workingDirectory);

            if(chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                selectedFile = chooser.getSelectedFile();
                Path file = selectedFile.toPath();

                InputStream in = new BufferedInputStream(Files.newInputStream(file, CREATE));
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));

                List<String> products;
                // Organizer for Product Reader
                System.out.println("ID#\t\tName\tDesc\t\t\tCost");
                System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");


                while(reader.ready()){
                    rec = reader.readLine();
                    products = Arrays.asList(rec.split(","));
                    for (String product : products) {
                        System.out.printf("%s\t",product);
                    }
                    System.out.println();
                }
                reader.close();
                System.out.println("\n ------- \n Data File Read.");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
