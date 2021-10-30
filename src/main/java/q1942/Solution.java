package q1942;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 1942. The Number of the Smallest Unoccupied Chair<br/>
 * See <a herf="https://leetcode.com/problems/the-number-of-the-smallest-unoccupied-chair/">
 *       https://leetcode.com/problems/the-number-of-the-smallest-unoccupied-chair/
 *     </a><br/>
 */
public class Solution {

    public int smallestChair(int[][] times, int targetFriend) {
        int targetArrivalTime = times[targetFriend][0];

        Arrays.sort(times, Comparator.comparing(ints -> ints[0]));

        PriorityQueue<Leave> leaveQueue = new PriorityQueue<>();
        PriorityQueue<Integer> availableQueue = new PriorityQueue<>();
        int seatCount = 0;
        for (int[] time : times) {
            int currentTime = time[0];
            while (!leaveQueue.isEmpty() && leaveQueue.peek().leaveTime <= currentTime) {
                availableQueue.add(leaveQueue.poll().seatId);
            }
            //assign seat
            int seat;
            if (availableQueue.isEmpty()) {
                seat = seatCount++;
            } else {
                seat = availableQueue.poll();
            }
            if (currentTime == targetArrivalTime) {
                return seat;
            } else {
                leaveQueue.add(new Leave(time[1], seat));
            }
        }
        return 0;
    }

    private static class Leave implements Comparable<Leave> {
        final int leaveTime;
        final int seatId;

        Leave(int leaveTime, int seatId) {
            this.leaveTime = leaveTime;
            this.seatId = seatId;
        }

        @Override
        public int compareTo(Leave other) {
            return this.leaveTime - other.leaveTime;
        }
    }
}