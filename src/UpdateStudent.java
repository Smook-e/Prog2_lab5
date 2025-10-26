import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
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
public class UpdateStudent extends AddAndUpdatePanel {
    private StudentDatabase sDatabase;
    public UpdateStudent()
    {
        super();
        try {
            sDatabase=new StudentDatabase("Files\\Students.txt");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(UpdateStudent.class.getName()).log(Level.SEVERE, null, ex);
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
                            if(sDatabase.updatePerson(s))
                            {   
                               try {
                                    sDatabase.saveToFile();
                                } catch (IOException ex) {
                                    Logger.getLogger(AddStudent.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                
                                JOptionPane.showMessageDialog(null,"Student Updated Successfully.");
                                 // back to search panel
                                javax.swing.SwingUtilities.getWindowAncestor(save).dispose(); // close update window
                                searchStudents searchWindow = new searchStudents();
                                searchWindow.setVisible(true);
                                searchWindow.setLocationRelativeTo(null);

                            }
                            else
                                JOptionPane.showMessageDialog(null,"Failed To Update.");
                        }
                            
                            
                        }
                    })  ;
    }
    }
