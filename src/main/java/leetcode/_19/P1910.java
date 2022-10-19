package leetcode._19;

import java.util.LinkedList;

public class P1910 {

    public String removeOccurrences(String s, String p) {
        p = p + '$';
        int [] phi = new int [p.length()];
        int [] t = new int [s.length()];

        phi[0] = -1;
        for (int i=0,j=-1;i<p.length()-1;) {
            if (p.charAt(i+1) == p.charAt(j+1)) phi[++i] = ++j;
            else if (j == -1) phi[++i] = -1;
            else j = phi[j];
        }

        LinkedList<Integer> result = new LinkedList<>();
        for (int i=-1,j=-1; i<s.length()-1; ) {
            if (s.charAt(i+1) == p.charAt(j+1)) {
                result.add(i+1);
                t[++i] = ++j;
                if (j == p.length() - 2) {
                    popMatch(result, p.length()-1);
                    j = result.isEmpty() ? -1 : t[result.getLast()];
                }
            }
            else if (j == -1) {
                result.add(i+1);
                t[++i] = -1;
            }
            else {
                j = phi[j];
            }
        }
        StringBuilder sb = new StringBuilder();
        result.forEach(e -> sb.append(s.charAt(e)));
        return sb.toString();
    }

    private void popMatch(LinkedList a, int count) {
        for (int i=0;i<count;++i) a.removeLast();
    }
}
