package leetcode._24;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class P2449 {
    private long count;

    public long makeSimilar(int[] nums, int[] target) {
        count = 0;
        Arrays.sort(nums);
        Arrays.sort(target);
        LinkedList<Long> evenInput =
            Arrays.stream(nums).filter(e -> (e & 1) == 0).mapToLong(e->e).boxed().collect(Collectors.toCollection(LinkedList::new));
        LinkedList<Long> oddInput =
            Arrays.stream(nums).filter(e -> (e & 1) == 1).mapToLong(e->e).boxed().collect(Collectors.toCollection(LinkedList::new));

        LinkedList<Long> evenTarget=
            Arrays.stream(target).filter(e -> (e & 1) == 0).mapToLong(e->e).boxed().collect(Collectors.toCollection(LinkedList::new));
        LinkedList<Long> oddTarget =
            Arrays.stream(target).filter(e -> (e & 1) == 1).mapToLong(e->e).boxed().collect(Collectors.toCollection(LinkedList::new));

        long rem = solve(evenInput, evenTarget) / 2;
        solve(oddInput, oddTarget);
        return count + rem;
    }

    private long solve(LinkedList<Long> input, LinkedList<Long> target) {
        long positive = 0;
        long negative = 0;
        long x,y;
        while (!input.isEmpty()) {
            x = input.pollFirst();
            y = target.pollFirst();
            if (x > y) {
                positive += x - y;
            }
            else {
                negative += y - x;
            }
        }

        count += Math.min(positive, negative) / 2;
        return Math.abs(positive - negative);
    }

}
