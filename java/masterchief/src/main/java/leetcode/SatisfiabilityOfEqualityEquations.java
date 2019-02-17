package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SatisfiabilityOfEqualityEquations {
    public boolean equationsPossible(String[] equations) {
        List<Integer>[] graph = new ArrayList[26];
        // initialize adjacency list of each node
        for (int i = 0; i < 26; i++) {
            graph[i] = new ArrayList<>();
        }
        // fill up the adjacency list of each node
        for (String eq : equations) {
            if(eq.charAt(1) == '=') {
                int l = eq.charAt(0) - 'a';
                int r = eq.charAt(3) - 'a';
                graph[l].add(r);
                graph[r].add(l);
            }
        }

        // do a depth first search
        // mark each node traversed in the same tree with same color
        int[] color = new int[26];
        int c = 0;
        for (int s = 0; s < 26; s++) {
            if (color[s] == 0) { // color = 0 means not colored yet
                c++; // pick a new color
                Stack<Integer> stack = new Stack<>();
                stack.push(s);
                while (!stack.isEmpty()) {
                    Integer node = stack.pop();
                    for (int nbr : graph[node]) {
                        if (color[nbr] == 0) { // if this node is not visited yet
                            color[nbr] = c;
                            stack.push(nbr);
                        }
                    }
                }
            }
        }

        for (String eq : equations) {
            if (eq.charAt(1) == '!') {
                int l = eq.charAt(0) - 'a';
                int r = eq.charAt(3) - 'a';
                if (l == r || color[l] == color[r]) {
                    return false;
                }
            }
        }

        return true;
    }




    public static void main(String[] args) {
        SatisfiabilityOfEqualityEquations s = new SatisfiabilityOfEqualityEquations();
        s.equationsPossible(null);
    }
}
