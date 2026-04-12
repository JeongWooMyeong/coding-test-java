package 백준.골드.level3;

import java.util.*;
import java.io.*;

public class 순회강연 {
    static int n;
    static ArrayList<lecture> lectures = new ArrayList<>();

    static class lecture implements Comparable<lecture>{
        int pay;
        int day;

        public lecture(int pay, int day){
            this.pay = pay;
            this.day = day;
        }

        public int compareTo(lecture other){
            return this.day - other.day;
        }

    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            lectures.add(new lecture(p, d));
        }
        //강연일순으로 오름차순 정렬
         Collections.sort(lectures);
        // Collections.sort(lectures, (p1, p2) -> p1.day - p2.day);
        //Collections.sort(lectures, Comparator.comparingInt(p -> p.day));
        //Collections.sort(lectures, Comparator.comparingInt((lecture p) -> p.day).reversed());
        //일순으로 비용 담고 만약 담은 큐 사이즈가 해당 lecture day보다 크면 poll 빼버림 (비용 작은)
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(lecture lc : lectures){
            pq.add(lc.pay);
            if(pq.size() > lc.day) pq.poll();
        }

        int result = 0;
        while(!pq.isEmpty()){
            int pays = pq.poll();
            result += pays;
        }

        System.out.print(result);

    }

}
