package leetcode;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {
    static class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> result = new ArrayList<>();
        int i = 0;
        while (i < intervals.size() && intervals.get(i).end < newInterval.start) {
            result.add(intervals.get(i));
            i++;
        }
        Interval midInterval = new Interval(newInterval.start, newInterval.end);
        while (i < intervals.size() && intervals.get(i).start <= newInterval.end) {
            midInterval.start = Integer.min(midInterval.start, intervals.get(i).start);
            midInterval.end = Integer.max(midInterval.end, intervals.get(i).end);
            i++;
        }
        result.add(midInterval);
        while (i < intervals.size()) {
            result.add(intervals.get(i++));
        }
        return result;
    }
}
