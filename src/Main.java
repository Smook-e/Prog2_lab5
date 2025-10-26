import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {


        StudentDatabase database = new StudentDatabase("Files\\Students.txt");

        
        Student updated = new Student("10688","Malak", "Female", 21, "Computer", 3.1);
        ArrayList<Person> persons = database.getPersons();
//        System.out.println(database.addPerson(student1));
        System.out.println(database.updatePerson(updated));
        for (Person p : persons) {
            System.out.println(p);
        }
        database.saveToFile();
    }
}