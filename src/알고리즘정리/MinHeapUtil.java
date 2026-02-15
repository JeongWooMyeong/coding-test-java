package 알고리즘정리;

import java.util.*;

public class MinHeapUtil {
    public static void main(String[] args){
        //기본 PriorityQueue는 최소 힙
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        minHeap.offer(5);
        minHeap.offer(3);
        minHeap.offer(8);
        minHeap.offer(1);

        while(!minHeap.isEmpty()){
            System.out.println(minHeap.poll());
        }
    }
}
