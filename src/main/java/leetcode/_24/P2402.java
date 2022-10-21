package leetcode._24;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.TreeMap;
import java.util.TreeSet;

public class P2402 {
    private static final int MAX_ROOM = 101;
    private static final int MAX_MEETING = 100001;

    private enum EventType {
        NEW_MEETING,
        END_OF_MEETING
    }

    private static class Event {
        private EventType event_type;
        private int meetingId;
        private int roomId;

        public Event(EventType event_type, int meetingId, int roomId) {
            this.event_type = event_type;
            this.meetingId = meetingId;
            this.roomId = roomId;
        }

        public EventType getEvent_type() {
            return event_type;
        }

        public void setEvent_type(EventType event_type) {
            this.event_type = event_type;
        }

        public int getMeetingId() {
            return meetingId;
        }

        public void setMeetingId(int meetingId) {
            this.meetingId = meetingId;
        }

        public int getRoomId() {
            return roomId;
        }

        public void setRoomId(int roomId) {
            this.roomId = roomId;
        }
    };

    public int mostBooked(int n, int[][] meetings) {
        int [] count = new int [n];

        TreeSet<Integer> availableRooms = new TreeSet<>();
        for (int i=0;i<n;++i) availableRooms.add(i);

        TreeMap<Long , List<Event>> moments = new TreeMap<>();
        for (int i=0;i<meetings.length;++i) {
            List<Event> list = new LinkedList<>();
            list.add(new Event(EventType.NEW_MEETING, i, -1));
            moments.put((long) meetings[i][0], list);
        }

        Queue<Integer> pendingMeetings = new LinkedList<>();

        Long curTime;
        while (!moments.isEmpty()) {
            curTime = moments.firstEntry().getKey();
            List<Event> list = moments.firstEntry().getValue();
            moments.remove(moments.firstKey());

            list.stream().filter(e -> e.event_type == EventType.END_OF_MEETING).forEach(e->{
                availableRooms.add(e.roomId);
            });

            while (!availableRooms.isEmpty() && !pendingMeetings.isEmpty()) {
                int meetingId = pendingMeetings.poll();
                int roomId = availableRooms.first();
                availableRooms.remove(roomId);
                ++count[roomId];

                long nextMoment = curTime + meetings[meetingId][1] - meetings[meetingId][0];
                Event nextEvent = new Event(EventType.END_OF_MEETING, meetingId, roomId);
                if (moments.containsKey(nextMoment)) {
                    moments.get(nextMoment).add(nextEvent);
                }
                else {
                    moments.put(nextMoment, new LinkedList<>(Arrays.asList(nextEvent)));
                }
            }

            for (Event event : list){
                if (event.event_type == EventType.NEW_MEETING) {
                    if (availableRooms.isEmpty()) {
                        pendingMeetings.add(event.meetingId);
                    }
                    else {
                        int room = availableRooms.first();
                        availableRooms.remove(room);
                        ++count[room];

                        long nextMoment = curTime + meetings[event.meetingId][1] - meetings[event.meetingId][0];
                        Event nextEvent = new Event(EventType.END_OF_MEETING, event.meetingId, room);
                        if (moments.containsKey(nextMoment)) {
                            moments.get(nextMoment).add(nextEvent);
                        }
                        else {
                            moments.put(nextMoment, new LinkedList<>(Arrays.asList(nextEvent)));
                        }
                    }
                }
            }
        }

        return getMostBookedRoom(count);
    }

    private int getMostBookedRoom(int [] count) {
        int result = 0;
        for (int i=1; i<count.length; ++i)  {
            if (count[i] > count[result]) result = i;
        }
        return result;
    }
}
