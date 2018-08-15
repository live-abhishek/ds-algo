package hackerrank;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MarsExploration {

    static Scanner sc;

    public static void main(String[] args) throws FileNotFoundException {
        sc = new Scanner(System.in);
        sc = new Scanner(new FileInputStream(MarsExploration.class.getClassLoader()
                .getResource("MarsExploration/input.txt").getFile()));
        String msg = sc.nextLine();
        int changes = marsExploration(msg);
        System.out.println(changes);
    }

    public static int marsExploration(String msg){
        int count = 0;
        char[] chars = msg.toCharArray();
        for(int i = 0; i < msg.length(); i++){
            if(i % 3 == 0){ // first Charater 'S'
                if(chars[i] != 'S') count++;
            }else if(i % 3 == 1){ // second Character 'O'
                if(chars[i] != 'O') count++;
            }else if(i % 3 == 2){ // third Character 'S'
                if(chars[i] != 'S') count++;
            }
        }
        return count;
    }
}
