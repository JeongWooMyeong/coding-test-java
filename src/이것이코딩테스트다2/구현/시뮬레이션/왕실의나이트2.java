package 이것이코딩테스트다2.구현.시뮬레이션;

import java.util.*;

public class 왕실의나이트2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        int x = input.charAt(0) - 'a' + 1;
        int y = input.charAt(1) - '0';
        int[] dx = {2, 2, -2, -2, 1, 1, -1, -1};
        int[] dy = {1, -1, 1, -1, 2, -2, 2, -2};

        int nx = -1;
        int ny = -1;
        int cnt = 0;
        for(int i=0;i<8;i++){
            nx += x + dy[i];
            ny += y + dx[i];

            if(nx < 1 || ny < 1 || nx > 8 || ny > 8) continue;

            x = nx;
            y = ny;
            cnt++;
        }

        System.out.println(cnt);


    }
}
