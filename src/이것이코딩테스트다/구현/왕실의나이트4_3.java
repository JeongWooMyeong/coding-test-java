package 이것이코딩테스트다.구현;

import java.util.*;
import java.io.*;

public class 왕실의나이트4_3 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String xy = st.nextToken();

        int x = xy.charAt(1) - '0';
        int y = xy.charAt(0) - 'a' + 1;
        //나이트가 움직일 수 있는 총 경우의 수
        int[] dx = {2, 2, -2, -2, 1, 1, -1, -1};
        int[] dy = {1, -1, 1, -1, 2, -2, 2, -2};

        int cnt = 0;
        int nx = 0;
        int ny = 0;

        for(int i=0;i<8;i++){
            nx = x + dx[i];
            ny = y + dy[i];

            if(nx >= 1 && nx<=8 && ny >=1 && ny<=8){
                cnt++;
            }
        }

        System.out.println(cnt);


    }
}
