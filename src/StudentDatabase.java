import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.EventObject;

public class StudentDatabase extends Database {


    public StudentDatabase(String fileName) throws FileNotFoundException {
        super(fileName);
    }

    @Override
    public Student createRecordFrom(String s){
        String[] fields = s.split(",");
        Student student;
        student = new Student(fields[0], fields[1], fields[2], Integer.parseInt(fields[3]), fields[4], Double.parseDouble(fields[5]));
        return student;

    }

    @Override
    public boolean addPerson(Person p) {
        if(!containsPersonById(p.getId())){
            persons.add(p);
            return true;
        }
        return false;
    }

    @Override
    public boolean removePerson(Person p) {
        if(containsPersonById(p.getId())){
            persons.remove(p);
            return true;
        }
        return false;
    }

    public boolean updatePerson(Person p){
        Student s =(Student) p;
        for(Person p1 : persons){
            if(p1.getId().equals(s.getId())){
                Student s1 =(Student) p1;
                p1.setAge(p.getAge());
                p1.setDepartment(p.getDepartment());
                p1.setFullName(p.getFullName());
                p1.setGender(p.getGender());
                s1.setGpa(s.getGpa());
                return true;
            }
        }
        return false;
    }
}
