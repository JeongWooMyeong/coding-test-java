package 백준.골드.level2;

import java.util.*;
import java.io.*;

public class 보석도둑 {
    static int n,k;
    static ArrayList<Edge> edges = new ArrayList<>();
    static int result = 0;
    static int[] bags;

    static class Edge implements Comparable<Edge>{
        private int m;
        private int v;

        public Edge(int m, int v){
            this.m = m;
            this.v = v;
        }

        public int getM(){
            return this.m;
        }

        public int getV(){
            return this.v;
        }

        public int compareTo(Edge other){
            if(this.m == other.m){
                return other.v - this.v;
            }
            return this.m - other.m;
        }

    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());   //보석의 개수
        k = Integer.parseInt(st.nextToken());   //가방의 개수

        bags = new int[k];

        for(int i=0;i<n;i++){
            //edges.add(new ArrayList<Edge>());
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            edges.add(new Edge(m, v));
        }

        for(int i=0;i<k;i++){
            int w = Integer.parseInt(br.readLine());
            bags[i] = w;
        }

        Collections.sort(edges);
        //후보군 누적관리 위함 (이건 생각 못함)
        Arrays.sort(bags);

//        for(int i=0;i<k;i++){
//            int bagsw = bags[i];
//            int finals = 0;
//            int finalindex = 0;
//            for(int j=0;j<n;j++){
//                int mw = edges.get(j).getM();
//                if(bagsw >= mw){
//                    finals = edges.get(j).getV();
//                    finalindex = j;
//                }
//                result += finals;
//                edges.remove(finalindex);
//            }
//        }
        //이거 생각 못함 (무언갈 뺄때에는 이걸 한번 생각해보자)
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        long result = 0;
        int idx = 0;

        for(int i=0;i<k;i++){
            //현재 가방에 담을 수 있는 보석 후보 추가
            while(idx < n && edges.get(idx).getM() <= bags[i]){
                pq.offer(edges.get(idx).getV());
                idx++;
            }
            //후보 중 가장 가치 큰 보석 선택
            if(!pq.isEmpty()){
                result += pq.poll();
            }
        }


        System.out.print(result);



    }
}
