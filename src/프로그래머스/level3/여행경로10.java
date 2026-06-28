package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 여행경로10 {

    static List<List<String>> paths;
    static boolean[] visited;
    static String[] answer;

    public static String[] solution(String[][] tickets){
        paths = new ArrayList<>();
        visited = new boolean[tickets.length];

        Arrays.sort(tickets, (a,b)-> a[0].equals(b[0]) ? a[1].compareTo(b[1]) : a[0].compareTo(b[0]));

        List<String> path = new ArrayList<>();
        path.add("ICN");
        dfs(0, "ICN", path, tickets);


        return answer;
    }

    static boolean dfs(int idx, String start, List<String> path, String[][] tickets){

        if(idx == tickets.length){
            answer = path.toArray(new String[0]);
            return true;
        }

        for(int i=0;i<tickets.length;i++){
            if(!visited[i] && tickets[i][0].equals(start)){
                visited[i] = true;
                path.add(tickets[i][1]);
                if (dfs(idx+1, tickets[i][1], path, tickets)) return true;
                visited[i] = false;
                path.remove(path.size()-1);
            }
        }

        return false;
    }

    public static void main(String[] args) throws Exception{
        String[][] tickets = {{"ICN","SFO"},{"ICN","ATL"},{"SFO", "ATL"},{"ATL","ICN"},{"ATL","SFO"}};

        System.out.println(Arrays.toString(solution(tickets)));
    }

}
