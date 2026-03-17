package 백준.골드.level2;

import java.util.*;
import java.io.*;

public class 보석도둑2 {
    static int N, K;
    static ArrayList<jewel> jewels = new ArrayList<>();
    static int[] bags;

    static class jewel implements Comparable<jewel>{
        private int m;
        private int v;

        public jewel(int m, int v){
            this.m = m;
            this.v = v;
        }

        public int getM(){
            return this.m;
        }

        public int getV(){
            return this.v;
        }

        public int compareTo(jewel other){
            if(this.m == other.m){
                return other.v - this.v;
            }

            return this.m - other.m;
        }

    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());   //보석 개수
        K = Integer.parseInt(st.nextToken());   //가방 개수

        bags = new int[K];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            jewels.add(new jewel(m, v));
        }

        for(int i=0;i<K;i++){
            bags[i] = Integer.parseInt(br.readLine());
        }

        Collections.sort(jewels);
        Arrays.sort(bags);


        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        int idx = 0;
        //값의 범위가 300조 이므로 int로 담을 수 없음
        long result = 0;
        for(int k=0;k<K;k++){
            while(idx < N &&  jewels.get(idx).getM() <= bags[k]){
                pq.offer(jewels.get(idx).getV());
                idx++;
            }

            if(!pq.isEmpty()){
                result += pq.poll();
            }
        }

        System.out.println(result);

    }
}
