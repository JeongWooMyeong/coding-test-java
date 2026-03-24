package 백준.골드.level5;

import java.util.*;
import java.io.*;

/*

이거는 두개만 계산하므로 DP w점화식 세워서 해야함
 */

public class 평범한배낭2 {
    static int N, K;
    static ArrayList<Bags> list = new ArrayList<>();


    static class Bags implements Comparable<Bags>{
        private int w;
        private int v;

        public Bags(int w, int v){
            this.w = w;
            this.v = v;
        }

        public int getW(){
            return this.w;
        }

        public int getV(){
            return this.v;
        }

        public int compareTo(Bags other){
            if(this.w == other.w) return other.v - this.v;
            return this.w - other.w;
        }

    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            list.add(new Bags(w, v));
        }

        Collections.sort(list);
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int i=0;i<N;i++){
            for(int j=i;j<N;j++){
                if(list.get(i).getW() + list.get(j).getW() <= K){
                    pq.add(list.get(i).getV() + list.get(j).getV());
                }
            }
        }

        System.out.println(pq.poll());

    }
}
