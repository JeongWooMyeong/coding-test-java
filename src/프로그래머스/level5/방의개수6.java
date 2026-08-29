package 프로그래머스.level5;

import java.util.*;
import java.io.*;

public class 방의개수6 {

    static Map<String, Set<String>> visitedEdges;
    static Set<String> visitedNodes;
    static int[] dx = {-1,-1,0,1,1,1,0,-1};
    static int[] dy = {0,1,1,1,0,-1,-1,-1};

    public static int solution(int[] arrows){
        int rooms = 0;
        int x = 0;
        int y = 0;

        visitedEdges = new HashMap<>();
        visitedNodes = new HashSet<>();

        visitedNodes.add(x+","+y);

        for(int d : arrows){
            for(int i=0;i<2;i++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                String cur = x + "," + y;
                String next = nx + "," + ny;

                visitedEdges.putIfAbsent(cur, new HashSet<>());
                visitedEdges.putIfAbsent(next, new HashSet<>());

                if (visitedNodes.contains(next) && !visitedEdges.get(cur).contains(next)) {
                    rooms++;
                }

                visitedEdges.get(cur).add(next);
                visitedEdges.get(next).add(cur);
                visitedNodes.add(next);

                x = nx;
                y = ny;
            }
        }

        return rooms;

    }

    public static void main(String[] args) throws Exception{
        int[] arrows = {6, 6, 6, 4, 4, 4, 2, 2, 2, 0, 0, 0, 1, 6, 5, 5, 3, 6, 0};
        System.out.println(solution(arrows));
    }

}
