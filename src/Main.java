import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        Student student1 = new Student("12345", "Ahmed", "Male", 21, "Engineering", 3.7);

        StudentDatabase database = new StudentDatabase("C:\\Users\\Mega Store\\Documents\\GitHub\\Prog2_lab5\\Files\\Students.txt");
        database.addPerson(student1);
        database.saveToFile();
        ArrayList<Person> persons = database.getPersons();
        for (Person p : persons) {
            System.out.println(p);
        }
    }
}