import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;

public class Main{
    public static Path inputPath;
    public static Path outputPath;
    public static String mode;
    public static long singleInit, vnInit, xnInit, ynInit, znInit;

    public static void main(String[] args) throws Exception {
        MainFrame frame = new MainFrame();
        frame.setSize(new Dimension(400, 400));
        frame.setTitle("Cryptage par masque jetable");
        frame.setVisible(true);
    }

    public static void process() throws Exception {
        Main.checkValues();
        byte[] file = Files.readAllBytes(Main.inputPath);

        if (Objects.equals(Main.mode, "single")) {
            System.out.println("single process");
            singleProcess(file);
        }
        else if (Objects.equals(Main.mode, "multi")) {
            System.out.println("multi process");
            multiProcess(file);
        }
        else {
            System.out.println("mode undefined ??");
        }
    }

    public static void singleProcess(byte[] file) throws IOException {
        byte[] out = new byte[file.length];

        LFSR lfsr = new LFSR(new int[]{5, 6, 8, 16}, Main.singleInit);

        for (int i = 0; i < file.length; i++) {
            byte word = file[i];
            int xor = lfsr.cycleByte();
            out[i] = (byte) (word ^ xor);
        }
        getOutputPath();
        Files.write(Main.outputPath, out);
    }

    public static void multiProcess(byte[] file) throws IOException {
        byte[] out = new byte[file.length];

        LFSR vn = new LFSR(new int[]{5, 13, 17, 25}, Main.vnInit);
        LFSR xn = new LFSR(new int[]{7, 15, 19, 31}, Main.xnInit);
        LFSR yn = new LFSR(new int[]{5, 9, 29, 33}, Main.ynInit);
        LFSR zn = new LFSR(new int[]{3, 11, 35, 39}, Main.znInit);

        for (int i = 0; i < file.length; i++) {
            byte word = file[i];
            int xor = vn.cycleByte() ^ xn.cycleByte() ^ yn.cycleByte() ^ zn.cycleByte();

            out[i] = (byte) (word ^ xor);
        }

        getOutputPath();
        Files.write(Main.outputPath, out);
    }

    public static void checkValues() throws Exception {
        if (Objects.equals(Main.mode, "single")) {
            if (Main.inputPath == null) {
                throw new Exception("Erreur, fichier d'entr??e non d??fini");
            }
            if (Main.singleInit == 0) {
                throw new Exception("Erreur, valeur du LFSR non initialis??e");
            }
        }
        else if (Objects.equals(Main.mode, "multi")) {
            if (Main.inputPath == null) {
                throw new Exception("Erreur, fichier d'entr??e non d??fini");
            }
            if (Main.vnInit == 0) {
                throw new Exception("Erreur, valeur du LFSR Vn non initialis??e");
            }
            if (Main.xnInit == 0) {
                throw new Exception("Erreur, valeur du LFSR Xn non initialis??e");
            }
            if (Main.ynInit == 0) {
                throw new Exception("Erreur, valeur du LFSR Yn non initialis??e");
            }
            if (Main.znInit == 0) {
                throw new Exception("Erreur, valeur du LFSR Zn non initialis??e");
            }
        }
        else {
            throw new Exception("Erreur, mode non d??fini");
        }
    }

    public static void getOutputPath() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Destination");
        fileChooser.setCurrentDirectory(new File(Main.inputPath.toString()));
        int response = fileChooser.showSaveDialog(null);
        if (response == JFileChooser.APPROVE_OPTION) {
            Main.outputPath = fileChooser.getSelectedFile().toPath();
        }
    }
}