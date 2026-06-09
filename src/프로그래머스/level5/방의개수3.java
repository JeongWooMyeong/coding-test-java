package 프로그래머스.level5;

import java.util.*;
import java.io.*;

public class 방의개수3 {

    static Map<String, Set<String>> visitedEdges;
    static Set<String> visitedNodes;

    static int[] dx = {-1,-1,0,1,1,1,0,-1};
    static int[] dy = {0,1,1,1,0,-1,-1,-1};

    public static int solution(int[] arrows){
        visitedEdges = new HashMap<>();
        visitedNodes = new HashSet<>();

        int x = 0;
        int y = 0;
        visitedNodes.add(x+","+y);
        int rooms = 0;

        for(int dir : arrows){
            for(int step=0;step<2;step++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                String now = x + "," + y;
                String next = nx + "," + ny;

                visitedEdges.putIfAbsent(now, new HashSet<>());
                visitedEdges.putIfAbsent(next, new HashSet<>());

                if (visitedNodes.contains(next) && !visitedEdges.get(now).contains(next)) {
                    rooms++;
                }

                //방문 노드 처리
                visitedNodes.add(next);
                visitedEdges.get(now).add(next);
                visitedEdges.get(next).add(now);


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
