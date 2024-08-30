import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

import static java.nio.file.StandardOpenOption.CREATE;


public class PersonReader {
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

                List<String> persons;
                // Organizer for Person Reader
                System.out.println("ID#\t\tFirst Name\tLast Name\tTitle\tYOB");
                System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");

                while(reader.ready()){
                    rec = reader.readLine();
                    persons = Arrays.asList(rec.split(","));
                    for (String person : persons) {
                        System.out.printf("%s\t", person);
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
