/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.forms;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Insets;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
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
        this.setPreferredSize(new Dimension(400, 400));

        this.initializeComponents();
        this.putComponentsOnForm();

        this.addButton.addActionListener(
                (e) -> this.addButtonPressed());

        this.substactButton.addActionListener(
                (e) -> this.substractButtonPressed()
        );
        this.addErrorListener(this.aTxtField);
        this.addErrorListener(this.bTxtField);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void initializeComponents() {
        this.label1 = new JLabel("a: ", SwingConstants.RIGHT);
        this.label2 = new JLabel("b: ", SwingConstants.RIGHT);
        this.label3 = new JLabel("c: ", SwingConstants.RIGHT);
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
        JPanel panel = new JPanel();
        panel.setBorder(new EmptyBorder(new Insets(25, 40, 25, 40)));
        GridLayout layout = new GridLayout(0, 2, 10, 5);
        layout.preferredLayoutSize(this.getContentPane());
        panel.setLayout(layout);
        this.getContentPane().add(panel);

        panel.add(this.label1);
        panel.add(this.aTxtField);
        panel.add(new JLabel(" "));
        panel.add(this.errorLabelA);

        panel.add(this.label2);
        panel.add(this.bTxtField);
        panel.add(new JLabel(" "));
        panel.add(this.errorLabelB);

        panel.add(this.label3);
        panel.add(this.cTxtField);
        panel.add(this.addButton);
        panel.add(this.substactButton);

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

    private void addErrorListener(JTextField txtField) {
        txtField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                boolean contentAValid = isContentValid(aTxtField);
                boolean contentBValid = isContentValid(bTxtField);
                boolean contentValid = contentAValid && contentBValid;

                addButton.setEnabled(contentValid);
                substactButton.setEnabled(contentValid);

                if (contentAValid) {
                    errorLabelA.setText("");
                } else {
                    errorLabelA.setText("Unesite broj.");
                }

                if (contentBValid) {
                    errorLabelB.setText("");
                } else {
                    errorLabelB.setText("Unesite broj.");
                }
            }
        });
    }

    private boolean isContentValid(JTextField txtField) {
        try {
            Double.parseDouble(txtField.getText());
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
