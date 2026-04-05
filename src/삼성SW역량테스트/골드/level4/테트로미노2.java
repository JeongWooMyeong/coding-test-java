package 삼성SW역량테스트.골드.level4;

import java.util.*;
import java.io.*;

public class 테트로미노2 {
    static int[][] map;
    static boolean[][] visited;
    static int N,M;
    static int max = Integer.MIN_VALUE;

    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        //맵 정보 입력
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //방문처리 visited 배열 초기화
        visited = new boolean[N][M];

        //맵 마다 테트로미노 dfs 경우 찾기
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                //방문처리
                visited[i][j] = true;
                dfs(i, j , map[i][j], 1);   //dfs 탐색
                //방문 완료 후 여러가지 경우 구해야 하므로 방문 복구
                visited[i][j] = false;
                //ㅗ 경우에는 dfs에서 처리할 수 없으므로 따로 처리
                checkExtraShape(i, j);
            }
        }

        //결과 값 출력
        System.out.print(max);

    }

    static void dfs(int x, int y, int sum, int depth){
        //만약 테트로미노 4칸 만들었으면
        if(depth == 4){
            //최대값 구하고 return
            max = Math.max(max, sum);
            return;
        }

        //상하좌우 돌면서 4칸확인
        for(int d=0;d<4;d++){
            int nx = x + dx[d];
            int ny = y + dy[d];

            //범위 넘어가면 continue;
            if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
            //제일 중요한걸 빼먹었네...
            if(!visited[nx][ny]) {
                //sum += map[nx][ny];
                visited[nx][ny] = true;
                dfs(nx, ny, sum + map[nx][ny], depth + 1);
                visited[nx][ny] = false;
            }
        }
    }
    //따로 계산이므로 방문처리 필요없음
    static void checkExtraShape(int x, int y){
        int center = map[x][y];

        for(int d=0;d<4;d++){
            int sum = center;
            boolean valid = true;
            for(int k=0;k<4;k++){
                if(d==k) continue;
                int nx = x + dx[k];
                int ny = y + dy[k];

                if(nx < 0 || ny < 0 || nx >= N || ny >= M){
                    valid = false;
                    break;
                }

                sum += map[nx][ny];

            }

            if(valid) max = Math.max(max, sum);
        }

    }

}
