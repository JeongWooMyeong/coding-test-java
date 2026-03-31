package 이것이코딩테스트다2.기출문제.정렬;

import java.util.*;
import java.io.*;

/*

너무 어렵게 생각했나..
이렇게 하면 시간 초과 뜸

 */

public class 안테나 {
    static int N;
    static ArrayList<Ante> list = new ArrayList<>();
    static int[] map;

    static class Ante implements Comparable<Ante>{
        int idx;
        int dist;

        public Ante(int idx, int dist){
            this.idx = idx;
            this.dist = dist;
        }

        public int compareTo(Ante other){
            if(this.dist == other.dist) return this.idx - other.idx;
            return this.dist - other.dist;
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        map = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            map[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(map);

        PriorityQueue<Ante> pq = new PriorityQueue<>();
        for(int i=0;i<N;i++){
            int dist = 0;
            for(int j=0;j<N;j++){
                if(i != j){
                    dist += Math.abs(map[i] - map[j]);
                }
            }
            pq.add(new Ante(i, dist));
        }

        Ante result = pq.poll();

        System.out.println(map[result.idx]);

    }


}
