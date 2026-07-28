package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 퍼즐조각채우기19 {

    static int n,m;
    static boolean[][] visited;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};

    public static int solution(int[][] game_board, int[][] table){

        n = game_board.length;
        m = game_board[0].length;
        int answer = 0;

        List<List<int[]>> blanks = new ArrayList<>();
        visited = new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!visited[i][j] && game_board[i][j] == 0) {
                    List<int[]> shape = new ArrayList<>();
                    dfs(i, j, shape, game_board, 0);
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
                    dfs(i, j, shape, table, 1);
                    blocks.add(normalize(shape));
                }
            }
        }

        boolean[] used = new boolean[blocks.size()];
        for(List<int[]> blank : blanks){
            for(int i=0;i<blocks.size();i++){
                if(blank.size() != blocks.get(i).size()) continue;
                if(used[i]) continue;

                List<int[]> rotated = blocks.get(i);

                for(int d=0;d<4;d++){
                    if(match(rotated, blank)){
                        answer += blank.size();
                        used[i] = true;
                        break;
                    }

                    rotated = rotate(rotated);
                }

                if(used[i]) break;


            }
        }

        return answer;

    }

    static void dfs(int x, int y, List<int[]> shape, int[][] board, int target){

        visited[x][y] = true;
        shape.add(new int[]{x,y});

        for(int i=0;i<4;i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
            if(visited[nx][ny]) continue;

            if(board[nx][ny] == target){
                dfs(nx,ny,shape,board,target);
            }

        }

    }

    static List<int[]> normalize(List<int[]> shape){
        List<int[]> result = new ArrayList<>();
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;

        for(int[] s : shape){
            minX = Math.min(minX, s[0]);
            minY = Math.min(minY, s[1]);
        }

        for(int[] s : shape){
            result.add(new int[]{s[0]-minX, s[1]-minY});
        }

        return result;
    }

    static boolean match(List<int[]> p1, List<int[]> p2){
        if(p1.size() != p2.size()) return false;
        p1.sort((a,b)-> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        p2.sort((a,b)-> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

        for(int i=0;i<p1.size();i++){
            if(p1.get(i)[0] != p2.get(i)[0] || p1.get(i)[1] != p2.get(i)[1]) return false;
        }

        return true;
    }

    static List<int[]> rotate(List<int[]> shape){
        int maxX = Integer.MIN_VALUE;
        List<int[]> result = new ArrayList<>();

        for(int[] s : shape){
            maxX = Math.max(maxX, s[0]);
        }

        for(int[] s : shape){
            result.add(new int[]{s[1], maxX - s[0]});
        }

        return normalize(result);
    }

    public static void main(String[] args) throws Exception{
        int[][] game_board = {{1,1,0,0,1,0},{0,0,1,0,1,0},{0,1,1,0,0,1},{1,1,0,1,1,1},{1,0,0,0,1,0},{0,1,1,1,0,0}};
        int[][] table =  {{1,0,0,1,1,0},{1,0,1,0,1,0},{0,1,1,0,1,1},{0,0,1,0,0,0},{1,1,0,1,1,0},{0,1,0,0,0,0}};

        System.out.println(solution(game_board, table));
    }

}
