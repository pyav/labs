/**
 * https://leetcode.com/problems/meeting-rooms-iii/description/
 *
 * Output:
 * ------
 * 0
 * 1
 * 0
 */

import java.util.*;

public class MeetingRoomsIII {
    class Node {
        long endTime;
        int roomId;

        public Node(long endTime, int roomId) {
            this.endTime = endTime;
            this.roomId = roomId;
        }
    }

    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));

        int[] count = new int[n];
        PriorityQueue<Integer> availableRooms = new PriorityQueue<>();
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> {
            if (a.endTime != b.endTime) {
                return Long.compare(a.endTime, b.endTime);
            }
            return Integer.compare(a.roomId, b.roomId);
        });

        for (int[] meeting : meetings) {
            int startTime = meeting[0];
            int endTime = meeting[1];

            while (!pq.isEmpty() && pq.peek().endTime <= startTime) {
                Node node = pq.poll();
                availableRooms.offer(node.roomId);
            }

            if (pq.size() < n) {
                int roomId = availableRooms.isEmpty() ? pq.size() : availableRooms.poll();
                count[roomId]++;
                pq.offer(new Node(endTime, roomId));
            } else {
                Node earliest = pq.poll();
                count[earliest.roomId]++;
                pq.offer(new Node(earliest.endTime + (endTime - startTime), earliest.roomId));
            }
        }

        int maxRoom = 0;
        for (int i = 1; i < n; i++) {
            if (count[i] > count[maxRoom]) {
                maxRoom = i;
            }
        }

        return maxRoom;
    }

    public static void main(String[] args) {
        System.out.println(new MeetingRoomsIII().mostBooked(2, new int[][]{{0, 10}, {1, 5}, {2, 7}, {3, 4}}));
        System.out.println(new MeetingRoomsIII().mostBooked(3, new int[][]{{0, 10}, {1, 5}, {2, 7}, {3, 4}}));
        System.out.println(new MeetingRoomsIII().mostBooked(3, new int[][]{{13, 20}, {5, 17}, {17, 19}}));
    }
}

