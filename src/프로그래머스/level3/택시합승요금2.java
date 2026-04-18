package 프로그래머스.level3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class 택시합승요금2 {
    static int[][] map;
    //Intger.MAX_VALUE 보다 10억정도로 설정하는게 좋음
    static int INF = (int) 1e9;


    public static int solution(int n, int s, int a, int b, int[][] fares){
        map = new int[n+1][n+1];
        long answer = INF;
        //초기화 필수
        for(int i=0;i<=n;i++){
            Arrays.fill(map[i], INF);
            map[i][i] = 0;
        }

        //간선 정보 입력
        for(int i=0;i<fares.length;i++){
            int[] info = fares[i];
            int x = info[0];
            int y = info[1];
            int cost = info[2];
            map[x][y] = Math.min(map[x][y], cost);
            map[y][x] = Math.min(map[y][x], cost);
        }
        //플로이드 워셜
        for(int k=1;k<=n;k++){
            for(int x=1;x<=n;x++){
                for(int y=1;y<=n;y++){
                    //계산 하려는 값 둘중에 INF일때 넘기기
                    if(map[x][k] == INF || map[k][y] == INF) continue;
                    map[x][y] = Math.min(map[x][y], map[x][k] + map[k][y]);
                }
            }
        }

        //단순히 map[a][b] 만 출력해서 안됌 분기점 타야함
        for(int k=1;k<=n;k++){
            //아 시작점이 있찌..
            answer = Math.min(answer, (long)map[s][k] + map[k][a] + map[k][b]);
        }

        //return map[a][b];
        return (int)answer;

    }

    public static void main(String[] args) throws Exception{
//        int n = 6;
//        int s = 4;
//        int a = 6;
//        int b = 2;
//        int[][] fares = {{4, 1, 10}, {3, 5, 24}, {5, 6, 2}, {3, 1, 41}, {5, 1, 24}, {4, 6, 50}, {2, 4, 66}, {2, 3, 22}, {1, 6, 25}};
//

        int n = 7;
        int s = 3;
        int a = 4;
        int b = 1;
        int[][] fares = {{5, 7, 9}, {4, 6, 4}, {3, 6, 1}, {3, 2, 3}, {2, 1, 6}};


        System.out.println(solution(n,s,a,b,fares));

    }

}
