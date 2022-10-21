package leetcode._24;

import java.util.HashSet;
import java.util.Set;

public class P2405 {
    public int partitionString(String s) {
        int L=0, R=0, result = 1;
        Set<Character> appeared = new HashSet<>();
        while (R < s.length()) {
            if (appeared.contains(s.charAt(R))) {
                ++result;
                appeared.clear();
                L = R;
            }
            else {
                appeared.add(s.charAt(R));
                ++R;
            }
        }
        return result;
    }
}
