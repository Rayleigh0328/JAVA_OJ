package leetcode._16;

import lib.common.ArithmeticHelper;

public class P1622 {
    static class Fancy {
        final int MAX_SIZE = 100001;
        final int MODE = 1_000_000_007;
        private long [] data;
        private long [] pm;
        private long [] pa;
        private int count;

        public Fancy() {
            data = new long [MAX_SIZE];
            pm = new long [MAX_SIZE]; pm[0] = 1;
            pa = new long [MAX_SIZE]; pa[0] = 0;
            count = 0;
        }

        public void append(int val) {
            data[count++] = val;
            pm[count] = pm[count-1];
            pa[count] = pa[count-1];
        }

        public void addAll(int inc) {
            pa[count] = (pa[count] + inc) % MODE;
        }

        public void multAll(int m) {
            pm[count] = (pm[count] * m) % MODE;
            pa[count] = (pa[count] * m) % MODE;
        }

        public int getIndex(int idx) {
            if (idx >= count) return -1;
            long m = (pm[count] * ArithmeticHelper.powerMode(pm[idx], MODE-2, MODE)) % MODE;
            long a = (pa[count] - pa[idx] * m) % MODE + MODE;
            return (int) ((data[idx] * m + a) % MODE);
        }
    }
}
