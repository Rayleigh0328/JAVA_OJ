package leetcode._24;

import java.util.ArrayList;
import java.util.Collections;

public class P2432 {

    private static class Record implements Comparable<Record> {
        int empId;
        int workTime;

        public Record(int empId, int workTime) {
            this.empId = empId;
            this.workTime = workTime;
        }

        @Override
        public int compareTo(Record o) {
           if (workTime > o.workTime) return -1;
           if (workTime < o.workTime) return 1;
           if (empId < o.empId) return -1;
           if (empId > o.empId) return 1;
           return 0;
        }
    }

    public int hardestWorker(int n, int[][] logs) {
        ArrayList<Record> a = new ArrayList();
        for (int i=0;i<n;++i) a.add(new Record(i, 0));
        int cur = 0;
        for (int [] log : logs) {
            a.get(log[0]).workTime = Math.max(a.get(log[0]).workTime, log[1] - cur);
            cur = log[1];
        }
        Collections.sort(a);
        return a.get(0).empId;
    }
}
