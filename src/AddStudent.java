
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author HP
 */
public class AddStudent extends AddAndUpdatePanel{
    private StudentDatabase sDatabase;
    public AddStudent()
    {
        super();
        try {
            sDatabase = new StudentDatabase("C:\\Users\\HP\\OneDrive\\Documents\\GitHub\\Prog2_lab5\\Files\\Students.txt");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AddStudent.class.getName()).log(Level.SEVERE, null, ex);
        }
        save.addActionListener(
                new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                        if(validateInput())
                        {
                            Student s = new Student(getID(),getStudentName(),getGender()
                                    ,Integer.parseInt(getAge()),getDepartment(),Double.parseDouble(getGPA()));
                            if(sDatabase.addPerson(s))
                            {   
                               try {
                                    sDatabase.saveToFile();
                                } catch (IOException ex) {
                                    Logger.getLogger(AddStudent.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                
                                JOptionPane.showMessageDialog(null,"Student Added Successfully");
                            }
                            else
                                JOptionPane.showMessageDialog(null,"Student Already Exist");
                        }
                            
                            
                        }
                    });
    }
    
}
