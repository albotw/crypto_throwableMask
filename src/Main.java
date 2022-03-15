import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Scanner;
import javax.swing.*;

import javax.accessibility.Accessible;
import javax.swing.*;


public class Main{
    public static void main(String[] args) throws IOException {


      /*  Scanner scanner = new Scanner(System.in);
        System.out.println("Fichier a crypter: ");
        String filePath = scanner.nextLine();
        System.out.println("Fichier de sortie: ");
        String outPath = scanner.nextLine();

        File file = new File(filePath);
        byte[] content = Files.readAllBytes(file.toPath());
        LFSR singleLFSR = new LFSR(new int[]{5, 6, 8, 16}, 0b1100000000110000);

        for (int i = 0; i < content.length; i++) {
            byte word = content[i];
            int xor = singleLFSR.cycleByte();
            System.out.println(Integer.toBinaryString(word));
            System.out.println(Integer.toBinaryString(xor));
            content[i] = (byte) (word ^ xor);
            System.out.println(Integer.toBinaryString(word));
            System.out.println("========");
        }

        File out = new File(outPath);
        Files.write(out.toPath(), content);


*/
       MyFrame MyFrame = new MyFrame();
        MyFrame.setVisible(true);


        }
    }