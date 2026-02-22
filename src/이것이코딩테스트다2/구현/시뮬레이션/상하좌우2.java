package 이것이코딩테스트다2.구현.시뮬레이션;

import java.util.*;

/*
구현 : 머리속에 있는 알고리즘을 소스코드로 바꾸는 과정
완전탐색 : 모든 경우의 수를 주저 없이 다 계싼
시뮬레이션 : 문제에서 제시한 알고리즘을 한 단계씩 차례대로 수행
 */

public class 상하좌우2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        /*
        렇게 쓰면 nextInt()가 숫자만 읽고, 줄 끝의 개행 문자(\n)는 버퍼에 남아있습니다.
그래서 바로 이어지는 nextLine()은 그 개행을 읽어버려서 inputdir이 빈 문자열이 됩니다.

         */
        int n = Integer.parseInt(sc.nextLine());
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        String[] dir = {"L", "R", "U", "D"};

        int x = 1;
        int y = 1;
        String inputdir = sc.nextLine();
        System.out.println(inputdir);
        String[] dirs = inputdir.split(" ");
        int ny = 1;
        int nx = 1;

        for (int i = 0; i < dirs.length; i++){

            if(dirs[i].equals("L")){
                ny = y + dy[0];
            }else if(dirs[i].equals("R")){
                ny = y + dy[1];
            }else if(dirs[i].equals("U")){
                nx = x + dx[2];
            }else if(dirs[i].equals("D")){
                nx = x + dx[3];
            }

            if(nx > n || nx < 1 || ny > n || ny < 1) continue;

            x = nx;
            y = ny;

        }

        System.out.print(x +" " + y);
    }





}
