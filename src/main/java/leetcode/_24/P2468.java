package leetcode._24;

import java.util.ArrayList;

public class P2468 {

    public String[] splitMessage(String message, int partLengthLimit) {
        if (partLengthLimit <= 5) return new String[0];

        int n = message.length();
        int partCountLimit = 10;
        String [] result;
        while (partCountLimit <= n * 10) {
            result = solve(message, partLengthLimit, partCountLimit);
            if (result.length > 0) return result;
            partCountLimit *= 10;
        }
        return new String[0];
    }

    private String[] solve(String message, int partLengthLimit, int partCountLimit) {
        int initCapacity = partLengthLimit - getLen(partCountLimit - 1) - 3;
        int rem = message.length();
        int count = 1;
        while (rem > 0) {
            rem -= initCapacity - getLen(count);
            if (count++ >= partCountLimit) return new String[0];
        }
        return construct(message, partLengthLimit, partCountLimit, count-1);
    }

    private String[] construct(String message, int partLengthLimit, int partCountLimit, int total) {
        int initCapacity = partLengthLimit - getLen(partCountLimit - 1) - 3;
        int count = 1, pos = 0;
        ArrayList<String> list = new ArrayList<>();
        while (pos < message.length()) {
            int len = initCapacity - getLen(count);
            list.add(
                new StringBuilder()
                    .append(message.substring(pos, Math.min(message.length(), pos + len)))
                    .append('<')
                    .append(count)
                    .append("/")
                    .append(total)
                    .append('>')
                    .toString()
            );
            pos += len;
            ++count;
        }
        return list.toArray(new String[0]);
    }

    private int getLen(int k) {
        if (k == 0) return 1;
        int result = 0;
        while (k > 0) {
            k /= 10;
            ++result;
        }
        return result;
    }

}
