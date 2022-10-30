package leetcode._24;

import java.util.LinkedList;
import java.util.List;

public class P2452 {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> result = new LinkedList<>();
        for (String query : queries) {
            if (check(query, dictionary)) result.add(query);
        }
        return result;
    }

    private boolean check(String query, String [] dict) {
        for (String template : dict) {
            if (getDiff(query, template) <= 2) return true;
        }
        return false;
    }

    private int getDiff(String query, String template) {
        int total = 0;
        for (int i=0;i<Math.min(query.length(), template.length());++i) {
            if (query.charAt(i) != template.charAt(i)) ++total;
        }
        return total;
    }
}
