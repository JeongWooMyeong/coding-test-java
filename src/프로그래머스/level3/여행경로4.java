package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 여행경로4 {
    static List<String[]> answer;
    static boolean[] visited;

    public static String[] solution(String[][] tickets){
        answer = new ArrayList<>();
        visited = new boolean[tickets.length];
        List<String> path = new ArrayList<>();
        path.add("ICN");
        dfs(0, "ICN", path, tickets);
        //정렬하는법 어렵네..
        Collections.sort(answer, (a,b)->{
            for(int i=0;i<a.length;i++){
                if(!a[i].equals(b[i])) return a[i].compareTo(b[i]);
            }
            return 0;
        });

        return answer.get(0);

    }

    static void dfs(int idx, String begin, List<String> path, String[][] tickets){
        //조건을 뭐라해야되지
        if(idx == tickets.length){
            answer.add(path.toArray(new String[0]));
            return;
        }

        for(int i=0;i<tickets.length;i++){
            if(!visited[i] && tickets[i][0].equals(begin)){
                path.add(tickets[i][1]);
                visited[i] = true;
                dfs(idx+1, tickets[i][1], path, tickets);
                path.remove(path.size()-1);
                visited[i] = false;
            }
        }

    }

    public static void main(String[] args) throws Exception{
        String[][] tickets = {{"ICN", "JFK"},{"HND","IAD"},{"JFK","HND"}};

        System.out.println(Arrays.toString(solution(tickets)));
    }

}
