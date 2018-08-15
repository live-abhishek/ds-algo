package hackerrank;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SherlockAndAnagrams {
    static Scanner sc;
    public static void main(String[] args) throws FileNotFoundException {
        sc = new Scanner(System.in);
        sc = new Scanner(new FileInputStream(SherlockAndAnagrams.class.getClassLoader()
                .getResource("SherlockAndAnagrams/input.txt").getFile()));
        int q = sc.nextInt(); sc.nextLine();
        for(int i = 0; i < q; i++){
            String str = sc.nextLine();
            int ans = sherlockAndAnagrams(str);
            System.out.println(ans);
        }
        sc.close();
    }

    static int sherlockAndAnagrams(String s) {
        char[] chars = s.toCharArray();
        int count = 0;
        for(int len = 1; len < chars.length; len++){
            for(int i = 0; i < chars.length - len; i++){
                char[] newChar1 = Arrays.copyOfRange(chars, i, i+len);
                for(int j  = i+1; j < chars.length - len + 1; j++){
                    char[] newChar2 = Arrays.copyOfRange(chars, j, j+len);
                    if(checkChars(newChar1, newChar2)){
                        count++;
                    }
                }
            }
        }
        return count;
    }

    static boolean checkChars(char[] char1, char[] char2){
        Map<Character, Integer> map1 = new HashMap<>(char2.length);
        Map<Character, Integer> map2 = new HashMap<>(char2.length);
        for(int i = 0; i < char1.length; i++){
            map1.put(char1[i], map1.getOrDefault(char1[i], 0)+1);
            map2.put(char2[i], map2.getOrDefault(char2[i], 0)+1);
        }
        if(map1.size() != map2.size()){
            return false;
        }
        for(int i = 0; i < char1.length; i++){
            if(map1.get(char1[i]) != map2.get(char1[i])){
                return false;
            }
        }
        return true;
    }

}
