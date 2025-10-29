import java.util.Random;

public class Student extends Person {
    private String id;
    private double gpa;
    public Student(String id, String fullName, String gender, int age, String department,  double gpa) {
        super(fullName, age, department, gender);
        this.id = id;
        if(id.isEmpty() || id == null){
            Random random = new Random();
            this.id = String.valueOf(random.nextInt(1000) + 10000);
        }
        this.gpa = gpa;
    }
    //commit
    @Override
    public String toString() {
        return id + "," + super.toString() + "," + gpa;
    }
    @Override
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }



}
