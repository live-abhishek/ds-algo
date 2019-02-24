package leetcode;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

public class CanVisitAllRooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] roomState = new boolean[rooms.size()];
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(0);
        roomState[0] = true;
        while (!q.isEmpty()) {
            Integer currRoom = q.poll();
            List<Integer> visitableRooms = rooms.get(currRoom);
            for (int visitableRoom : visitableRooms) {
                if (roomState[visitableRoom] == false) {
                    q.offer(visitableRoom);
                    roomState[visitableRoom] = true;
                }
            }
        }
        for (int i = 0; i < roomState.length; i++) {
            if (roomState[i] == false) {
                return false;
            }
        }
        return true;
    }
}
