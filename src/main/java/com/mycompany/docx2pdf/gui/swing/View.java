package com.mycompany.docx2pdf.gui.swing;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class View extends JFrame {

    public View() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 3));

        JTextField tfDocx = new JTextField();
        JButton bDocx = new JButton("Browse...");

        JTextField tfPdf = new JTextField();
        JButton bPdf = new JButton("Browse...");

        JTextField tfFonts = new JTextField();
        JButton bFonts = new JButton("Browse...");

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

        this.setSize(400, 500);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
