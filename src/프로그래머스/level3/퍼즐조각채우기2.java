package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 퍼즐조각채우기2 {
    static boolean[][] visited;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};

    public static int solution(int[][] game_board, int[][] table){
        int answer = 0;
        int n = game_board.length;

        //1. 빈칸 찾기
        List<List<int[]>> blanks = new ArrayList<>();
        visited = new boolean[n][n];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                List<int[]> shape = new ArrayList<>();
                if(!visited[i][j] && game_board[i][j] == 0){
                    dfs(i,j,shape,game_board,visited,0);
                    //정규화 (0,0) 기준 -> 다른곳에 넣기 위해
                    blanks.add(normalize(shape));
                }

            }
        }

        //2. table에 모양 찾기
        List<List<int[]>> blocks = new ArrayList<>();
        visited = new boolean[n][n];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                List<int[]> shape = new ArrayList<>();
                if(!visited[i][j] && table[i][j] == 1){
                    dfs(i,j,shape,table,visited,1);
                    blocks.add(normalize(shape));
                }
            }
        }

        //3. 모양 비교
        boolean[] used = new boolean[blocks.size()];
        for(List<int[]> blank : blanks){
            for(int i=0;i<blocks.size();i++){
                if(used[i]) continue;
                List<int[]> block = blocks.get(i);
                if(blank.size() != block.size()) continue;
                //매칭 되었는지 확인
                boolean matched = false;
                //회전 리스트
                List<int[]> rotated = block;
                //360도까지 회전
                for(int r=0;r<4;r++) {

                    if (match(blank, rotated)) {
                        matched = true;
                        used[i] = true;
                        answer += blank.size();
                        break;
                    }

                    //90도 회전
                    rotated = rotate(rotated, n);

                }
                //매칭되면 break
                if (matched) break;
            }
        }

        return answer;
    }

    static void dfs(int x, int y, List<int[]> shape,int[][] board, boolean[][] visited, int target){
        int n = board.length;

        visited[x][y] = true;
        shape.add(new int[]{x,y});

        for(int i=0;i<4;i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || ny < 0 || nx >= n || ny >= n) continue;

            if(!visited[nx][ny] && board[nx][ny] == target){
                dfs(nx, ny, shape, board, visited, target);
            }

        }

    }
    //정규화 -> 모양중에서 가장 최소값 찾아서 빼기
    static List<int[]> normalize(List<int[]> shape){
        List<int[]> list = new ArrayList<>();
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;

        for(int i=0;i<shape.size();i++){
            minX = Math.min(shape.get(i)[0], minX);
            minY = Math.min(shape.get(i)[1], minY);
        }

        for(int i=0;i<shape.size();i++){
            list.add(new int[]{shape.get(i)[0]-minX, shape.get(i)[1]-minY});
        }

        return list;
    }

    static List<int[]> rotate(List<int[]> shape, int n){
        List<int[]> list = new ArrayList<>();
        for(int i=0;i<shape.size();i++){
            int[] p = shape.get(i);
            list.add(new int[]{p[1], n - 1 - p[0]});
        }
        //정규화
        return normalize(list);
    }

    static boolean match(List<int[]> a, List<int[]> b){
        if(a.size() != b.size()) return false;
        a.sort((p1, p2) -> p1[0] == p2[0] ? p1[1] - p2[1] : p1[0] - p2[0]);
        b.sort((p1, p2) -> p1[0] == p2[0] ? p1[1] - p2[1] : p1[0] - p2[0]);
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
