package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 문자열집합3 {

    static int N,M;
    static Set<String> set;

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        set = new HashSet<>();

        for(int i=0;i<N;i++){
            set.add(br.readLine());
        }

        int answer = 0;

        for(int i=0;i<M;i++){
            if(set.contains(br.readLine())){
                answer++;
            }
        }

        System.out.println(answer);



    }

}
