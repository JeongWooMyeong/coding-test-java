package 알고리즘정리2;

import java.util.*;

/*
프린터 대기열
 */

public class QueueExample2 {
    public static int printerQueue(int[] priorities, int location){
        Queue<int[]> queue = new LinkedList<>();
        for(int i=0;i<priorities.length;i++){
            queue.add(new int[]{i, priorities[i]});
        }

        int order = 0;
        while(!queue.isEmpty()){
            int[] current = queue.poll();
            if(queue.stream().anyMatch(q -> q[1] > current[1])){
                queue.add(current);
            }else{
                order++;
                if(current[0] == location) return order;
            }
        }
        return -1;
    }

    public static void main(String[] args){
        int[] priorities= {2, 1, 3, 2};
        System.out.println(printerQueue(priorities, 2));
    }
}
