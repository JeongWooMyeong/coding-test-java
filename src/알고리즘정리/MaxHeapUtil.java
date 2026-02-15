package 알고리즘정리;

import java.util.*;

public class MaxHeapUtil {
    public static void main(String[] args){
        //Collections.reverseOrder()로 최대 힙 구현
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        maxHeap.offer(5);
        maxHeap.offer(3);
        maxHeap.offer(8);
        maxHeap.offer(1);

        while(!maxHeap.isEmpty()){
            System.out.println(maxHeap.poll());
        }
    }
}
