package com.mycompany.docx2pdf.gui.swing;

import docx2pdf.Converter;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

public class View extends JFrame {

    JTextField tfDocx = new JTextField();
    JButton bDocx = new JButton("Browse...");

    JTextField tfPdf = new JTextField();
    JButton bPdf = new JButton("Browse...");

    JTextField tfFonts = new JTextField();
    JButton bFonts = new JButton("Browse...");

    public View() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 3));

        panel.add(new JLabel("DOCX:"));
        panel.add(tfDocx);
        panel.add(bDocx);

        panel.add(new JLabel("PDF:"));
        panel.add(tfPdf);
        panel.add(bPdf);

        panel.add(new JLabel("Fonts folder:"));
        panel.add(tfFonts);
        panel.add(bFonts);

        this.setLayout(new BorderLayout());
        this.add(panel, BorderLayout.CENTER);

        //
        JButton bGenerate = new JButton("Generate");
        this.add(bGenerate, BorderLayout.SOUTH);

        //
        bDocx.addActionListener((ActionEvent e) -> {
            chooseDocx();
        });
        bPdf.addActionListener((ActionEvent e) -> {
            choosePdf();
        });
        bFonts.addActionListener((ActionEvent e) -> {
            chooseFonts();
        });
        bGenerate.addActionListener((ActionEvent e) -> {
            generate();
        });

        this.setSize(700, 300);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void chooseDocx() {
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "Docx files", "docx");
        chooser.setFileFilter(filter);
        int returnVal = chooser.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            tfDocx.setText(chooser.getSelectedFile().getAbsolutePath());
        }
    }

    private void choosePdf() {
        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int returnVal = chooser.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            tfPdf.setText(chooser.getSelectedFile().getAbsolutePath());
        }
    }

    private void chooseFonts() {
        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int returnVal = chooser.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            tfFonts.setText(chooser.getSelectedFile().getAbsolutePath());
        }
    }

    private void generate() {
        try {
            String in = tfDocx.getText();
            String out = tfPdf.getText() + "/out.pdf";
            String fontsFolder = tfFonts.getText();

            Converter c = new Converter(in, out, fontsFolder);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
