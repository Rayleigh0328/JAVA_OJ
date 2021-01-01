package lib.string.trie;

import java.util.List;

public class Trie <E extends ITrieNode> {

    private E root;

    public Trie(E root){
        this.root = root;
    }

    public E getRoot() {
        return root;
    }

    public E insertString(String st) {
        E cur = root;
        for (int i=0; i<st.length(); ++i) {
            Character ch = st.charAt(i);
            cur = (E) cur.expandTo(ch);
        }
        return cur;
    }

    public E find(String st){
        E cur = root;
        for (int i=0; i<st.length(); ++i){
            if (cur == null) return null;
            Character ch = st.charAt(i);
            cur = (E) cur.moveTo(ch);
        }
        return cur;
    }

    public E findWithPreference(String st, List<Character> preference) {
        E cur = root, tentative;
        for (int i=0; i<st.length(); ++i){
            if (cur == null) return null;
            Character ch = st.charAt(i);
            tentative = (E) cur.moveTo(ch);
            if (tentative != null){
                cur = tentative;
                continue;
            }
            for (Character preferredChar : preference) {
                tentative = (E) cur.moveTo(preferredChar);
                if (tentative != null) {
                    cur = tentative;
                    break;
                }
            }
        }
        return cur;
    }

}
