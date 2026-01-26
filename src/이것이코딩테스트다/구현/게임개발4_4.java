package 이것이코딩테스트다.구현;

import java.util.*;
import java.io.*;

public class 게임개발4_4 {
    static int n,m;
    static int x,y,direction;
    static int[][] map;
    static boolean[][] visited;
    //회전 하는 방향 메소드 만들고
    //이거에 따른 방향 이동 그리고 육지일떄만 이동 하면 될듯


    //북동남서 순서 (x,y) 좌표 기준으로
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1 ,0 ,-1};

    static void turnLeft(){
        direction--;
        if(direction == -1) direction = 3;


    }

    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);

        //맵 크기 입력
        n = sc.nextInt();
        m = sc.nextInt();

        //캐릭터 초기 위치와 방향
        x = sc.nextInt();
        y = sc.nextInt();
        direction = sc.nextInt();

        //방문 배열 초기화
        visited = new boolean[n][m];
        visited[x][y] = true;

        //맵 정보 입력
        map = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                map[i][j] = sc.nextInt();
            }
        }

        int count = 1;
        int turnTime = 0;

        while(true){
            turnLeft();
            int nx = x + dx[direction];
            int ny = y + dy[direction];

            //아직 가보지 않은 육지라면 이동
            if(!visited[nx][ny] && map[nx][ny] == 0){
                visited[nx][ny] = true;
                x = nx;
                y = ny;
                count++;
                turnTime = 0;
                continue;
            } else{
                turnTime++;
            }

            //네방향 모두 못가면
            if(turnTime == 4){
                nx = x - dx[direction];
                ny = y - dy[direction];

                if(map[nx][ny] == 0){
                    x = nx;
                    y = ny;
                } else{
                    break;
                }
                turnTime = 0;
            }
        }

        System.out.println(count);



    }
}
