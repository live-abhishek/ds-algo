package codingInterview.mergeIntervals;

import java.util.*;

public class EmployeeFreeTime {

    private static class Interval {
        int start;
        int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    private static class EmployeeInterval {
        Interval interval;
        int employeeIndex;
        int intervalIndex;

        public EmployeeInterval(Interval interval, int employeeIndex, int intervalIndex) {
            this.interval = interval;
            this.employeeIndex = employeeIndex;
            this.intervalIndex = intervalIndex;
        }
    }

    public static List<Interval> findEmployeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> result = new ArrayList<>();
        PriorityQueue<EmployeeInterval> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a.interval.start));
        for (int i = 0; i < schedule.size(); i++) {
            minHeap.offer(new EmployeeInterval(schedule.get(i).get(0), i, 0));
        }
        EmployeeInterval previousEmployeeInterval = minHeap.peek();
        while (!minHeap.isEmpty()) {
            EmployeeInterval topEmployeeInterval = minHeap.poll();
            if (previousEmployeeInterval.interval.end < topEmployeeInterval.interval.start) {
                result.add(new Interval(previousEmployeeInterval.interval.end, topEmployeeInterval.interval.start));
                previousEmployeeInterval = topEmployeeInterval;
            } else {
                if(previousEmployeeInterval.interval.end < topEmployeeInterval.interval.end){
                    previousEmployeeInterval = topEmployeeInterval;
                } else {
                    // do nothing
                }
            }
            List<Interval> intervals = schedule.get(topEmployeeInterval.employeeIndex);
            if (topEmployeeInterval.intervalIndex < intervals.size() - 1) {
                minHeap.offer(new EmployeeInterval(
                        intervals.get(topEmployeeInterval.intervalIndex + 1),
                        topEmployeeInterval.employeeIndex,
                        topEmployeeInterval.intervalIndex + 1));
            }
        }
        return result;
    }

    public static void main(String[] args) {

        List<List<Interval>> input = new ArrayList<>();
        input.add(new ArrayList<Interval>(Arrays.asList(new Interval(1, 3), new Interval(5, 6))));
        input.add(new ArrayList<Interval>(Arrays.asList(new Interval(2, 3), new Interval(6, 8))));
        List<Interval> result = EmployeeFreeTime.findEmployeeFreeTime(input);
        System.out.print("Free intervals: ");
        for (Interval interval : result)
            System.out.print("[" + interval.start + ", " + interval.end + "] ");
        System.out.println();

        input = new ArrayList<>();
        input.add(new ArrayList<Interval>(Arrays.asList(new Interval(1, 3), new Interval(9, 12))));
        input.add(new ArrayList<Interval>(Arrays.asList(new Interval(2, 4))));
        input.add(new ArrayList<Interval>(Arrays.asList(new Interval(6, 8))));
        result = EmployeeFreeTime.findEmployeeFreeTime(input);
        System.out.print("Free intervals: ");
        for (Interval interval : result)
            System.out.print("[" + interval.start + ", " + interval.end + "] ");
        System.out.println();

        input = new ArrayList<>();
        input.add(new ArrayList<Interval>(Arrays.asList(new Interval(1, 3))));
        input.add(new ArrayList<Interval>(Arrays.asList(new Interval(2, 4))));
        input.add(new ArrayList<Interval>(Arrays.asList(new Interval(3, 5), new Interval(7, 9))));
        result = EmployeeFreeTime.findEmployeeFreeTime(input);
        System.out.print("Free intervals: ");
        for (Interval interval : result)
            System.out.print("[" + interval.start + ", " + interval.end + "] ");
    }
}
