package leetcode._24;

import java.util.LinkedList;

public class P2434 {
    public String robotWithString(String str) {
        LinkedList<Character> s = new LinkedList<>();
        LinkedList<Character> t = new LinkedList<>();
        int [] count = new int[26];
        for (Character ch : str.toCharArray()) {
            ++count[ch - 'a'];
            s.add(ch);
        }
        StringBuffer result = new StringBuffer();
        for (char ch = 'a'; ch <= 'z'; ++ch) {
            while (count[ch-'a'] > 0) {
                if (!t.isEmpty() && t.getLast() <= ch) {
                    result.append(t.removeLast());
                    continue;
                }

                --count[s.getFirst()-'a'];
                t.addLast(s.removeFirst());
            }
        }
        while (!t.isEmpty()) result.append(t.removeLast());
        return result.toString();
    }
}
