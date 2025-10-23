public abstract class Person {
    protected String fullName;
    protected String department;
    protected int age;
    protected String gender;

    public Person(String fullName, int age, String department, String gender) {
        this.fullName = fullName;
        this.age = age;
        this.department = department;
        this.gender = gender;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return fullName + " " + gender + " " + age + " " + department  ;
    }
    public abstract String getId();
    public String getName(){
        return fullName;
    }


}
