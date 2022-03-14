import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    String filePath;
    String outPath;
    String mode;

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Fichier a crypter: ");
        String filePath = scanner.nextLine();
        System.out.println("Fichier de sortie: ");
        String outPath = scanner.nextLine();
        System.out.println("Mode d'opération (single|multi): ");
        String mode = scanner.nextLine();

        File file = new File(filePath);
        byte[] content = Files.readAllBytes(file.toPath());

        LFSR singleLFSR = null;
        LFSR vn = null;
        LFSR xn = null;
        LFSR yn = null;
        LFSR zn = null;

        if (Objects.equals(mode, "single")) {
            System.out.println("Clé de cryptage (compatible hexa) [-9 223 372 036 854 775 808 ; 9 223 372 036 854 775 808]");
            long initKey = Integer.parseInt(scanner.nextLine());
            singleLFSR = new LFSR(new int[]{5, 6, 8, 16}, initKey);
        }
        else if (Objects.equals(mode, "multi")) {
            System.out.println("Clé de cryptage (Vn) (compatible hexa) [-16 777 216 ; 16 777 216]");
            long initKeyVN = Integer.parseInt(scanner.nextLine());
            vn = new LFSR(new int[]{5, 13, 17, 25}, initKeyVN);

            System.out.println("Clé de cryptage (Xn) (compatible hexa) [-1 073 741 824 ; 1 073 741 824]");
            long initKeyXN = Integer.parseInt(scanner.nextLine());
            xn = new LFSR(new int[]{7, 15, 19, 31}, initKeyXN);

            System.out.println("Clé de cryptage (Yn) (compatible hexa) [-4 294 967 296 ; 4 294 967 296]");
            long initKeyYN = Integer.parseInt(scanner.nextLine());
            yn = new LFSR(new int[]{5, 9, 29, 33}, initKeyYN);

            System.out.println("Clé de cryptage (Zn) (compatible hexa) [-274 877 906 944 ; 274 877 906 944]");
            long initKeyZN = Integer.parseInt(scanner.nextLine());
            zn = new LFSR(new int[]{3, 11, 35, 39}, initKeyZN);
        }
        else {
            throw new Exception("Erreur, mode invalide");
        }

        for (int i = 0; i < content.length; i++) {
            byte word = content[i];
            int xor = 0;

            if (mode.equals("single")) {
                xor = singleLFSR.cycleByte();
            }
            else if (mode.equals("multi")) {
                xor = vn.cycleByte() ^ xn.cycleByte() ^ yn.cycleByte() ^ zn.cycleByte();
            }

            printIntToBinary(word);
            printIntToBinary(xor);


            //obligé de cast en byte sinon int (https://stackoverflow.com/questions/24004579/xor-bytes-in-java)
            content[i] = (byte) (word ^ xor);

            printIntToBinary(content[i]);
            System.out.println("==========================================");
        }

        File out = new File(outPath);
        Files.write(out.toPath(), content);
    }

    public static void printIntToBinary(int bin) {
        String out = String.format("%16s", Integer.toBinaryString(bin)).replace(' ', '0');
        System.out.println(out);
    }
}
