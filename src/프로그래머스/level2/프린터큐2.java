package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 프린터큐2 {

    static int T,N,M;
    static Deque<Doc> dq;
    static ArrayList<Integer> resultList;

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

        T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while(T-- > 0){
            dq = new ArrayDeque<>();
            resultList = new ArrayList<>();

            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for(int i=0;i<N;i++){
                dq.addLast(new Doc(Integer.parseInt(st.nextToken()),i));
            }

            if(dq.size() == 1){
                sb.append(1).append("\n");
                continue;
            }

            while(!dq.isEmpty()){
                Doc cur = dq.poll();
                int now = cur.priority;
                int idx = cur.idx;
                boolean found = false;
                for(Doc d : dq){
                    if(now < d.priority){
                        found = true;
                        dq.addLast(cur);
                        break;
                    }
                }

                if(!found) resultList.add(idx);

            }


            for(int i=0;i<resultList.size();i++){
                if(resultList.get(i) == M){
                    sb.append(i+1).append("\n");
                }
            }

        }

        System.out.println(sb.toString());
    }

}
