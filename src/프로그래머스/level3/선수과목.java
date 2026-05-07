package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 선수과목 {
    static ArrayList<ArrayList<Integer>> edges;
    static int[] indegree;
    static int n,m;
    static ArrayList<Integer> result;
    static int[] semester;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        indegree = new int[n+1];
        Arrays.fill(indegree, 0);
        edges = new ArrayList<>();
        result = new ArrayList<>();
        semester = new int[n+1];

        for(int i=0;i<=n;i++){
            edges.add(new ArrayList<>());
        }

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            edges.get(a).add(b);

            indegree[b] += 1;
        }

        topology_sort();

        StringBuilder sb = new StringBuilder();
        for(int i=1;i<=n;i++){
            sb.append(semester[i]).append(" ");
        }

        System.out.println(sb.toString());

    }

    static void topology_sort(){
        Queue<Integer> q = new LinkedList<>();
        //semester = new int[n+1];

        for(int i=1;i<=n;i++){
            if(indegree[i] == 0){
                q.offer(i);
                semester[i] = 1;
            }
        }

        while(!q.isEmpty()){
            int now = q.poll();
            result.add(now);
            for(int i=0;i<edges.get(now).size();i++){
                int next = edges.get(now).get(i);
                indegree[next] -= 1;
                //next 과목은 now 과목 이후에 들을 수 있으므로 학기 갱신
                semester[next] = Math.max(semester[next], semester[now]+1);
                if(indegree[next] == 0){
                    q.offer(next);
                }
            }
        }

    }

}
