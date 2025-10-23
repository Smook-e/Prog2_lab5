
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

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
