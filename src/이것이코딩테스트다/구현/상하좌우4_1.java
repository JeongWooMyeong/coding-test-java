package 이것이코딩테스트다.구현;

import java.util.*;
import java.io.*;

public class 상하좌우4_1 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); //NXN 정사각형

        st = new StringTokenizer(br.readLine());
        int x = 1;
        int y = 1;

        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        int nx = 0;
        int ny = 0;
        String[] types = {"L", "R", "U", "D"};

        while(st.hasMoreTokens()){
            String move = st.nextToken();
            for(int j=0;j<types.length;j++){
                if(move.equals(types[j])){
                    nx = x + dx[j];
                    ny = y + dy[j];
                    break;

                }
            }

            if(nx < 1 || nx > N || ny > N || ny < 1){
                continue;
            }

            x= nx;
            y= ny;
        }

        System.out.println(x + " " + y);




    }
}
