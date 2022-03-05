package ru.itis.Gui;

import ru.itis.Models.Certificant;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import static ru.itis.App2.*;


public class Gui extends JPanel
        implements ActionListener {
    static private final String newline = "\n";
    JButton openButton;
    JTextArea log;
    JFileChooser fc;
    String directory;

    public Gui() {

        super(new BorderLayout());

        //Create the log first, because the action listeners
        //need to refer to it.
        log = new JTextArea(5, 20);
        log.setMargin(new Insets(5, 5, 5, 5));
        log.setEditable(false);
        JScrollPane logScrollPane = new JScrollPane(log);

        //Create a file chooser
        fc = new JFileChooser();

        //Uncomment one of the following lines to try a different
        //file selection mode.  The first allows just directories
        //to be selected (and, at least in the Java look and feel,
        //shown).  The second allows both files and directories
        //to be selected.  If you leave these lines commented out,
        //then the default mode (FILES_ONLY) will be used.
        //
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        //fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

        //Create the open button.  We use the image from the JLF
        //Graphics Repository (but we extracted it from the jar).
        openButton = new JButton("Open Directory...");
        openButton.addActionListener(this);

        //Create the save button.  We use the image from the JLF
        //Graphics Repository (but we extracted it from the jar).

        //For layout purposes, put the buttons in a separate panel
        JPanel buttonPanel = new JPanel(); //use FlowLayout
        buttonPanel.add(openButton);

        //Add the buttons and the log to this panel.
        add(buttonPanel, BorderLayout.PAGE_START);
        add(logScrollPane, BorderLayout.CENTER);
    }

    public void actionPerformed(ActionEvent e) {
        JButton companykeysubmit = new JButton("Submit");
        companykeysubmit.setBounds(50, 150, 100, 30);
        JFrame companyKeyFrame = new JFrame("Generate key 1");
        JLabel companyKeyLabel = new JLabel("Name Key");
        JTextField companynamekey = new JTextField();
        companynamekey.setBounds(50, 100, 200, 30);
        companyKeyLabel.setBounds(50, 50, 100, 30);
        companyKeyFrame.setPreferredSize(new Dimension(390, 300));
        companyKeyFrame.setLocation(100, 150);

        companyKeyFrame.add(companykeysubmit);
        companyKeyFrame.add(companynamekey);
        companyKeyFrame.add(companyKeyLabel);
        companyKeyFrame.setLayout(null);

//--------------
        JFrame certify1 = new JFrame("GENERATE CERTIFICANT");
        certify1.setLayout(null);
        certify1.setPreferredSize(new Dimension(600, 500));
        certify1.setLocation(100, 150);
        JLabel countryCodeLabel = new JLabel("country Code");
        countryCodeLabel.setBounds(30,30, 100, 30);
        JTextField countryCodefield = new JTextField();
        countryCodefield.setBounds(150,30, 200, 30);
        JLabel stateLabel = new JLabel("state");
        stateLabel.setBounds(30,60, 200, 30);
        JTextField statefield = new JTextField();
        statefield.setBounds(150,60, 200, 30);
        JLabel cityLabel = new JLabel("city");
        cityLabel.setBounds(30,90, 200, 30);
        JTextField cityfield = new JTextField();
        cityfield.setBounds(150,90, 200, 30);
        JLabel organizationLabel = new JLabel("organization");
        organizationLabel.setBounds(30,120, 200, 30);
        JTextField organizationfield = new JTextField();
        organizationfield.setBounds(150,120, 200, 30);
        JLabel organizationuLabel = new JLabel("organization unit");
        organizationuLabel.setBounds(30,150, 200, 30);
        JTextField organizationufield = new JTextField();
        organizationufield.setBounds(150,150, 200, 30);
        JLabel nameLabel = new JLabel("name");
        nameLabel.setBounds(30,180, 200, 30);
        JTextField namefield = new JTextField();
        namefield.setBounds(150,180, 200, 30);
        JLabel mailLabel = new JLabel("email");
        mailLabel.setBounds(30,210, 200, 30);
        JTextField mailfield = new JTextField();
        mailfield.setBounds(150,210, 200, 30);
        JLabel certificateLabel = new JLabel("name certificate");
        certificateLabel.setBounds(30,240, 200, 30);
        JTextField certificatefield = new JTextField();
        certificatefield.setBounds(150,240, 200, 30);
        JLabel keyl = new JLabel("name root key");
        keyl.setBounds(30,270, 200, 30);
        JTextField keyfield = new JTextField();
        keyfield.setBounds(150,270, 200, 30);
        JButton submit2 = new JButton("Submit");
        submit2.setBounds(50, 320, 100, 30);


        certify1.add(countryCodeLabel);
        certify1.add(countryCodefield);
        certify1.add(stateLabel);
        certify1.add(statefield);
        certify1.add(cityLabel);
        certify1.add(cityfield);
        certify1.add(organizationLabel);
        certify1.add(organizationfield);
        certify1.add(organizationufield);
        certify1.add(organizationuLabel);
        certify1.add(nameLabel);
        certify1.add(namefield);
        certify1.add(mailLabel);
        certify1.add(mailfield);
        certify1.add(certificateLabel);
        certify1.add(certificatefield);
        certify1.add(keyl);
        certify1.add(keyfield);
        certify1.add(submit2);
        //---------------
        JFrame key2 = new JFrame("generate key 2");
        JButton submit3 = new JButton("Submit");
        submit3.setBounds(50, 150, 100, 30);
        key2.setPreferredSize(new Dimension(390, 300));
        key2.setLocation(100, 150);


        JLabel keyLabel = new JLabel("Name Key");
        JTextField namekey = new JTextField();
        namekey.setBounds(50, 100, 200, 30);
        keyLabel.setBounds(50, 50, 100, 30);


        key2.add(submit3);
        key2.add(keyLabel);
        key2.add(namekey);
        key2.setLayout(null);

        //---
        JFrame certify2 = new JFrame("generate certificate 2");
        certify2.setLayout(null);
        certify2.setPreferredSize(new Dimension(600, 500));
        JButton submit4 = new JButton("Submit");
        submit4.setBounds(50, 300, 100, 30);
        certify2.setLocation(100, 150);
        JLabel countryCodeLabel2 = new JLabel("country Code");
        countryCodeLabel2.setBounds(30,30, 100, 30);
        JTextField countryCodefield2 = new JTextField();
        countryCodefield2.setBounds(150,30, 200, 30);
        JLabel stateLabel2= new JLabel("state");
        stateLabel2.setBounds(30,60, 200, 30);
        JTextField statefield2 = new JTextField();
        statefield2.setBounds(150,60, 200, 30);
        JLabel cityLabel2 = new JLabel("city");
        cityLabel2.setBounds(30,90, 200, 30);
        JTextField cityfield2 = new JTextField();
        cityfield2.setBounds(150,90, 200, 30);
        JLabel organizationLabel2 = new JLabel("organization");
        organizationLabel2.setBounds(30,120, 200, 30);
        JTextField organizationfield2 = new JTextField();
        organizationfield2.setBounds(150,120, 200, 30);
        JLabel organizationuLabel2 = new JLabel("organization unit");
        organizationuLabel2.setBounds(30,150, 200, 30);
        JTextField organizationufield2 = new JTextField();
        organizationufield2.setBounds(150,150, 200, 30);
        JLabel nameLabel2 = new JLabel("name");
        nameLabel2.setBounds(30,180, 200, 30);
        JTextField namefield2 = new JTextField();
        namefield2.setBounds(150,180, 200, 30);
        JLabel mailLabel2 = new JLabel("email");
        mailLabel2.setBounds(30,210, 200, 30);
        JTextField mailfield2 = new JTextField();
        mailfield2.setBounds(150,210, 200, 30);
        JLabel certificateLabel2 = new JLabel("name certificate");
        certificateLabel2.setBounds(30,240, 200, 30);
        JTextField certificatefield2 = new JTextField();
        certificatefield2.setBounds(150,240, 200, 30);
        JLabel keyLabel2 = new JLabel("name key");
        keyLabel2.setBounds(30,270, 200, 30);
        JTextField keyfield2 = new JTextField();
        keyfield2.setBounds(150,270, 200, 30);


        certify2.add(countryCodeLabel2);
        certify2.add(countryCodefield2);
        certify2.add(stateLabel2);
        certify2.add(statefield2);
        certify2.add(cityLabel2);
        certify2.add(cityfield2);
        certify2.add(organizationLabel2);
        certify2.add(organizationfield2);
        certify2.add(organizationufield2);
        certify2.add(organizationuLabel2);
        certify2.add(nameLabel2);
        certify2.add(namefield2);
        certify2.add(mailLabel2);
        certify2.add(mailfield2);
        certify2.add(certificateLabel2);
        certify2.add(certificatefield2);
        certify2.add(keyLabel2);
        certify2.add(keyfield2);
        certify2.add(submit4);

        //Handle open button action.
        if (e.getSource() == openButton) {
            int returnVal = fc.showOpenDialog(Gui.this);

            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
                //This is where a real application would open the file.
                log.append("Opening: " + file.getAbsolutePath() + "." + newline);
                directory = file.getAbsolutePath();
                companykeysubmit.addActionListener(actionEvent -> {
                    System.out.println(companynamekey.getText());

                    try {
                        generatekey(companynamekey.getText(), directory);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }

                    certify1.pack();
                    certify1.setVisible(true);
                    companyKeyFrame.dispose();

                });
                submit2.addActionListener(actionEvent -> {
                    try {
                        generatecertroot(new Certificant(countryCodefield.getText(),statefield.getText(),cityfield.getText(),organizationfield.getText(),organizationufield.getText(),namefield.getText(),mailfield.getText(),certificatefield.getText(),keyfield.getText()),directory);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }

                    key2.pack();
                    key2.setVisible(true);
                    certify1.dispose();


                });
                submit3.addActionListener(actionEvent -> {
                    System.out.println(namekey.getText());

                    try {
                        generatekey(namekey.getText(), directory);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }

                    certify2.pack();
                    certify2.setVisible(true);
                    key2.dispose();



                });
                submit4.addActionListener(actionEvent -> {
                    try {
                        generateceruser(new Certificant(countryCodefield2.getText(),statefield2.getText(),cityfield2.getText(),organizationfield2.getText(),organizationufield2.getText(),namefield2.getText(),mailfield2.getText(),certificatefield2.getText(),keyfield2.getText()),directory);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }

                    certify2.dispose();


                });
                companyKeyFrame.pack();
                companyKeyFrame.setVisible(true);
                System.out.println(directory);

            } else {
                log.append("Open command cancelled by user." + newline);
            }
            log.setCaretPosition(log.getDocument().getLength());

            //Handle save button action.
        } else {
            log.append("Save command cancelled by user." + newline);
        }
        log.setCaretPosition(log.getDocument().getLength());
    }

    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("GuiProbe");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Add content to the window.
        frame.add(new Gui());

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        //Schedule a job for the event dispatch thread:
        //creating and showing this application's GUI.
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                //Turn off metal's use of bold fonts
                UIManager.put("swing.boldMetal", Boolean.FALSE);
                createAndShowGUI();
            }
        });
    }
}