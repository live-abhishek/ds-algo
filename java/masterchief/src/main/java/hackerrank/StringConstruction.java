package hackerrank;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class StringConstruction {
    static Scanner sc;

    public static void main(String[] args) throws FileNotFoundException {
        sc = new Scanner(System.in);
        sc = new Scanner(new FileInputStream(StringConstruction.class.getClassLoader()
                .getResource("StringConstruction/input.txt").getFile()));
        int n = sc.nextInt(); sc.nextLine();
        for(int i = 0; i < n; i++){
            String s = sc.nextLine();
            int ans = stringConstruction(s);
            System.out.println(ans);
        }
        sc.close();
    }

    public static int stringConstruction(String s){
        return 0;
    }

}
