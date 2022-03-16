package Design;

import java.util.Deque;
import java.util.LinkedList;

//

public class BlockingQueue {


    Deque<Integer> deque;

    int capacity ;

    public BlockingQueue(int capacity) {
        this.capacity = capacity;
        deque = new LinkedList<>();
    }

    public void enqueue(int element) throws InterruptedException {
        synchronized(this){
            while(deque.size() == capacity){
                wait();
            }
            deque.addFirst(element);
            notifyAll();
        }


    }

    public int dequeue() throws InterruptedException {
        synchronized(this){
            while(deque.size() == 0){
                wait();
            }
            notifyAll();
            return deque.removeLast();
        }

    }

    public int size() {
        return deque.size();
    }


}
