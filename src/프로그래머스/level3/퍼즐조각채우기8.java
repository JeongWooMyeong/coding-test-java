package 프로그래머스.level3;

import java.util.*;

public class 퍼즐조각채우기8 {
    static int n,m;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static boolean[][] visited;

    public static int solution(int[][] game_board, int[][] table){
        int answer = 0;
        n = game_board.length;
        m = game_board[0].length;

        List<List<int[]>> blanks = new ArrayList<>();
        visited = new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!visited[i][j] && game_board[i][j] == 0){
                    List<int[]> shape = new ArrayList<>();
                    bfs(i,j, shape, game_board,0);
                    blanks.add(normalize(shape));
                }
            }
        }

        List<List<int[]>> blocks = new ArrayList<>();
        visited = new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!visited[i][j] && table[i][j] == 1){
                    List<int[]> shape = new ArrayList<>();
                    bfs(i,j, shape, table, 1);
                    blocks.add(normalize(shape));
                }
            }
        }

        boolean[] used = new boolean[blocks.size()];
        for(List<int[]> blank : blanks){
            boolean found = false;
            for(int i=0;i<blocks.size();i++){
                if(blank.size() != blocks.get(i).size()) continue;
                if(used[i]) continue;

                List<int[]> rotated = blocks.get(i);
                for(int r=0;r<4;r++){
                    if(match(blank, rotated)){
                        answer += blank.size();
                        used[i] = true;
                        found = true;
                        break;
                    }

                    rotated = rotate(rotated, n);

                }
                if(found) break;
            }
        }

        return answer;
    }

    static void bfs(int x, int y, List<int[]> shape,int[][] board, int target){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x,y});
        visited[x][y] = true;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x1 = cur[0];
            int y1 = cur[1];
            shape.add(new int[]{x1,y1});

            for(int i=0;i<4;i++){
                int nx = x1 + dx[i];
                int ny = y1 + dy[i];

                if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if(visited[nx][ny]) continue;

                if(board[nx][ny] == target){
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx,ny});
                }

            }

        }
    }

    static List<int[]> normalize(List<int[]> shape){
        List<int[]> result = new ArrayList<>();
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;

        for(int[] p : shape){
            minX = Math.min(p[0], minX);
            minY = Math.min(p[1], minY);
        }

        for(int[] p : shape){
            result.add(new int[]{p[0]-minX, p[1]-minY});
        }

        return result;
    }

    static List<int[]> rotate(List<int[]> shape, int n){
        List<int[]> result = new ArrayList<>();
        int maxX = 0;

        for(int[] p : shape){
            maxX = Math.max(maxX, p[0]);
        }

        for(int[] p : shape){
            result.add(new int[]{p[1], maxX - p[0]});
        }

        return normalize(result);
    }

    static boolean match(List<int[]> a, List<int[]> b){
        if(a.size() != b.size()) return false;

        a.sort((p1,p2)->p1[0]==p2[0] ? p1[1] - p2[1] : p1[0] - p2[0]);
        b.sort((p1,p2)->p1[0]==p2[0] ? p1[1] - p2[1] : p1[0] - p2[0]);

        for(int i=0;i<a.size();i++){
            if(a.get(i)[0] != b.get(i)[0] || a.get(i)[1] != b.get(i)[1]) return false;
        }

        return true;
    }

    public static void main(String[] args) throws Exception{
        int[][] game_board = {{1,1,0,0,1,0},{0,0,1,0,1,0},{0,1,1,0,0,1},{1,1,0,1,1,1},{1,0,0,0,1,0},{0,1,1,1,0,0}};
        int[][] table =  {{1,0,0,1,1,0},{1,0,1,0,1,0},{0,1,1,0,1,1},{0,0,1,0,0,0},{1,1,0,1,1,0},{0,1,0,0,0,0}};

        System.out.println(solution(game_board, table));
    }

}
