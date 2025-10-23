import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        Student student1 = new Student("10345", "Maged", "Male", 22, "Business", 3.0);

        StudentDatabase database = new StudentDatabase("C:\\Users\\Mega Store\\Documents\\GitHub\\Prog2_lab5\\Files\\Students.txt");

        

        ArrayList<Person> persons = database.getPersons();
        System.out.println(database.updatePerson(student1));
        for (Person p : persons) {
            System.out.println(p);
        }
        database.saveToFile();
    }
}