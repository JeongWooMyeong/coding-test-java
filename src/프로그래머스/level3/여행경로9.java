package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 여행경로9 {

    static ArrayList<ArrayList<String>> resultList;
    static boolean[] visited;

    public static String[] solution(String[][] tickets){
        resultList = new ArrayList<>();
        visited = new boolean[tickets.length];

        ArrayList<String> path = new ArrayList<>();
        path.add("ICN");

        Arrays.sort(tickets, (a,b)->a[0].equals(b[0]) ? a[1].compareTo(b[1]) : a[0].compareTo(b[0]));

        dfs(0,"ICN", path, tickets);


        return resultList.get(0).toArray(new String[0]);
    }

    static void dfs(int idx, String begin, ArrayList<String> path, String[][] tickets){

        if(idx == tickets.length){
            resultList.add(new ArrayList<>(path));
            return;
        }


        for(int i=0;i<tickets.length;i++){
            if(!visited[i] && tickets[i][0].equals(begin)){
                visited[i] = true;
                path.add(tickets[i][1]);
                dfs(idx+1 ,tickets[i][1], path, tickets);
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
