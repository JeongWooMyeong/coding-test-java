package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 퍼즐조각채우기4 {
    static boolean[][] visited;
    static int n;
    static int m;

    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};

    public static int solution(int[][] game_board, int[][] table){

        n = game_board.length;
        m = game_board[0].length;

        //빈칸 모양 채우기
        List<List<int[]>> blanks = new ArrayList<>();
        visited = new boolean[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                List<int[]> shape = new ArrayList<>();
                if(!visited[i][j] && game_board[i][j] == 0){
                    dfs(i,j, shape, game_board, visited, 0);
                    blanks.add(normalize(shape));
                }
            }
        }

        //table 모양 찾기
        List<List<int[]>> blocks = new ArrayList<>();
        visited = new boolean[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                List<int[]> shape = new ArrayList<>();
                if(!visited[i][j] && table[i][j] == 1){
                    dfs(i, j, shape, table, visited, 1);
                    blocks.add(normalize(shape));
                }
            }
        }

        int answer= 0;
        boolean[] used = new boolean[blocks.size()];

        for(List<int[]> blank : blanks){
            for(int i=0;i<blocks.size();i++){
                if(used[i]) continue;
                if(blank.size() != blocks.get(i).size()) continue;

                List<int[]> rotated = blocks.get(i);
                boolean matched = false;
                for(int r=0;r<4;r++){
                    if(match(rotated, blank)){
                        used[i] = true;
                        matched = true;
                        answer += blank.size();
                        break;
                    }
                    rotated = rotate(rotated, n);
                }
                if(matched) break;

            }
        }

        return answer;
    }

    static void dfs(int x, int y, List<int[]> shape, int[][] board, boolean[][] visited, int target){
        visited[x][y] = true;
        shape.add(new int[]{x,y});

        for(int i=0;i<4;i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
            if(!visited[nx][ny] && board[nx][ny] == target){
                dfs(nx, ny, shape, board, visited, target);
            }
        }

    }

    static List<int[]> normalize(List<int[]> shape){
        List<int[]> list = new ArrayList<>();
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        for(int[] s : shape){
            minX = Math.min(s[0], minX);
            minY = Math.min(s[1], minY);
        }

        for(int[] s : shape){
            list.add(new int[]{s[0] - minX, s[1] - minY});
        }

        return list;

    }

    static boolean match(List<int[]> a, List<int[]> b){
        if(a.size() != b.size()) return false;
        a.sort((p1,p2)->p1[0] == p2[0] ? p1[1] - p2[1] : p1[0] - p2[0]);
        b.sort((p1, p2)->p1[0] == p2[0] ? p1[1] - p2[1] : p1[0] - p2[0]);
        for(int i=0;i<a.size();i++){
            if(a.get(i)[0] != b.get(i)[0] || a.get(i)[1] != b.get(i)[1]) return false;
        }

        return true;
    }

    static List<int[]> rotate(List<int[]> shape, int n){
        List<int[]> list = new ArrayList<>();
        for(int i=0;i<shape.size();i++){
            list.add(new int[]{shape.get(i)[1], n - 1 - shape.get(i)[0]});
        }

        return normalize(list);
    }

    public static void main(String[] args) throws Exception{
        int[][] game_board = {{1,1,0,0,1,0},{0,0,1,0,1,0},{0,1,1,0,0,1},{1,1,0,1,1,1},{1,0,0,0,1,0},{0,1,1,1,0,0}};
        int[][] table =  {{1,0,0,1,1,0},{1,0,1,0,1,0},{0,1,1,0,1,1},{0,0,1,0,0,0},{1,1,0,1,1,0},{0,1,0,0,0,0}};

        System.out.println(solution(game_board, table));
    }

}
