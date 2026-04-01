package 이것이코딩테스트다2.기출문제.그래프이론;

import java.util.*;
import java.io.*;

public class 최종순위 {
    static ArrayList<ArrayList<Integer>> graph;
    static int T, n, m;
    static int[] order;
    static int[] indegree;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        while(T-- > 0){
            n = Integer.parseInt(br.readLine());
            order = new int[n+1];
            graph = new ArrayList<>();
            indegree = new int[n+1];

            Arrays.fill(indegree, 0);

            st = new StringTokenizer(br.readLine());
            for(int i=1;i<=n;i++){
                order[i] = Integer.parseInt(st.nextToken());
            }
            for(int i=0;i<=n;i++){
                graph.add(new ArrayList<>());
            }

            //기존 순위 정하기
            for(int i=1;i<=n;i++){
                for(int j=(i+1);j<=n;j++){
                    graph.get(order[i]).add(order[j]);
                    indegree[order[j]] += 1;
                }
            }
            //변경된 순위 진입차수 변경
            m = Integer.parseInt(br.readLine());
            for(int i=0;i<m;i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                if(graph.get(a).contains(b)){
                    //Object 지정안해주면 remove에서 index로 인식하 수 있음
                    graph.get(a).remove(Integer.valueOf(b));
                    indegree[b] -= 1;
                    graph.get(b).add(a);
                    indegree[a] += 1;
                }else{
                    graph.get(b).remove(Integer.valueOf(a));
                    indegree[a] -= 1;
                    graph.get(a).add(b);
                    indegree[b] += 1;
                }
            }

            //위상정렬 시행
            Queue<Integer> q = new LinkedList<>();
            for(int i=1;i<=n;i++){
                if(indegree[i] == 0){
                    q.offer(i);
                }
            }
            ArrayList<Integer> result = new ArrayList<>();
            boolean cycle = false;
            boolean certain = true;

            for(int j=1;j<=n;j++){
                if(q.isEmpty()){
                    cycle =true;
                    break;
                }
                if(q.size() > 1){
                    certain = false;
                }
                int now = q.poll();
                result.add(now);
                for(int i=0;i<graph.get(now).size();i++){
                    int next = graph.get(now).get(i);
                    indegree[next]--;
                    if(indegree[next] == 0) q.offer(next);
                }
            }


            if(cycle) sb.append("IMPOSSIBLE").append("\n");
            else if(!certain) sb.append("?").append("\n");
            else{
                for(int x : result) sb.append(x).append(" ");
                sb.append("\n"); // 줄바꿈 추가
            }


        }

        System.out.print(sb);

    }
}
