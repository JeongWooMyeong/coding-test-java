package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 여행경로5 {
    static List<List<String>> paths;
    static boolean[] visited;

    public static String[] solution(String[][] tickets){

        int n = tickets.length;
        paths = new ArrayList<>();
        visited = new boolean[n+1];

        List<String> path = new ArrayList<>();
        //ICN부터 시작
        path.add("ICN");

        dfs(0, "ICN", path, tickets);

        Collections.sort(paths, (a,b)->{
            for(int i=0;i<a.size();i++){
                if(!a.get(i).equals(b.get(i))) return a.get(i).compareTo(b.get(i));
            }
            return 0;
        });


        return paths.get(0).toArray(new String[0]);
    }

    static void dfs(int idx, String str, List<String> path, String[][] tickets){
        if(idx == tickets.length){
            paths.add(new ArrayList<>(path));

            return;
        }

        for(int i=0;i<tickets.length;i++){
            if(tickets[i][0].equals(str) && !visited[i]){
                visited[i] = true;
                path.add(tickets[i][1]);
                dfs(idx+1, tickets[i][1], path, tickets);
                visited[i] = false;
                path.remove(path.size()-1);
            }
        }

    }

    public static void main(String[] args) throws Exception{
        String[][] tickets = {{"ICN", "JFK"},{"HND","IAD"},{"JFK","HND"}};

        System.out.println(Arrays.toString(solution(tickets)));
    }

}
