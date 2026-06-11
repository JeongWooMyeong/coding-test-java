package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 프린터큐 {

    static int T;
    static int N,M;
    static ArrayList<Doc> resultList;

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
            resultList = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            Deque<Doc> q = new ArrayDeque<>();
            st = new StringTokenizer(br.readLine());
            for(int i=0;i<N;i++){
                q.addLast(new Doc(Integer.parseInt(st.nextToken()),i));
            }

            if(q.size() == 1){
                sb.append(1).append("\n");
                continue;
            }

            while(!q.isEmpty()){
                Doc cur = q.poll();
                int now = cur.priority;
                int index = cur.idx;
                boolean found = false;
                for(Doc next : q){
                    if(now < next.priority) {
                        q.addLast(cur);
                        found = true;
                        break;
                    }
                }

                if(!found) resultList.add(cur);

            }

            for(int i=0;i<resultList.size();i++){
                Doc cur = resultList.get(i);
                int idx = cur.idx;
                if(idx == M){
                    sb.append(i+1).append("\n");
                    break;
                }
            }

        }

        System.out.println(sb.toString());

    }

}
