package 백준.골드.level4;

import java.util.*;
import java.io.*;

public class 이차원배열과연산2 {
    static int r, c, k;
    static int[][] A = new int[101][101];
    static int rowSize = 3, colSize = 3;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        for(int i=1;i<=3;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1;j<=3;j++){
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int time = 0;
        while(time <= 100){
            if(A[r][c] == k){
                System.out.print(time);
                return;
            }else if(rowSize >= colSize){
                operationR();
            }else{
                operationC();
            }
            time++;
        }

        System.out.print(-1);
    }

    //R 연산
    static void operationR(){
        int newColSize = 0;
       for(int i=1;i<=rowSize;i++){
           Map<Integer, Integer> countMap = new HashMap<>();
           //카운트 맵 (같은 숫자)
           for(int j=1;j<=colSize;j++){
               if(A[i][j] == 0) continue;
               countMap.put(A[i][j], countMap.getOrDefault(A[i][j], 0) + 1);
           }
           PriorityQueue<int[]> pq = new PriorityQueue<>(
                   (a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]
           );
           //우선순위 큐에 키와 카운트 담기
           for(int key : countMap.keySet()){
               pq.add(new int[]{key, countMap.get(key)});
           }
           //100이하까지 배열 담기 (배열을 애초부터 101까지 잡으면 되는구나..)
           int idx = 1;
           while(!pq.isEmpty() && idx <= 100){
               int[] p = pq.poll();
               A[i][idx++] = p[0];
               if(idx > 100) break;
               A[i][idx++] = p[1];
           }

           newColSize = Math.max(newColSize, idx - 1);
           for(;idx<=100;idx++) A[i][idx] = 0;

       }

       colSize = newColSize;

    }

    //C연산
    static void operationC(){
        int newRowSize = 0;
        for(int j=1;j<=colSize;j++){
            Map<Integer, Integer> countMap = new HashMap<>();
            for(int i=1;i<=rowSize;i++){
                if(A[i][j] == 0) continue;
                countMap.put(A[i][j], countMap.getOrDefault(A[i][j], 0) + 1);
            }

            PriorityQueue<int[]> pq = new PriorityQueue<>(
                    (a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]
            );

            for(int key : countMap.keySet()){
                pq.add(new int[]{key, countMap.get(key)});
            }

            int idx = 1;
            while(!pq.isEmpty() && idx <= 100){
                int[] p = pq.poll();
                A[idx++][j] = p[0];
                if(idx > 100) break;
                A[idx++][j] = p[1];
            }
            newRowSize = Math.max(newRowSize, idx - 1);
            for(;idx<=100;idx++) A[idx][j] = 0;
        }

        rowSize = newRowSize;

    }

}
