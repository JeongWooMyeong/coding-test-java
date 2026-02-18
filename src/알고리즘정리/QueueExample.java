package 알고리즘정리;

import java.util.*;

public class QueueExample {
    public static void main(String[] args){
        Queue<Integer> queue = new LinkedList<>();

        //offer (enqueue)
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        //peek
        System.out.println("Front element: " + queue.peek());   //1

        //poll dequeue
        System.out.println("Poll: " + queue.poll());    //1
        System.out.println("Poll: " + queue.poll());    //2

        //empty check
        System.out.println("Is empty? " + queue.isEmpty()); //false
    }
}
