package 백준.골드.level2;

import java.util.*;

public class 게리맨더링2 {
    static int N;
    static int[][] map;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new int[N+1][N+1];    // 1 - indexed

        for(int i=1;i<=N;i++){
            for(int j=1;j<=N;j++){
                map[i][j] = sc.nextInt();
            }
        }

        //모든 (x, y, d1, d2) 경우 탐색
        for(int x=1;x<=N;x++){
            for(int y=1;y<=N;y++){
                for(int d1 = 1;d1<=N;d1++){
                    for(int d2=1;d2<=N;d2++){
                        if(x + d1 + d2 > N) continue;
                        if(y - d1 < 1 || y + d2 > N) continue;
                        solve(x, y, d1, d2);
                    }
                }
            }
        }
        System.out.println(answer);
    }

    static void solve(int x, int y, int d1, int d2){
        int[][] area = new int[N+1][N+1];

        //5번 경계선 표시
        for(int i=0;i<=d1;i++){
            area[x+i][y-i] = 5;
            area[x+d2+i][y+d2-i] = 5;
        }
        for(int i=0;i<=d2;i++){
            area[x+i][y+i] = 5;
            area[x+d1+i][y-d1+i] = 5;
        }

        //5번 내부 채우기
        for(int r=x+1; r<x+d1+d2;r++){
            boolean inside = false;
            for(int c=1;c<=N;c++){
                if(area[r][c] == 5) inside = !inside;
                if(inside) area[r][c] = 5;
            }
        }

        //나머지 구역 분할
        for(int r=1;r<=N;r++){
            for(int c=1;c<=N;c++){
                if(area[r][c] == 5) continue;
                if(r < x+d1 && c <= y) area[r][c] = 1;
                else if(r <= x+d2 && c > y) area[r][c] = 2;
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
        answer = Math.min(answer, max - min);

    }

}
