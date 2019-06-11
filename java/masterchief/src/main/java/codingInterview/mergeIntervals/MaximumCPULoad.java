package codingInterview.mergeIntervals;

import java.util.*;

public class MaximumCPULoad {

    private static class Job {
        int start;
        int end;
        int cpuLoad;

        public Job(int start, int end, int cpuLoad) {
            this.start = start;
            this.end = end;
            this.cpuLoad = cpuLoad;
        }
    }

    public static int findMaxCPULoad(List<Job> jobs) {
        int maxLoad = 0, currLoad = 0;
        jobs.sort(Comparator.comparingInt(a -> a.start));
        PriorityQueue<Job> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a.end));
        for (Job job : jobs) {
            while (!minHeap.isEmpty() && job.start > minHeap.peek().end) {
                currLoad -= minHeap.poll().cpuLoad;
            }
            currLoad += job.cpuLoad;
            maxLoad = Integer.max(maxLoad, currLoad);
            minHeap.offer(job);
        }
        return maxLoad;
    }

    public static void main(String[] args) {
        List<Job> input = new ArrayList<Job>(Arrays.asList(new Job(1, 4, 3), new Job(2, 5, 4), new Job(7, 9, 6)));
        System.out.println("Maximum CPU load at any time: " + MaximumCPULoad.findMaxCPULoad(input));

        input = new ArrayList<Job>(Arrays.asList(new Job(6, 7, 10), new Job(2, 4, 11), new Job(8, 12, 15)));
        System.out.println("Maximum CPU load at any time: " + MaximumCPULoad.findMaxCPULoad(input));

        input = new ArrayList<Job>(Arrays.asList(new Job(1, 4, 2), new Job(2, 4, 1), new Job(3, 6, 5)));
        System.out.println("Maximum CPU load at any time: " + MaximumCPULoad.findMaxCPULoad(input));

        input = new ArrayList<Job>(Arrays.asList(new Job(1, 4, 1), new Job(3, 8, 1), new Job(5, 10, 1)));
        System.out.println("Maximum CPU load at any time: " + MaximumCPULoad.findMaxCPULoad(input));
    }
}
