package 프로그래머스.level3;

import java.util.*;
import java.io.*;

/*
모든 경로를 저장한건 아쉽다..?
미리 처음에 정렬했으니 처음만 찾아서 반환해도 답임
 */

public class 여행경로7 {
    static ArrayList<ArrayList<String>> paths;
    static boolean[] visited;

    public static String[] solution(String[][] tickets){
        Arrays.sort(tickets, (a,b)->a[0].equals(b[0]) ? a[1].compareTo(b[1]) : a[0].compareTo(b[0]));

        paths = new ArrayList<>();
        ArrayList<String> path = new ArrayList<>();
        path.add("ICN");
        visited = new boolean[tickets.length];
        dfs(0, "ICN",path,tickets);

        return paths.get(0).toArray(new String[0]);

    }

    static void dfs(int idx ,String start, ArrayList<String> path, String[][] tickets){
        if(idx == tickets.length){
            paths.add(new ArrayList<>(path));
            return;
        }

        for(int i=0;i<tickets.length;i++){
            if(!visited[i] && tickets[i][0].equals(start)){
                visited[i] = true;
                path.add(tickets[i][1]);
                dfs(idx+1, tickets[i][1], path, tickets);
                visited[i] = false;
                path.remove(path.size()-1);
            }
        }
    }

    public static void main(String[] args) throws Exception{
        String[][] tickets = {{"ICN","SFO"},{"ICN","ATL"},{"SFO", "ATL"},{"ATL","ICN"},{"ATL","SFO"}};

        System.out.println(Arrays.toString(solution(tickets)));
    }

}
