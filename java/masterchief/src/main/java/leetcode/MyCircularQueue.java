package leetcode;

public class MyCircularQueue {
    int[] arr;
    int head = 0;
    int tail = 0;
    int numElements = 0;

    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        this.arr = new int[k];
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if(isFull())
            return false;
        this.arr[tail++] = value;
        tail %= this.arr.length;
        numElements++;
        return true;
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if(isEmpty())
            return false;
        head++;
        head %= this.arr.length;
        numElements--;
        return true;
    }

    /** Get the front item from the queue. */
    public int Front() {
        if(isEmpty())
            return -1;
        return this.arr[head];
    }

    /** Get the last item from the queue. */
    public int Rear() {
        if(isEmpty())
            return -1;
        return this.arr[(tail - 1 + this.arr.length) % this.arr.length];
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return numElements == 0;
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return numElements == this.arr.length;
    }

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
}
