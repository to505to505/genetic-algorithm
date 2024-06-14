package src.Algorithm;
import java.util.Random;

public class Generate {
    static char[] alphabet = new char[27];
    private static Random generator = new Random(System.currentTimeMillis());

    public static void initAlphabet() {
        for (char c = 'A'; c <= 'Z'; c++) {
            alphabet[c - 'A'] = c;
        }
        alphabet[26] = ' ';
    }


    public static char generateChar() {
        return alphabet[generator.nextInt(alphabet.length)];
    }

    public static char[] generateChromosome() {
        char[] tempChromosome = new char[11];
        for (int j = 0; j < 11; j++) {
            char a = generateChar();
            
            tempChromosome[j] = a;
        }
        return tempChromosome;
    }


}
