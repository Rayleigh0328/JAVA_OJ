package lib.string.trie;

import java.util.List;

public class Trie {

    private ITrieNode root;

    public Trie(ITrieNode root){
        this.root = root;
    }


    public ITrieNode getRoot() {
        return root;
    }

    public ITrieNode insertString(String st) {
        ITrieNode cur = root;
        for (int i=0; i<st.length(); ++i) {
            Character ch = st.charAt(i);
            cur = cur.expandTo(ch);
        }
        cur.setWordEndCount(cur.getWordEndCount() + 1);
        return cur;
    }

    public ITrieNode find(String st){
        ITrieNode cur = root;
        for (int i=0; i<st.length(); ++i){
            if (cur == null) return null;
            cur = cur.moveTo(st.charAt(i));
        }
        return cur;
    }

    public ITrieNode findWithPreference(String st, List<Character> preference) {
        ITrieNode cur = root, tentative;
        for (int i=0; i<st.length(); ++i){
            if (cur == null) return null;
            Character ch = st.charAt(i);
            tentative = cur.moveTo(ch);
            if (tentative != null){
                cur = tentative;
                continue;
            }
            for (Character preferredChar : preference) {
                tentative = cur.moveTo(preferredChar);
                if (tentative != null) {
                    cur = tentative;
                    break;
                }
            }
        }
        return cur;
    }

}
