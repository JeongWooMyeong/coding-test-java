package 프로그래머스.level5;

import java.util.*;
import java.io.*;

public class 방의개수2 {
    static Map<String, Set<String>> visitedEdges;
    static Set<String> visitedNodes;

    static int[] dx = {-1,-1,0,1,1,1,0,-1};
    static int[] dy = {0,1,1,1,0,-1,-1,-1};

    public static int solution(int[] arrows){
        visitedEdges = new HashMap<>(); //간선 HashMap
        visitedNodes = new HashSet<>(); //방문 노드

        int rooms = 0;
        int x = 0;
        int y = 0;
        visitedNodes.add(x+","+y);

        for(int dir : arrows){
            //대각선 교차점 해결위해 좌표 두배 확장
            for(int step=0;step<2;step++){
                int nx = x + dx[dir];
                int ny = y + dy[dir];
                //현재 좌표
                String now = x + "," + y;
                //이동할 좌표
                String next = nx + "," + ny;

                visitedEdges.putIfAbsent(now, new HashSet<>());
                visitedEdges.putIfAbsent(next, new HashSet<>());
                //next가 미리 방문했고 현재 좌표에서 next 좌표 새로운 간선이면 방 만들어짐
                if(visitedNodes.contains(next) && !visitedEdges.get(now).contains(next)){
                    rooms++;
                }
                //방문 노드 처리
                visitedNodes.add(next);
                //간선 처리
                visitedEdges.get(now).add(next);
                visitedEdges.get(next).add(now);

                //x,y 좌표 변경
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
