package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 최종순위2
{
    static int[] indegree;
    static ArrayList<ArrayList<Integer>> edges;
    static int T, n, m;
    static int[] lastRank;
    static StringBuilder sb;
    static ArrayList<Integer> resultList;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());

        while(T-- > 0){
            n = Integer.parseInt(br.readLine());    //팀 수
            edges = new ArrayList<>();
            for(int i=0;i<=n;i++){
                edges.add(new ArrayList<>());
            }
            indegree = new int[n+1];
            lastRank = new int[n];
            resultList = new ArrayList<>();

            st = new StringTokenizer(br.readLine());
            for(int i=0;i<n;i++){
                lastRank[i] = Integer.parseInt(st.nextToken());
            }
            //기존 간선 정보 입력
            for(int i=0;i<n;i++){
                for(int j=i+1;j<n;j++){
                    int a = lastRank[i];
                    int b = lastRank[j];

                    edges.get(a).add(b);
                    indegree[b] += 1;

                }
            }

            //새로운 순위 변동에 대한 해결
            m = Integer.parseInt(br.readLine());
            for(int i=0;i<m;i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                if(edges.get(a).contains(b)){
                    edges.get(a).remove(Integer.valueOf(b));
                    indegree[b] -= 1;
                    edges.get(b).add(a);
                    indegree[a] += 1;
                }else{
                    edges.get(b).remove(Integer.valueOf(a));
                    indegree[a] -= 1;
                    edges.get(a).add(b);
                    indegree[b] += 1;
                }

            }

            //위상 정렬 시행
            topology_sort();


        }

        System.out.println(sb.toString());


    }

    static void topology_sort(){
        Queue<Integer> q = new LinkedList<>();
        boolean certain = true;
        boolean cycle = false;
        for(int i=1;i<=n;i++){
            if(indegree[i] == 0){
                q.offer(i);
            }
        }


        while(!q.isEmpty()){
            //중간에 여러가지 후보가 생길 수 있어서 q돌면서 체큰
            if(q.size() > 1) certain=false;

            int now = q.poll();
            resultList.add(now);
            for(int i=0;i<edges.get(now).size();i++){
                int next = edges.get(now).get(i);
                indegree[next] -= 1;
                if(indegree[next] == 0){
                    q.offer(next);
                }
            }
        }

        if(resultList.size() != n) cycle = true;

        if(!certain){
            sb.append("?").append("\n");
        }else if(cycle){
            sb.append("IMPOSSIBLE").append("\n");
        }else{
            for(int x : resultList){
                sb.append(x).append(" ");
            }
            sb.append("\n");
        }


    }

}
