import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        Student student1 = new Student("10345", "Maged", "Male", 22, "Business", 3.0);

        StudentDatabase database = new StudentDatabase("Files\\Students.txt");
//        database.addPerson(student1);
        ArrayList<Person> persons = database.getPersons();
        System.out.println(database.updatePerson(student1));
        for (Person p : persons) {
            System.out.println(p);
        }
        database.saveToFile();
    }
}