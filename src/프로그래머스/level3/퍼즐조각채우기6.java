package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 퍼즐조각채우기6 {
    static boolean[][] visited;
    static int n,m;

    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};

    public static int solution(int[][] game_board, int[][] table){
        int answer = 0;
        n = game_board.length;
        m = game_board[0].length;


        //빈칸 채우기
        List<List<int[]>> blanks = new ArrayList<>();
        visited = new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!visited[i][j] && game_board[i][j] == 0){
                    List<int[]> shape = new ArrayList<>();
                    dfs(i,j,shape, game_board,0);
                    blanks.add(normalize(shape));
                }
            }
        }

        //block 채우기
        List<List<int[]>> blocks = new ArrayList<>();
        visited = new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!visited[i][j] && table[i][j] == 1){
                    List<int[]> shape = new ArrayList<>();
                    dfs(i,j,shape, table, 1);
                    blocks.add(normalize(shape));
                }
            }
        }

        //blank 돌면서 blcok 비교
        boolean[] used = new boolean[blocks.size()];

        for(List<int[]> blank : blanks){
            for(int i=0;i<blocks.size();i++){
                if(blank.size() != blocks.get(i).size()) continue;
                if(used[i]) continue;

                List<int[]> rotated = blocks.get(i);

                //회전 진행
                for(int r=0;r<4;r++){
                    if(match(rotated, blank)){
                        used[i] = true;
                        answer += blank.size();
                        break;
                    }

                    //못찾으면 회전
                    rotated = rotate(rotated, n);
                }

                if(used[i]) break;

            }
        }

        return answer;
    }

    static void dfs(int x, int y, List<int[]> shape, int[][] board, int target){
        visited[x][y] = true;
        shape.add(new int[]{x,y});
        //아 이렇게 하면 전체 다 탐색이지..
//        for(int i=0;i<n;i++){
//            for(int j=0;j<m;j++){
//                if(!visited[i][j] && board[i][j] == target){
//                    dfs(i, j, shape, board, target);
//                }
//            }
//        }
        for(int i=0;i<4;i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
            if(visited[nx][ny]) continue;

            if(board[nx][ny] == target){
                dfs(nx, ny, shape, board, target);
            }

        }
    }

    static List<int[]> normalize(List<int[]> shape){
        List<int[]> list = new ArrayList<>();
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;

        for(int[] s : shape){
            int x = s[0];
            int y = s[1];
            minX = Math.min(minX, x);
            minY = Math.min(minY, y);
        }

        for(int[] s : shape){
            int x = s[0];
            int y = s[1];
            list.add(new int[]{x - minX, y - minY});
        }

        return list;
    }

    static List<int[]> rotate(List<int[]> shape, int n){
        List<int[]> result = new ArrayList<>();
        for(int[] p : shape){
            result.add(new int[]{p[1], n - 1 - p[0]});
        }
        //회전도 저규화 필요
        return normalize(result);
    }

    static boolean match(List<int[]> a, List<int[]> b){
        if(a.size() != b.size()) return false;

        a.sort((p1,p2)-> p1[0] == p2[0] ? p1[1] - p2[1] : p1[0] - p2[0]);
        b.sort((p1, p2)->p1[0] == p2[0] ? p1[1] - p2[1] : p1[0] - p2[0]);

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
