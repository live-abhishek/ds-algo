package hackerrank;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CeasarCipher {
    static Scanner sc;
    public static void main(String[] args) throws FileNotFoundException {
        sc = new Scanner(System.in);
        sc = new Scanner(new FileInputStream(CeasarCipher.class.getClassLoader()
                .getResource("CeasarCipher/input.txt").getFile()));
        int n = sc.nextInt(); sc.nextLine();
        String s = sc.nextLine();
        int k = sc.nextInt();

        String result = encrypt(s, k);
        System.out.println(result);
        sc.close();
    }

    public static String encrypt(String s, int k){
        char[] chars = s.toCharArray();
        for(int i = 0; i < chars.length; i++){
            chars[i] = getEncryptedChar(chars[i], k);
        }
        String encrypted = new String(chars);
        return encrypted;
    }

    public static char getEncryptedChar(char ch, int k){
        if(Character.isLowerCase(ch)){
            char a = Character.valueOf('a');
            char newChar = (char)(a + ((ch - a + k) % 26));
            return newChar;
        } else if(Character.isUpperCase(ch)){
            char A =  Character.valueOf('A');
            char newChar = (char)(A + ((ch - A + k) % 26));
            return newChar;
        } else {
            return ch;
        }
    }
}
