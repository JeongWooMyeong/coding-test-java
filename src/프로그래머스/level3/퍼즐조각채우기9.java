package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 퍼즐조각채우기9 {
    static int n,m;
    static boolean[][] visited;

    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};

    public static int solution(int[][] game_board, int[][] table){
        n = game_board.length;
        m = game_board[0].length;
        int answer = 0;

        //1. 빈칸 좌표 경우의 수 dfs로 채우기
        List<List<int[]>> blanks = new ArrayList<>();
        visited = new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!visited[i][j] && game_board[i][j] == 0){
                    List<int[]> shape = new ArrayList<>();
                    dfs(i,j,shape,game_board, 0);
                    blanks.add(normalize(shape));
                }
            }
        }

        //2. 블록 좌표 경우의 수 dfs로 채우기
        List<List<int[]>> blocks = new ArrayList<>();
        visited = new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!visited[i][j] && table[i][j] == 1){
                    List<int[]> shape = new ArrayList<>();
                    dfs(i,j,shape,table,1);
                    blocks.add(normalize(shape));
                }
            }
        }

        //3. 채운 빈칸, 블록 가지고 비교
        boolean[] used = new boolean[blocks.size()];    //블록 사용 유무
        for(List<int[]> blank : blanks){
            for(int i=0;i<blocks.size();i++){
                if(blank.size() != blocks.get(i).size()) continue;
                if(used[i]) continue;
                //회전 블록 생성
                List<int[]> rotated = blocks.get(i);
                //4방향 회전
                for(int r=0;r<4;r++){
                    if(match(blank, rotated)){
                        answer += blank.size();
                        used[i] = true;
                        break;
                    }

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

        for(int i=0;i<4;i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;

            if(visited[nx][ny]) continue;

            if(board[nx][ny] == target){
                dfs(nx,ny, shape, board, target);
            }

        }

    }

    static List<int[]> normalize(List<int[]> shape){
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        List<int[]> result = new ArrayList<>();

        for(int i=0;i<shape.size();i++){
            minX = Math.min(minX, shape.get(i)[0]);
            minY = Math.min(minY, shape.get(i)[1]);
        }

        for(int[] s : shape){
            result.add(new int[]{s[0]-minX, s[1]-minY});
        }

        return result;

    }

    static List<int[]> rotate(List<int[]> blocks, int n){
        List<int[]> result= new ArrayList<>();
        //최대 x구하기
        int maxX = Integer.MIN_VALUE;
        for(int[] b : blocks){
            maxX = Math.max(maxX, b[0]);
        }

        for(int[] b : blocks){
            result.add(new int[]{b[1], maxX - b[0]});
        }

        return normalize(result);
    }

    static boolean match(List<int[]> a, List<int[]> b){
        if(a.size() != b.size()) return false;

        a.sort((p1,p2)->p1[0]==p2[0] ? p1[1]-p2[1] : p1[0]-p2[0]);
        b.sort((p1,p2)->p1[0]==p2[0] ? p1[1]-p2[1] : p1[0]-p2[0]);

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
