package 백준.골드.level4;

import java.io.*;
import java.util.*;

public class 이차원배열과연산 {
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
                System.out.println(time);
                return;
            }
            if(rowSize >= colSize){
                operationR();
            }else{
                operationC();
            }
            time++;
        }
        System.out.println(-1);
    }

    static void operationR(){
        int newColSize = 0;
        for(int i=1;i<=rowSize;i++){
            Map<Integer, Integer> countMap = new HashMap<>();
            for(int j=1;j<=colSize;j++){
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
                int[] pair = pq.poll();
                A[i][idx++] = pair[0];
                if(idx > 100) break;
                A[i][idx++] = pair[1];
            }
            newColSize = Math.max(newColSize, idx - 1);
            for(;idx<=100;idx++) A[i][idx] = 0;
        }
        colSize = newColSize;
    }

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
                int[] pair = pq.poll();
                A[idx++][j] = pair[0];
                if(idx > 100) break;
                A[idx++][j] = pair[1];
            }
            newRowSize = Math.max(newRowSize, idx - 1);
            for(; idx <= 100; idx++) A[idx][j] = 0;


        }
        rowSize = newRowSize;
    }

}
