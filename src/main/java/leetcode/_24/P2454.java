package leetcode._24;

import java.util.Stack;

public class P2454 {

    public int[] secondGreaterElement(int[] a) {
        int n = a.length;
        int [] next = new int [n];
        Stack<Integer> s = new Stack();
        for (int i=n-1;i>=0;--i) {
            while (!s.isEmpty() && a[i] >= a[s.peek()]) s.pop();
            if (s.isEmpty()) next[i] = -1;
            else next[i] = s.peek();
            s.push(i);
        }

        int [] result = new int [n];
        for (int i=n-1;i>=0;--i) {
            int j = next[i];
            if (j == -1) {
                result[i] = -1;
                continue;
            }
            j = j+1;
            while (0<=j && j < n && a[j] <= a[i]) j = next[j];
            result[i] = j;
        }
        for (int i=0;i<n;++i) {
            if (0 <= result[i] && result[i] < n) {
                result[i] = a[result[i]];
            } else {
                result[i] = -1;
            }
        }
        return result;
    }
}
