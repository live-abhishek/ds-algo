package hackerrank;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class TwoCharacters {

    static Scanner sc;

    public static void main(String... args) throws FileNotFoundException {
        sc = new Scanner(System.in);
        sc = new Scanner(new FileInputStream(TwoCharacters.class.getClassLoader()
                .getResource("TwoCharacters/input.txt").getFile()));
        sc.nextInt();
        sc.nextLine();
        String str = sc.nextLine();

        int res = solve(str);
        System.out.println(res);
        sc.close();
    }

    public static int solve(String s){
        if(s.length() == 1){
            return 0;
        }

        Set<Integer> set = s.chars().mapToObj(c -> Integer.valueOf(c))
                .collect(Collectors.toSet());
        ArrayList<Integer> list = new ArrayList<>(set);
        int max = 0;
        int size = list.size();
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                int m = list.get(i), n = list.get(j);
                List<Integer> newStr = s.chars()
                        .filter(c -> c == m || c == n)
                        .mapToObj(c -> Integer.valueOf(c))
                        .collect(Collectors.toList());
                if(validate(newStr)){
                    max = Integer.max(max, newStr.size());
                }
            }
        }
        return max;
    }

    public static boolean validate(List<Integer> ls){
        for(int i = 0; i < ls.size() - 1; i++){
            if(ls.get(i) == ls.get(i+1)){
                return false;
            }
        }
        return true;
    }

}
