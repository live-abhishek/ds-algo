package hackerearth.capillary_18_10;

import java.io.FileInputStream;
import java.util.Scanner;
import java.util.stream.IntStream;

public class UploadServer {
    private static Scanner sc = new Scanner(System.in);
    private static final String N = "N";
    private static final String V = "V";
    private static final String M = "M";

    public static void main(String[] args) throws Exception {
        sc = new Scanner(new FileInputStream(MaximumSum.class.getClassLoader()
                .getResource("hackerearth/capillary-18-10/UploadServer.txt").getFile()));
        int n = sc.nextInt();
        sc.nextLine();
        IntStream.range(0, n).forEach(i -> solveLine());
    }

    private static void solveLine() {
        String line = sc.nextLine();
        String[] words = line.split(" ");
        // too less or too much info; not according to the format
        if (words.length < 2 || words.length > 3) {
            System.out.println(N);
        } else if (words.length == 2) {
            process_data(words[0], words[1]);
        } else { // words.length == 3
            process_data(words[0], words[1], words[2]);
        }
    }

    public static void process_data(String a, String b){
        String ans = isName(a) && isNumber(b) ? M : N;
        System.out.println(ans);
    }

    public static void process_data(String a, String b, String c){
        String ans = isName(a) && isNumber(b) && isNumber(c) ? V : N;
        System.out.println(ans);
    }

    private static boolean isName(String word){
        return word.matches("[a-zA-Z0-9]+") && !isNumber(word);
        /*char[] chars = word.toCharArray();
        boolean foundAlphabet = false;
        for (int i = 0; i < chars.length; i++) {
            if(chars[i] >= 48 && chars[i] <= 57){
                continue;
            } else if(chars[i] >= 65 && chars[i] <= 90){
                foundAlphabet = true;
            } else if(chars[i] >= 97 && chars[i] <= 122){
                foundAlphabet = true;
            } else {
                return false;
            }
        }
        return foundAlphabet;*/
    }

    private static boolean isNumber(String word){
        return word.matches("[1-9][0-9]*");
    }
}
