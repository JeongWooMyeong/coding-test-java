package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 문자열집합2 {

    static int N,M;
    static Set<String> set;
    static int answer;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        answer = 0;
        set = new HashSet<>();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i=0;i<N;i++){
            set.add(br.readLine());
        }

        for(int i=0;i<M;i++){
            String target = br.readLine();

            if(set.contains(target)) answer++;

        }

        System.out.println(answer);

    }

}
