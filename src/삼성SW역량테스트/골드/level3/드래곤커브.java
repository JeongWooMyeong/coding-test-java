package 삼성SW역량테스트.골드.level3;

import java.util.*;
import java.io.*;

public class 드래곤커브 {
    static int N;
    static boolean[][] map = new boolean[101][101];
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0,-1,0,1};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());   //시작 방향
            int g = Integer.parseInt(st.nextToken());   //세대

            drawDragonCurve(x, y, d, g);
        }

        System.out.println(countSquares());
    }
    //주어진 드래곤 커브의 방향을 다 담아서
    static void drawDragonCurve(int x, int y, int d, int g){
        List<Integer> directions = new ArrayList<>();
        directions.add(d);

        //세대별로 방향 배열 확장
        for(int gen = 1;gen<=g;gen++){
            for(int i=directions.size()-1;i>=0;i--){
                directions.add((directions.get(i) + 1) % 4);
            }
        }

        //시작점 표시 (좌표이므로ㅗ y,x) 표시
        map[y][x] = true;

        //방향 배열 따라가며 좌표 찍기
        for(int dir : directions){
            x += dx[dir];
            y += dy[dir];
            map[y][x] = true;
        }
    }

    static int countSquares(){
        int cnt = 0;
        for(int y=0;y<100;y++){
            for(int x=0;x<100;x++) {
                if (map[y][x] && map[y + 1][x] && map[y][x + 1] && map[y + 1][x + 1]) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

}
