package 백준.골드.level2;

import java.util.*;
import java.io.*;

public class 게리맨더링3 {
    static int N;
    static int[][] map;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N+1][N+1];

        for(int i=1;i<=N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1;j<=N;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int x=1;x<=N;x++){
            for(int y=1;y<=N;y++){
                for(int d1=1;d1<=N;d1++){
                    for(int d2=1;d2<=N;d2++){
                        if(x+d2+d1 > N) continue;
                        if(y-d1 < 1 || y+d2 > N) continue;
                        solve(x,y,d1,d2);
                    }
                }
            }
        }

        System.out.println(answer);

    }

    static void solve(int x, int y, int d1, int d2){
        int[][] area = new int[N+1][N+1];

        //5번 구역 입력
        for(int i=0;i<=d1;i++){
            area[x + i][y-i] = 5;   //1번 경계
            area[x + i + d2][y - i + d2] = 5; //3번 경계
        }

        for(int i=0;i<=d2;i++){
            area[x+i][y+i] = 5;
            area[x+i+d1][y+i-d1] = 5;
        }

        //5번 내부 채우기
        for(int r=x+1;r<x+d1+d2;r++){
            boolean inside = false;
            for(int c=1;c<=N;c++){
                if(area[r][c] == 5) inside = !inside;
                if(inside) area[r][c] = 5;
            }
        }

        //구역 나누기
        for(int r=1;r<=N;r++){
            for(int c=1;c<=N;c++){
                if(area[r][c] == 5) continue;
                if(r < x+ d1 && c<=y) area[r][c] = 1;
                else if(r <= x+d2 && c > y) area[r][c] =2;
                else if(r >= x+d1 && c < y-d1+d2) area[r][c] = 3;
                else if(r > x+d2 && c >= y-d1+d2) area[r][c] = 4;
            }
        }

        //인구 합 계산
        int[] population = new int[6];
        for(int r=1;r<=N;r++){
            for(int c=1;c<=N;c++){
                population[area[r][c]] += map[r][c];
            }
        }

        int max = Arrays.stream(population).max().getAsInt();
        int min = Arrays.stream(population).filter(v -> v > 0).min().getAsInt();

        answer = Math.min(answer, max-min);

    }

}
