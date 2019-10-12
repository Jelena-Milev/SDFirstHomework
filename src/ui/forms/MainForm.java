/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.forms;

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
import util.SystemOperations;

/**
 *
 * @author jeca
 */
public class MainForm extends JFrame {
    
    private SystemOperations systemOperations;

    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel errorLabelA;
    private JLabel errorLabelB;
    private JTextField aTxtField;
    private JTextField bTxtField;
    private JTextField cTxtField;
    private JButton addButton;
    private JButton substactButton;

    public MainForm() {
        this.systemOperations = SystemOperations.getSystemOperationsInstance();
        prepareForm();
        setLocationRelativeTo(this.getParent());
    }

    private void prepareForm() {
        this.setTitle("Simple Calculator");
        this.setPreferredSize(new Dimension(600, 400));

        this.initializeComponents();
        this.putComponentsOnForm();

        this.addButton.addActionListener(
                (e) -> this.addButtonPressed());

        this.substactButton.addActionListener(
                (e) -> this.substractButtonPressed()
        );
        this.addErrorListener(this.aTxtField, this.errorLabelA);
        this.addErrorListener(this.bTxtField, this.errorLabelB);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void initializeComponents() {
        this.label1 = new JLabel("a: ");
        this.label2 = new JLabel("b: ");
        this.label3 = new JLabel("c: ");
        this.errorLabelA = new JLabel();
        this.errorLabelB = new JLabel();
        this.aTxtField = new JTextField();
        this.bTxtField = new JTextField();
        this.cTxtField = new JTextField();
        this.cTxtField.setEditable(false);
        this.addButton = new JButton("Saberi");
        this.substactButton = new JButton("Oduzmi");
        this.addButton.setEnabled(false);
        this.substactButton.setEnabled(false);
    }

    private void putComponentsOnForm() {
        GridLayout layout = new GridLayout(6, 2, 40, 50);
        this.setLayout(layout);

        this.add(this.label1);
        this.add(this.aTxtField);
        this.add(this.errorLabelA);

        this.add(this.label2);
        this.add(this.bTxtField);
        this.add(this.errorLabelB);

        this.add(this.label3);
        this.add(this.cTxtField);
        this.add(this.addButton);
        this.add(this.substactButton);

        pack();
    }

    private void addButtonPressed() {
        double a = Double.parseDouble(this.aTxtField.getText());
        double b = Double.parseDouble(this.bTxtField.getText());
        double c = this.systemOperations.add(a, b);
        this.cTxtField.setText(c + "");
    }

    private void substractButtonPressed() {
        double a = Double.parseDouble(this.aTxtField.getText());
        double b = Double.parseDouble(this.bTxtField.getText());
        double c = this.systemOperations.substract(a, b);
        this.cTxtField.setText(c + "");
    }

    private boolean isContentValid(JTextField txtField) {
        try {
            Double.parseDouble(txtField.getText());
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    private void addErrorListener(JTextField txtField, JLabel errorLabel){
        txtField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                boolean contentValid = isContentValid(txtField);
                addButton.setEnabled(contentValid);
                substactButton.setEnabled(contentValid);
                if (contentValid) {
                    errorLabel.setText("");
                } else {
                    errorLabel.setText("Greska. Morate uneti broj.");
                }
            }
        });
    }
}
