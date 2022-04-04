
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Objects;
import java.util.Scanner;
import javax.swing.*;
import javax.accessibility.Accessible;
import javax.swing.*;
import java.io.FileFilter;

public class Main extends javax.swing.JFrame {

    private boolean crypterText = true;

    public static void main(String[] args){


        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }


    public Main (){
        initComponents();
    }

    private void initComboBox(){
        File dossier = new File(System.getProperty("user.dir")+"\\src\\Cryptage");
        FileFilter filtre = new FileFilter(){
            @Override
            public boolean accept(File pathname) {
                boolean res;
                if(pathname.getName().startsWith("clef-"))
                    res = false;
                else if (pathname.getName().startsWith("cryptage-"))
                    res = false;
                else if (pathname.getName().startsWith("decryptage-"))
                    res = false;
                else res = true;
                return res;
            }
        };
        importBox.removeAllItems();
        importBox.addItem("IMPORT");
        File[] fichiers = dossier.listFiles(filtre);
        for(File f : fichiers){
            importBox.addItem(f.getName());
        }
    }

       /*MyFrame MyFrame = new MyFrame();
        MyFrame.setVisible(true);*/


        private void initTextBox () {
            clefTextArea.setText("");
            messageCrypterTextArea.setText("");
            messageDecrypterTextArea.setText("");
            information.setText("");
        }


        private void initComponents () {
            buttonGroupText = new javax.swing.ButtonGroup();
            jSplitPane1 = new javax.swing.JSplitPane();
            jPanel6 = new javax.swing.JPanel();
            jPanel2 = new javax.swing.JPanel();
            jLabel2 = new javax.swing.JLabel();
            jScrollPane2 = new javax.swing.JScrollPane();
            messageTextArea = new javax.swing.JTextArea();
            jPanel3 = new javax.swing.JPanel();
            jLabel3 = new javax.swing.JLabel();
            jScrollPane3 = new javax.swing.JScrollPane();
            clefTextArea = new javax.swing.JTextArea();
            jPanel4 = new javax.swing.JPanel();
            jLabel4 = new javax.swing.JLabel();
            RadioButtonByte = new javax.swing.JRadioButton();
            messageCrypterTextArea = new javax.swing.JTextArea();
            jPanel5 = new javax.swing.JPanel();
            jLabel5 = new javax.swing.JLabel();
            jScrollPane5 = new javax.swing.JScrollPane();
            messageDecrypterTextArea = new javax.swing.JTextArea();
            jPanel1 = new javax.swing.JPanel();
            jLabel1 = new javax.swing.JLabel();
            jScrollPane1 = new javax.swing.JScrollPane();
            information = new javax.swing.JTextArea();
            jPanel7 = new javax.swing.JPanel();
            importBox = new javax.swing.JComboBox<>();
            crypter = new javax.swing.JButton();
            afficher = new javax.swing.JButton();
            decrypter = new javax.swing.JButton();
            PanelRadioButton = new javax.swing.JPanel();
            RadioButtonText = new javax.swing.JRadioButton();
            RadioButtonByte = new javax.swing.JRadioButton();

            setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
            setMinimumSize(new java.awt.Dimension(1000, 500));

            jSplitPane1.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

            jPanel6.setLayout(new java.awt.GridLayout(0, 4));

            jPanel2.setLayout(new java.awt.BorderLayout());

            jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            jLabel2.setText("Message :");
            jPanel2.add(jLabel2, java.awt.BorderLayout.NORTH);

            messageTextArea.setColumns(20);
            messageTextArea.setRows(5);
            jScrollPane2.setViewportView(messageTextArea);

            jPanel2.add(jScrollPane2, java.awt.BorderLayout.CENTER);

            jPanel6.add(jPanel2);

            jPanel3.setLayout(new java.awt.BorderLayout());

            jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            jLabel3.setText("Clef :");
            jPanel3.add(jLabel3, java.awt.BorderLayout.NORTH);

            clefTextArea.setColumns(20);
            clefTextArea.setRows(5);
            clefTextArea.setEnabled(false);
            jScrollPane3.setViewportView(clefTextArea);

            jPanel3.add(jScrollPane3, java.awt.BorderLayout.CENTER);

            jPanel6.add(jPanel3);

            jPanel4.setLayout(new java.awt.BorderLayout());

            jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            jLabel4.setText("Entrée :");
            jPanel4.add(jLabel4, java.awt.BorderLayout.NORTH);

            messageCrypterTextArea.setColumns(20);
            messageCrypterTextArea.setRows(5);
            messageCrypterTextArea.setEnabled(false);
            jScrollPane4.setViewportView(messageCrypterTextArea);
            jPanel4.add(jScrollPane4, java.awt.BorderLayout.CENTER);
            jPanel6.add(jPanel4);
            jPanel5.setLayout(new java.awt.BorderLayout());
            jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            jLabel5.setText("Sortie :");
            jPanel5.add(jLabel5, java.awt.BorderLayout.NORTH);
            messageDecrypterTextArea.setColumns(20);
            messageDecrypterTextArea.setRows(5);
            messageDecrypterTextArea.setEnabled(false);
            jScrollPane5.setViewportView(messageDecrypterTextArea);
            jPanel5.add(jScrollPane5, java.awt.BorderLayout.CENTER);
            jPanel6.add(jPanel5);
            jPanel1.setLayout(new java.awt.BorderLayout());
            jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            jLabel1.setText("Information(s) :");
            jPanel1.add(jLabel1, java.awt.BorderLayout.NORTH);
            information.setColumns(20);
            information.setRows(5);
            information.setEnabled(false);
            jScrollPane1.setViewportView(information);
            jPanel1.add(jScrollPane1, java.awt.BorderLayout.CENTER);
            //jPanel6.add(jPanel1);
            jSplitPane1.setLeftComponent(jPanel6);
            jPanel7.setLayout(new java.awt.GridLayout(1, 0));
            importBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
            jPanel7.add(importBox);
            crypter.setText("Crypter");
            jPanel7.add(crypter);
            afficher.setText("Afficher la clef");
            jPanel7.add(afficher);
            decrypter.setText("Decrypter");
            jPanel7.add(decrypter);
            jSplitPane1.setRightComponent(jPanel7);
            getContentPane().add(jSplitPane1, java.awt.BorderLayout.CENTER);
            PanelRadioButton.setLayout(new java.awt.BorderLayout());
            getContentPane().add(PanelRadioButton, java.awt.BorderLayout.SOUTH);
            pack();


        }



