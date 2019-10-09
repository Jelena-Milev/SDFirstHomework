/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Panel;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author jeca
 */
public class MainForm extends JFrame{
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel errorA;
    private JLabel errorB;
    private JTextField a;
    private JTextField b;
    private JTextField c;
    private JButton addButton;
    private JButton substactButton;   
    
    public MainForm() {
        initializeComponents();
        setLocationRelativeTo(this.getParent());
    }

    private void initializeComponents() {
        this.setTitle("Simple Calculator");
        
        this.label1 = new JLabel("a: ");
        this.label2 = new JLabel("b: ");
        this.label3 = new JLabel("c: ");
        this.errorA = new JLabel();
        this.errorB = new JLabel();
        this.a = new JTextField();
        this.b = new JTextField();
        this.c = new JTextField();
        this.addButton = new JButton("Saberi");
        this.substactButton = new JButton("Oduzmi");
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        GridLayout layout = new GridLayout(6, 2, 40, 50);
        this.setLayout(layout);

        
        this.add(this.label1);
        this.add(this.a);
//        this.add(this.errorA);
        
        this.add(this.label2);
        this.add(this.b);
//        this.add(this.errorB);
        
        this.add(this.label3);
        this.add(this.c);
        this.add(this.addButton);
        this.add(this.substactButton);
        
        this.setPreferredSize(new Dimension(600, 400));
        pack();
        
        this.c.setEditable(false);
        
    }
}
