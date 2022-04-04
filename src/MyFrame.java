import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class MyFrame extends JFrame implements ActionListener {

    JButton button;
    MyFrame(){

        /*this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        JPanel panel = new JPanel();
        panel.setBounds(200, 200, 200, 200);
        panel.setBackground(Color.darkGray);
        this.add(panel);
        panel.setLayout(new GridLayout(2,1));


        button = new JButton("Select File");
        button.addActionListener(this);
        panel.add(button);
        this.pack();
        this.setVisible(true);

        JMenuBar menubar = new JMenuBar();
        this.setJMenuBar(menubar);

        JMenu fichier = new JMenu("Fichier");
        menubar.add(fichier);
        JMenuItem Load = new JMenuItem("Charger votre fichier");
        fichier.add(Load);

        JMenu quitter = new JMenu("Quitter");
        menubar.add(quitter);



        // Fenetre pour le masque
        JDialog jd = new JDialog(this);
        jd.setLayout(new GridLayout(1,2));
        jd.setBounds(500,300,300,400);
        JLabel JL = new JLabel("Voici le masque");
        jd.setVisible(true);*/









    }




    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            JFileChooser fileChooser = new JFileChooser();

            int response = fileChooser.showOpenDialog(null);

            if(response == JFileChooser.APPROVE_OPTION){
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                System.out.println(file);
            }
        }
    }
}
