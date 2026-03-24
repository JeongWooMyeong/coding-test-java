package 백준.골드.level4;

import java.util.*;
import java.io.*;

public class 강의실배정2 {
    static int N;
    static int[] start;
    static int[] end;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        start = new int[N];
        end = new int[N];

        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            start[i] = Integer.parseInt(st.nextToken());
            end[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(start);
        Arrays.sort(end);

        int room = 0;
        int endIdx = 0;

        for(int i=0;i<N;i++){
            if(start[i] < end[endIdx]){
                room++;
            }else{
                endIdx++;
            }
        }

        System.out.print(room);

    }

}
