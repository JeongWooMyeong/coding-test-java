package 이것이코딩테스트다2.기출문제.BFSDFS;

import java.util.*;
import java.io.*;

public class 감시피하기 {
    static int N;
    static char[][] map;
    static boolean found = false;
    static ArrayList<int[]> empty = new ArrayList<>();
    static ArrayList<int[]> teacher = new ArrayList<>();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new char[N][N];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                map[i][j] = st.nextToken().charAt(0);
                if(map[i][j] == 'X') empty.add(new int[]{i, j});
                if(map[i][j] == 'T') teacher.add(new int[]{i, j});
            }
        }

        dfs(0,0);

        System.out.println(found ? "YES" : "NO");
    }

    static void dfs(int idx, int count){
        if(found) return;
        if(count == 3){
            //false면 감시 성공 못함
            if(!simulate(map)){
                found = true;
            }
            return;
        }

        if(idx == empty.size()) return;

        //장애물 설치
        int[] pt = empty.get(idx);
        int x = pt[0];
        int y = pt[1];

        map[x][y] = 'O';
        dfs(idx+1, count + 1);
        map[x][y] = 'X';

        dfs(idx+1, count);


    }

    static boolean simulate(char[][] map){

        for(int[] t : teacher){
            int x = t[0];
            int y = t[1];
            //상하 좌우
            if(watch(x,y,-1,0, map)) return true;
            if(watch(x,y,1,0,map)) return true;
            if(watch(x,y,0,-1,map)) return true;
            if(watch(x,y,0,1,map)) return true;

        }
        //false면 감시 못함
        return false;


    }

    static boolean watch(int x, int y, int dx, int dy, char[][] map){
        int nx = x;
        int ny = y;
        //반복
        while(true) {
            nx += dx;
            ny += dy;

            if (nx < 0 || ny < 0 || nx >= N || ny >= N) return false;

            if (map[nx][ny] == 'O') return false;
            if (map[nx][ny] == 'S') return true;
        }
    }


}
