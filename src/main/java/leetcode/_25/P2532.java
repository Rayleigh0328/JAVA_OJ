package leetcode._25;

import java.util.TreeMap;
import java.util.TreeSet;

public class P2532 {

    private static final class Worker implements Comparable<Worker>{
        private int number;
        private int leftToRight;
        private int pickOld;
        private int rightToLeft;
        private int putNew;

        public Worker(int number, int leftToRight, int pickOld, int rightToLeft, int putNew) {
            this.number = number;
            this.leftToRight = leftToRight;
            this.pickOld = pickOld;
            this.rightToLeft = rightToLeft;
            this.putNew = putNew;
        }

        public int getNumber() {
            return number;
        }

        public int getLeftToRight() {
            return leftToRight;
        }

        public int getPickOld() {
            return pickOld;
        }

        public int getRightToLeft() {
            return rightToLeft;
        }

        public int getPutNew() {
            return putNew;
        }

        @Override
        public int compareTo(Worker o) {
            if (this.leftToRight + this.rightToLeft < o.leftToRight + o.rightToLeft) return -1;
            if (this.leftToRight + this.rightToLeft > o.leftToRight + o.rightToLeft) return 1;
            return Integer.compare(this.number, o.number);
        }
    }

    private enum EventType {
        START_LEFT_TO_RIGHT,
        FINISH_LEFT_TO_RIGHT,
        READY_RIGHT,
        START_RIGHT_TO_LEFT,
        FINISH_RIGHT_TO_LEFT,
        READY_LEFT;
    }

    private static final class Event {
        private EventType eventType;
        private Worker worker;
        private int timestamp;

        public Event(EventType eventType, Worker worker, int timestamp) {
            this.eventType = eventType;
            this.worker = worker;
            this.timestamp = timestamp;
        }

        public EventType getEventType() {
            return eventType;
        }

        public Worker getWorker() {
            return worker;
        }

        public int getTimestamp() {
            return timestamp;
        }
    }

    public int findCrossingTime(int n, int k, int[][] time) {
        TreeSet<Worker> leftSet = new TreeSet<>();
        TreeSet<Worker> rightSet = new TreeSet<>();
        for (int i=0;i<k;++i) {
            leftSet.add(new Worker(i, time[i][0], time[i][1], time[i][2], time[i][3]));
        }
        TreeMap<Integer, Event> timeline = new TreeMap<>();
        int finishedCount = 0;
        int curTime = 0;
        while (finishedCount < n) {

        }
        return curTime;
    }

}
