package random;

import java.util.HashSet;
import java.util.Set;

public class GoogleInterviewQuestion {
    private static int getLen(String str, Set<Character> set){
        Set<Character> ws = new HashSet<>();
        for(int i = 0; i < set.size(); i++){}
        int s = 0;
        int len = Integer.MAX_VALUE;
        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            // if windows is smaller then just add to window
            if(i - s + 1 < set.size()){
                if(set.contains(c)){
                    ws.add(c);
                }
            } else {
                if(set.contains(c)){
                    if(ws.contains(c)){
                        while(ws.size() >= set.size() || !set.contains(str.charAt(s))){
                            char sc = str.charAt(s);
                            ws.remove(sc);
                            s++;
                        }
                    }
                    ws.add(c);
                    if(set.size() == ws.size()){
                        len = Integer.min(len, i - s + 1);
                    }
                }
            }
        }
        return ws.size() < set.size() ? 0 : len;
    }

    public static void main(String[] args) {
        Set<Character> s = new HashSet<>();
        s.add('a');
        s.add('f');
        s.add('g');
        int ans = getLen("abcdefgba", s);
        System.out.println(ans);
    }

}
