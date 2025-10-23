
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author HP
 */
public class AddAndUpdatePanel extends JPanel {
    private JTextField id,name,age,department,GPA;
    private ButtonGroup gender;
    private JRadioButton male,female;
    private JButton save;
    public AddAndUpdatePanel()
    {
        id=new JTextField(10);
        name=new JTextField(30);
        age=new JTextField(5);
        department=new JTextField(30);
        GPA=new JTextField(5);
        gender=new ButtonGroup();
        male=new JRadioButton("Male");
        female=new JRadioButton("Female");
        gender.add(male);
        gender.add(female);
        setLayout(new GridLayout(7,3,15,15));
        add(new JLabel("Student ID:"));
        add(id);
        add(new JLabel(""));
        add(new JLabel("Full Name:"));
        add(name);
        add(new JLabel(""));
        add(new JLabel("Age:"));
        add(age);
        add(new JLabel(""));
        add(new JLabel("Gender:"));
        add(male);
        add(female);
        add(new JLabel("Department:"));
        add(department);
        add(new JLabel(""));
        add(new JLabel("GPA:"));
        add(GPA);
        add(new JLabel(""));
        save=new JButton("Save");
        add(new JLabel(""));
        add(new JLabel(""));
        add(save);
        save.addActionListener(
                new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                        validateInput();
                    }
    });}
    private boolean validateInput()
    {
        if(id.getText().isEmpty()||name.getText().isEmpty()||department.getText().isEmpty()
                ||GPA.getText().isEmpty()||((!male.isSelected())&&(!female.isSelected())))
        {
            JOptionPane.showMessageDialog(null,"Please fill all form!","Error",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        try
        {
            int numID=Integer.parseInt(id.getText());
            int numAge=Integer.parseInt(age.getText());
            if((numAge<11)||(numAge>100))
            {
                throw new IllegalArgumentException("Age must be between 11 and 100!"); 
            }
            double numGPA=Double.parseDouble(GPA.getText());
            if((numGPA<0.0||numGPA>4.0))
            {
                throw new IllegalArgumentException("GPA must be between 0.0 and 4.0"); 
            }
            
        }catch(NumberFormatException e)
        {
             JOptionPane.showMessageDialog(null,"Please enter valid ID , Age and GPA !","Validation Error",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        catch(IllegalArgumentException e)
        {
                    JOptionPane.showMessageDialog(null,e.getMessage(),"Validation Error",JOptionPane.ERROR_MESSAGE);
                    return false;
        }
        if(!name.getText().matches("[a-zA-Z\\s]+"))
        {
             JOptionPane.showMessageDialog(null,"Name must only contain letters and spaces","Validation Error",JOptionPane.ERROR_MESSAGE);   
             return false;
        }
        if(!department.getText().matches("[a-zA-Z\\s]+"))
        {
             JOptionPane.showMessageDialog(null,"Department must only contain letters and spaces","Validation Error",JOptionPane.ERROR_MESSAGE);   
             return false;
        }
        return true;
 }
    
    
    
}
