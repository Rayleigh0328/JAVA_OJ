package leetcode._24;

import javafx.util.Pair;

public class P2446 {
    public boolean haveConflict(String[] event1, String[] event2) {
        Pair<Integer, Integer> pair1 = processEvent(event1);
        Pair<Integer, Integer> pair2 = processEvent(event2);
        Pair<Integer, Integer> pair3;
        if (pair1.getKey() > pair2.getKey()) {
            pair3 = pair1;
            pair1 = pair2;
            pair2 = pair3;
        }
        return pair1.getValue() >= pair2.getKey();
    }

    private Pair<Integer, Integer> processEvent(String[] event) {
       return new Pair<Integer, Integer>(
            processTime(event[0]),
            processTime(event[1])
        );
    }

    private Integer processTime(String s) {
        String hs = s.substring(0,2);
        String ms = s.substring(3);
        return Integer.valueOf(hs) * 60 + Integer.valueOf(ms);
    }

}
