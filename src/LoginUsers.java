import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LoginUsers {
    private ArrayList<String> users = new ArrayList<>();
    private String fileName;

    public LoginUsers(String fileName){

        this.fileName = fileName;
        try(BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            if(!users.isEmpty()){}
            while ((line = br.readLine()) != null) {
                users.add(line);
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        catch (IOException e) {
            System.out.println("Error reading file");
        }
    }
    public boolean userExists(String usernameAndPassword) {
        for (String user : users) {
            if (user.equals(usernameAndPassword)) {
                return true;
            }
        }
        return false;
    }

}
