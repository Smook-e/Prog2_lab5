public class StudentDatabase extends Database {


    public StudentDatabase(String fileName) {
        super(fileName);
    }

    @Override
    public Student createRecordFrom(String s){
        String[] fields = s.split(",");
        Student student;
        student = new Student(fields[0], fields[1], fields[2], Integer.parseInt(fields[3]), fields[4], Double.parseDouble(fields[5]));
        return student;

    }
}
