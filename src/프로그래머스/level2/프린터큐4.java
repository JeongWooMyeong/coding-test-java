package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 프린터큐4 {

    static int T, N, M;
    static Deque<Doc> dq;
    static StringBuilder sb;

    static class Doc{
        int priority;
        int idx;

        public Doc(int priority, int idx){
            this.priority = priority;
            this.idx = idx;
        }

    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());

        while(T-- > 0){
            st = new StringTokenizer(br.readLine());
            dq = new ArrayDeque<>();
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for(int i=0;i<N;i++){
                dq.addLast(new Doc(Integer.parseInt(st.nextToken()), i));
            }

            int count = 0;
            while(!dq.isEmpty()){
                Doc cur = dq.pollFirst();
                boolean found = false;
                for(Doc d : dq){
                    if(cur.priority < d.priority){
                        dq.addLast(cur);
                        found = true;
                        break;
                    }
                }

                if(!found){
                    count++;
                    if(cur.idx == M){
                        sb.append(count).append("\n");
                        break;
                    }
                }

            }
        }

        System.out.println(sb.toString());

    }

}
