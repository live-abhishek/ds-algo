package codingInterview.topKElements;

import java.util.Arrays;
import java.util.PriorityQueue;

class ConnectRopes {

    public static int minimumCostToConnectRopes(int[] ropeLengths) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        Arrays.stream(ropeLengths).forEach(i -> minHeap.offer(i));
        int cost = 0;
        while (minHeap.size() > 1) {
            Integer newLen = minHeap.poll() + minHeap.poll();
            cost += newLen;
            minHeap.offer(newLen);
        }
        return cost;
    }

    public static void main(String[] args) {
        int result = ConnectRopes.minimumCostToConnectRopes(new int[] { 1, 3, 11, 5 });
        System.out.println("Minimum cost to connect ropes: " + result);
        result = ConnectRopes.minimumCostToConnectRopes(new int[] { 1, 3, 11, 5, 2 });
        System.out.println("Minimum cost to connect ropes: " + result);
    }
}