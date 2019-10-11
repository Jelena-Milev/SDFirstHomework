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
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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
        prepareForm();
        setLocationRelativeTo(this.getParent());
    }

    private void prepareForm() {
        this.setTitle("Simple Calculator");
        this.setPreferredSize(new Dimension(600, 400));
        
        this.initializeComponents();        
        this.putComponentsOnForm();
        
        pack();
        
        this.addButton.addActionListener(
                (e) -> this.addButtonPressed());
        
        this.substactButton.addActionListener(
                (e) -> this.substractButtonPressed()
        );
        this.a.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void keyPressed(KeyEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void keyReleased(KeyEvent e) {
                key(a, errorA);
            }
        });
        
        this.b.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void keyPressed(KeyEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void keyReleased(KeyEvent e) {
                key(b, errorB);
            }
        });
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    private void initializeComponents(){
        this.label1 = new JLabel("a: ");
        this.label2 = new JLabel("b: ");
        this.label3 = new JLabel("c: ");
        this.errorA = new JLabel();
        this.errorB = new JLabel();
        this.a = new JTextField();
        this.b = new JTextField();
        this.c = new JTextField();
        this.c.setEditable(false);
        this.addButton = new JButton("Saberi");
        this.substactButton = new JButton("Oduzmi");
        this.addButton.setEnabled(false);
        this.substactButton.setEnabled(false);
    }
    
    private void putComponentsOnForm(){
        GridLayout layout = new GridLayout(6, 2, 40, 50);
        this.setLayout(layout);
        
        this.add(this.label1);
        this.add(this.a);
        this.add(this.errorA);
        
        this.add(this.label2);
        this.add(this.b);
        this.add(this.errorB);
        
        this.add(this.label3);
        this.add(this.c);
        this.add(this.addButton);
        this.add(this.substactButton);
    }
    
    private void addButtonPressed(){
        double a = Double.parseDouble(this.a.getText());
        double b = Double.parseDouble(this.b.getText());
        double c = a+b;
        this.c.setText(c+"");
    }
    
    private void substractButtonPressed(){
        double a = Double.parseDouble(this.a.getText());
        double b = Double.parseDouble(this.b.getText());
        double c = a-b;
        this.c.setText(c+"");
    }
    
    private void key(JTextField txtField, JLabel label){
        try{
            Double.parseDouble(txtField.getText());
            this.addButton.setEnabled(true);
            this.substactButton.setEnabled(true);
            label.setText("");
        }catch(NumberFormatException e){
            this.addButton.setEnabled(false);
            this.substactButton.setEnabled(false);
            label.setText("Greska! Unesite broj!");
        }
        
    }
}
