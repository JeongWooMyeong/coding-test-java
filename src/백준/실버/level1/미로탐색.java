package 백준.실버.level1;

import java.util.*;

public class 미로탐색 {
    static int n, m;
    static int[][] maze;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0 ,0, -1, 1};

    static class Node{
        int x, y;
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        maze = new int[n][m];
        visited = new boolean[n][m];

        for(int i=0;i<n;i++){
            String line = sc.next();
            for(int j=0;j<m;j++){
                maze[i][j] = line.charAt(j) - '0';
            }
        }

        System.out.println(bfs(0, 0));
    }

    public static int bfs(int startX, int startY){
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(startX, startY));
        visited[startX][startY] = true;

        while(!q.isEmpty()){
            Node cur = q.poll();
            int x = cur.x;
            int y = cur.y;

            for(int i=0;i<4;i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx >= 0 && ny >= 0 && nx < n && ny < m){
                    if(maze[nx][ny] == 1 && !visited[nx][ny]){
                        visited[nx][ny] = true;
                        maze[nx][ny] = maze[x][y] + 1; //거리 갱신
                        q.offer(new Node(nx, ny));
                    }
                }
            }
        }
        return maze[n-1][m-1];
    }

}
