package 백준.실버.level3;

import java.util.*;
import java.io.*;

public class 주유소 {
    static int N;
    static long[] dist;
    static long[] cities;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        cities = new long[N];
        dist = new long[N-1];

        //간선 정보
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N-1;i++){
            dist[i] = Long.parseLong(st.nextToken());
        }

        //도시 정보
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            cities[i] = Long.parseLong(st.nextToken());
        }

        long result = 0;
        long minCost = cities[0];

        for(int i=0;i<N-1;i++){
            if(cities[i] < minCost){
                minCost = cities[i];
            }
            result += minCost * dist[i];
        }

        System.out.print(result);

    }

}
