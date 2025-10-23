import java.io.*;
import java.util.ArrayList;

public abstract class Database {
    protected ArrayList<Person> persons = new ArrayList<>();
    protected String fileName;

    public Database(String fileName) throws FileNotFoundException {
        this.fileName = fileName;
        this.readFile();
    }
    public ArrayList<Person> getPersons() {
        return persons;
    }
    public abstract Person createRecordFrom(String s);
    public void readFile(){
        try(BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            if(!persons.isEmpty()) {
                persons.clear();
            }
            while ((line = br.readLine()) != null) {
                Person p = createRecordFrom(line);
                if(p != null) {
                    persons.add(p);
                }

            }
        }
        catch(FileNotFoundException e) {
            System.out.println("File not found");
        }
        catch (IOException e) {
            System.out.println("Error reading file " + fileName);
            throw new RuntimeException(e);

        }
    }
    public Person getPersonById(String Id) {
        for(Person p : persons) {
            if(p.getId().equals(Id)) {
                return p;
            }
        }
        return null;
    }
    public Person getPersonByName(String Name) {
        for(Person p : persons) {
            if(p.getName().equalsIgnoreCase(Name)) {
                return p;
            }
        }
        return null;
    }
    public boolean containsPersonById(String Id) {
        return getPersonById(Id) != null;
    }
    public boolean containsPersonByName(String Name) {
        return getPersonByName(Name) != null;
    }
    public void saveToFile() throws IOException {
        try(FileWriter fw = new FileWriter(fileName)){
            for(Person p : persons) {
                fw.write(p + "\n");
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found :  " + fileName);
        }
        catch(IOException e) {
            System.out.println("Error writing file :  " + fileName);
        }
    }
    public abstract boolean addPerson(Person p);
    public abstract boolean removePerson(Person p);

}