        private javax.swing.JPanel PanelRadioButton;
        private javax.swing.JRadioButton RadioButtonByte;
        private javax.swing.JRadioButton RadioButtonText;
        private javax.swing.JButton afficher;
        private javax.swing.ButtonGroup buttonGroupText;
        private javax.swing.JTextArea clefTextArea;
        private javax.swing.JButton crypter;
        private javax.swing.JButton decrypter;
        private javax.swing.JComboBox<String> importBox;
        private javax.swing.JTextArea information;
        private javax.swing.JLabel jLabel1;
        private javax.swing.JLabel jLabel2;
        private javax.swing.JLabel jLabel3;
        private javax.swing.JLabel jLabel4;
        private javax.swing.JLabel jLabel5;
        private javax.swing.JPanel jPanel1;
        private javax.swing.JPanel jPanel2;
        private javax.swing.JPanel jPanel3;
        private javax.swing.JPanel jPanel4;
        private javax.swing.JPanel jPanel5;
        private javax.swing.JPanel jPanel6;
        private javax.swing.JPanel jPanel7;
        private javax.swing.JScrollPane jScrollPane1;
        private javax.swing.JScrollPane jScrollPane2;
        private javax.swing.JScrollPane jScrollPane3;
        private javax.swing.JScrollPane jScrollPane4;
        private javax.swing.JScrollPane jScrollPane5;
        private javax.swing.JSplitPane jSplitPane1;
        private javax.swing.JTextArea messageCrypterTextArea;
        private javax.swing.JTextArea messageDecrypterTextArea;
        private javax.swing.JTextArea messageTextArea;
    }

