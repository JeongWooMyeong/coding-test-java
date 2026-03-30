package 이것이코딩테스트다2.기출문제.BFSDFS;

import java.util.*;
import java.io.*;

public class 감시피하기2 {
    static int N;
    static char[][] map;
    static ArrayList<Point> empty = new ArrayList<>();
    static ArrayList<Point> teachers = new ArrayList<>();
    static boolean found = false;   //학생 발견 여부

    static class Point{
        int x;
        int y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new char[N][N];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                map[i][j] = st.nextToken().charAt(0);
                if(map[i][j] == 'X') empty.add(new Point(i, j));
                if(map[i][j] == 'T') teachers.add(new Point(i, j));
            }
        }

        //장애물 세우기
        dfs(0, 0);


        //결과값 출력
        System.out.print(found ? "YES" : "NO");

    }

    static void dfs(int idx, int count){
        if(found) return;
        if(count == 3){
            //학생 못발견하면
            if(!check(map)){
                found = true;

            }
            return;
        }

        if(idx == empty.size()) return;

        Point pt = empty.get(idx);
        //장애물 설치
        map[pt.x][pt.y] = 'O';
        dfs(idx + 1, count + 1);
        map[pt.x][pt.y] = 'X';

        //장애물 선택 안함 (현재)
        dfs(idx+1, count);

    }
    //map을 paramd르 둔 이유가 장애물 설치가 다 다르기 때문
    static boolean check(char[][] map){
        for(Point pt : teachers){
            int x = pt.x;
            int y = pt.y;

            //4방향 감시
            if(watch(x, y, -1, 0, map)) return true;
            if(watch(x, y, 1, 0, map)) return true;
            if(watch(x, y, 0, -1, map)) return true;
            if(watch(x, y, 0, 1, map)) return true;

        }

        return false;
    }

    static boolean watch(int x, int y, int dx, int dy,char[][] map){
        int nx = x;
        int ny = y;
        while(true){
            nx += dx;
            ny += dy;

            if(nx < 0 || ny < 0 || nx >= N || ny >= N) return false;
            if(map[nx][ny] == 'S') return true;
            if(map[nx][ny] == 'O') return false;

        }
    }


}
