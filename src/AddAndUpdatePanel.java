
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
                        validate();
                    }
    });}
     
    
    
    
}
