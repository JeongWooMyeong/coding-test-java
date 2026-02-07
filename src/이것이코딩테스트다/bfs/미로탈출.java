package 이것이코딩테스트다.bfs;

import java.util.*;

public class 미로탈출 {
    static int n,m;
    static int[][] graph;

    //상하좌우 이동방향
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static int bfs(int x, int y){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x,y});

        while(!q.isEmpty()){
            int[] pos = q.poll();
            int cx = pos[0];
            int cy = pos[1];

            //상하좌우 탐색
            for(int i=0;i<4;i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                //범위 안에 있고, 이동 가능한 칸이면
                if(nx>=0 && nx < n && ny >= 0 && ny <m){
                    if(graph[nx][ny] == 1){
                        //최단 거리 갱신
                        graph[nx][ny] = graph[cx][cy] + 1;
                        q.offer(new int[]{nx, ny});
                    }
                }
            }
        }

        return graph[n-1][m-1];
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        sc.nextLine(); // 버퍼 비우기?

        graph = new int[n][m];

        //미로 입력
        for(int i=0;i<n;i++){
            String line = sc.nextLine();
            for(int j=0;j<m;j++){
                graph[i][j] = line.charAt(j) - '0';
            }
        }

        System.out.println(bfs(0,0));
    }
}
