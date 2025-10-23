import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        Student student1 = new Student( "Malak", "Female", 20, "Medical", 3.1);

        StudentDatabase database = new StudentDatabase("Files\\Students.txt");

        

        ArrayList<Person> persons = database.getPersons();
        System.out.println(database.addPerson(student1));
        for (Person p : persons) {
            System.out.println(p);
        }
        database.saveToFile();
    }
}