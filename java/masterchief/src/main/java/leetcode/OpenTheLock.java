package leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Queue;

public class OpenTheLock {
    static class QueueItem {
        int d;
        String val;

        QueueItem(String val, int d) {
            this.val = val;
            this.d = d;
        }
    }
    public int openLock(String[] deadends, String target) {
        HashSet<String> deadendSet = new HashSet<>(Arrays.asList(deadends));
        HashSet<String> visited = new HashSet<>();
        Queue<QueueItem> queue = new ArrayDeque<>();
        QueueItem start = new QueueItem("0000", 0);
        queue.add(start);
        visited.add(start.val);
        while (!queue.isEmpty()) {
            QueueItem curr = queue.poll();
            if (!deadendSet.contains(curr.val)) {
                if (curr.val.equals(target)) {
                    return curr.d;
                }
                for (int i = 0; i < 4; i++) {
                    String nextVal = getNextVal(curr.val, i);
                    if (!deadendSet.contains(nextVal) && !visited.contains(nextVal)) {
                        visited.add(nextVal);
                        queue.add(new QueueItem(nextVal, curr.d + 1));
                    }
                    String prevVal = getPrevVal(curr.val, i);
                    if (!deadendSet.contains(prevVal) && !visited.contains(prevVal)) {
                        visited.add(prevVal);
                        queue.add(new QueueItem(prevVal, curr.d + 1));
                    }
                }
            }
        }
        return -1;
    }

    private String getNextVal(String val, int i) {
        char c = val.charAt(i);
        return val.substring(0, i) + (c == '9' ? '0' : (char) (c + 1)) + val.substring(i + 1);
    }

    private String getPrevVal(String val, int i) {
        char c = val.charAt(i);
        return val.substring(0, i) + (c == '0' ? '9' : (char) (c - 1)) + val.substring(i + 1);
    }
}
