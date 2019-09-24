package leetcode;

class TrieNode {
    TrieNode[] links = new TrieNode[26];
    boolean isEnd;
}

class Trie {
    TrieNode root = new TrieNode();
    
    public void insert(String word) {
        TrieNode curr = this.root;
        for(char c : word.toCharArray()) {
            if(curr.links[c - 'a'] == null) {
                curr.links[c - 'a'] = new TrieNode();
            }
            curr = curr.links[c - 'a'];
        }
        curr.isEnd = true;
    }
    
    public boolean search(String word) {
        return match(this.root, 0, word);
    }
    
    private boolean match(TrieNode node, int pos, String word) {
        char currChar = word.charAt(pos);
        if(currChar != '.') {
            if(node.links[currChar - 'a'] == null) {
                return false;
            } else if(pos == word.length() - 1 && node.links[currChar - 'a'].isEnd) {
                return true;
            } else {
                return match(node.links[currChar - 'a'], pos + 1, word);
            }
        } else {
            boolean ans = false;
            for(char c = 'a'; c <= 'z'; c++) {
                if(node.links[c - 'a'] == null) {
                    ans = ans || false;
                } else if(pos == word.length() - 1 && node.links[c - 'a'].isEnd) {
                    ans = ans || true;
                } else {
                    ans = ans || match(node.links[c - 'a'], pos + 1, word);
                }
                if(ans) {
                    break;
                }
            }
            return ans;
        }
    }
}

public class AddAndSerachWord {
    Trie trie = new Trie();

    /** Initialize your data structure here. */
    public AddAndSerachWord() {
        
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        trie.insert(word);
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return trie.search(word);
    }

    public static void main(String[] args) {
        AddAndSerachWord asw = new AddAndSerachWord();
        asw.addWord("bad");
        asw.addWord("dad");
        asw.addWord("mad");
        System.out.println(asw.search("pad"));
        System.out.println(asw.search("bad"));
        System.out.println(asw.search(".ad"));
        System.out.println(asw.search("b.."));
    }
}