package 백준.골드.level5;

import java.util.*;
import java.io.*;

/*
시간초과
 */

public class 회의실배정2 {
    static int N;
    static ArrayList<Room> edges = new ArrayList<>();
    static int result = 0;

    static class Room implements Comparable<Room>{
        private int start;
        private int end;

        public Room(int start, int end){
            this.start = start;
            this.end = end;
        }

        public int getStart(){
            return this.start;
        }

        public int getEnd(){
            return this.end;
        }

        public int compareTo(Room other){
            if(this.end == other.end) return this.start - other.start;
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

            edges.add(new Room(start, end));
        }

        Collections.sort(edges);

        int count = 0;  //방 하나 선택됐음

        for(int i=0;i<edges.size();i++){
            result = Math.max(result, count);
            count = 1;
            int end = edges.get(i).getEnd();

            for(int j=i+1;j<edges.size();j++){
                if(end <= edges.get(j).getStart()){
                    end = edges.get(j).getEnd();
                    count++;
                }
            }
        }

        System.out.println(result);

    }

}
