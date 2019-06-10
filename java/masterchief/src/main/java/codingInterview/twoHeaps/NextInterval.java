package codingInterview.twoHeaps;

import java.util.PriorityQueue;

public class NextInterval {
    private static class Interval {
        int start = 0;
        int end = 0;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }


    public static int[] findNextInterval(Interval[] intervals) {
        int[] result = new int[intervals.length];
        PriorityQueue<Integer> maxEndHeap = new PriorityQueue<>(intervals.length, (a, b) -> intervals[b].end - intervals[a].end);
        PriorityQueue<Integer> maxStartHeap = new PriorityQueue<>(intervals.length, (a, b) -> intervals[b].start - intervals[a].start);

        for (int i = 0; i < intervals.length; i++) {
            maxEndHeap.add(i);
            maxStartHeap.add(i);
        }

        while (!maxEndHeap.isEmpty()) {
            int topEndPos = maxEndHeap.poll();
            Interval topEndInterval = intervals[topEndPos];
            int topStartPos = -1;
            while(!maxStartHeap.isEmpty() && intervals[maxStartHeap.peek()].start >= topEndInterval.end){
                topStartPos = maxStartHeap.poll();
            }
            /*
            // one last check, just to confirm that we didn't came out
            // of the while loop because maxStartHeap got empty
            // and if that is the case we will not add any more intervals in maxStartHeap
            if(topStartPos >= 0 && intervals[topStartPos].start >= topEndInterval.end) {
                result[topEndPos] = topStartPos;
                maxStartHeap.add(topStartPos);
            } else {
                result[topEndPos] = -1;
            }
            */
            if (topStartPos != -1) {
                maxStartHeap.add(topStartPos);
            }
            result[topEndPos] = topStartPos;
        }
        return result;
    }

    public static void main(String[] args) {
        Interval[] intervals = new Interval[] { new Interval(2, 3), new Interval(3, 4), new Interval(5, 6) };
        int[] result = NextInterval.findNextInterval(intervals);
        System.out.print("Next interval indices are: ");
        for (int index : result)
            System.out.print(index + " ");
        System.out.println();

        intervals = new Interval[] { new Interval(3, 4), new Interval(1, 5), new Interval(4, 6) };
        result = NextInterval.findNextInterval(intervals);
        System.out.print("Next interval indices are: ");
        for (int index : result)
            System.out.print(index + " ");
    }
}
