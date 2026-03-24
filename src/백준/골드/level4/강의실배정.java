package 백준.골드.level4;

import java.util.*;
import java.io.*;

public class 강의실배정 {
    static int N;
    static ArrayList<Class> list = new ArrayList<>();

    static class Class implements Comparable<Class>{
        private int start;
        private int end;


        public Class(int start, int end){
            this.start = start;
            this.end = end;
        }

        public int getStart(){
            return this.start;
        }

        public int getEnd(){
            return this.end;
        }

        public int compareTo(Class other){
            if(this.start == other.start) return this.end - other.end;
            return this.end - other.end;
        }

    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            list.add(new Class(start, end));
        }

        Collections.sort(list);

//        int count = 0;
//        int prev = 0;
//        for(int i=0;i<N;i++){
//            Class c1 = list.get(i);
//            prev = c1.getEnd();
//            for(int j=i;j<N;j++){
//                Class c2 = list.get(j);
//                if(prev == c2.getStart()){
//                    prev = c2.getEnd();
//                }else{
//                    count++;
//                }
//            }
//        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(list.get(0).getEnd());

        for(int i=1;i<N;i++){
            if(pq.peek() <= list.get(i).getStart()){
                pq.poll();
            }
            pq.add(list.get(i).getEnd());
        }

        System.out.print(pq.size());

    }

}
