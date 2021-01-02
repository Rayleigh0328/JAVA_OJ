package leetcode;

import javafx.util.Pair;

import java.util.Comparator;
import java.util.PriorityQueue;

public class P1705_2 {
    public int eatenApples(int[] apples, int[] days) {
        int result = 0;
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>(Comparator.comparingInt(Pair::getKey));
        for (int i=0;i<apples.length;++i) {
            if (apples[i] > 0) pq.add(new Pair<>(i + days[i], apples[i]));
            result += tryToEat(i,pq);
        }
        for (int i=apples.length;!pq.isEmpty();++i){
            result += tryToEat(i, pq);
        }
        return result;
    }

    private int tryToEat(int day, PriorityQueue<Pair<Integer, Integer>> pq){
        Pair<Integer, Integer> pair;
        while (!pq.isEmpty() && pq.peek().getKey() <= day){
            pq.poll();
        }
        if (pq.isEmpty()) return 0;
        pair = pq.poll();
        if (pair.getValue() > 1)
            pq.add(new Pair(pair.getKey(), pair.getValue() - 1));
        return 1;
    }
}
