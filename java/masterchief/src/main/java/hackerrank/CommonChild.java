package hackerrank;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CommonChild {
    static Scanner sc;

    public static void main(String[] args) throws FileNotFoundException {
        sc = new Scanner(System.in);
        sc = new Scanner(new FileInputStream(CommonChild.class.getClassLoader().
                getResource("CommonChild/input.txt").getFile()));
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        int ans = lcs(s1, s2);
        System.out.println(ans);
        sc.close();
    }

    static int lcs(String s1, String s2){
        return lcs(s1.toCharArray(), s2.toCharArray());
    }

    static int lcs(char[] s1, char[] s2){
        int[][] table = new int[s1.length+1][s2.length+1];
        for(int i = 0; i < s1.length+1; i++){
            for(int j = 0; j < s2.length+1; j++){
                if(i == 0 || j == 0){
                    table[i][j] = 0;
                } else {
                    if(s1[i-1] ==  s2[j-1]){
                        table[i][j] = table[i-1][j-1] + 1;
                    } else {
                        table[i][j] = Integer.max(table[i-1][j], table[i][j-1]);
                    }
                }
            }
        }
        return table[s1.length][s2.length];
    }

}
