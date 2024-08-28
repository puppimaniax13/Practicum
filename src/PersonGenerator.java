import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;


public class PersonGenerator {
    public static void main(String[] args) {

        try {
            File personData = new File("PersonTestData.txt");
            if (personData.createNewFile()) {
                System.out.println("File created:" + personData.getName());
            } else {
                System.out.println("File already exists:" + personData.getName());
            }
        } catch (IOException e) {
            System.out.println("File could not be created");
        }

        Scanner in = new Scanner(System.in);

        boolean done = false;

        String ID;
        String firstName;
        String lastName;
        String title;
        int yearBorn;

        List<String[]> person = new ArrayList<>();

        while(!done) {
            ID = SafeInput.getNonZeroLenString(in, "Please input the Person's ID: ");
            firstName = SafeInput.getNonZeroLenString(in, "Please input the first name: ");
            lastName = SafeInput.getNonZeroLenString(in, "Please input the last name: ");
            title = SafeInput.getNonZeroLenString(in, "Please input the title: ");
            yearBorn = SafeInput.getInt(in, "Please input the year born: ");

            person.add(new String[]{
                    ID, firstName, lastName, title, String.valueOf(yearBorn)
            });

            done = SafeInput.getYNConfirm(in, "Are you done adding people?");
        }



        try {
            FileWriter personWriter = new FileWriter("PersonTestData.txt");
            for (String[] strings : person) {
                personWriter.write(Arrays.toString(strings).substring(1, Arrays.toString(strings).length() - 1) + "\n");
            }
            personWriter.close();
        } catch (IOException e) {
            System.out.println("File could not be written");
        }


        System.out.println(person.size());

    }
}

