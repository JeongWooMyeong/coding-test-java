package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 퍼즐조각채우기3 {
    static boolean[][] visited;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};

    public static int solution(int[][] game_board, int[][] table){
        int answer = 0;
        int n = game_board.length;


        //빈칸 담기 (bfs, dfs 상관없음)
        List<List<int[]>> blanks = new ArrayList<>();
        visited = new boolean[n][n];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                List<int[]> shape = new ArrayList<>();
                if(!visited[i][j] && game_board[i][j] == 0){
                    bfs(i,j,shape,game_board,visited,0);
                    blanks.add(normalize(shape));
                }
            }
        }

        //block 담기 (bfs, dfs 상관없음)
        List<List<int[]>> blocks = new ArrayList<>();
        visited = new boolean[n][n];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                List<int[]> shape = new ArrayList<>();
                if(!visited[i][j] && table[i][j] == 1){
                    bfs(i,j,shape,table,visited,1);
                    blocks.add(normalize(shape));
                }
            }
        }

        //blank 담은것과 block 비교 해서 칸 채우기
        boolean[] used = new boolean[blocks.size()];

        for(List<int[]> blank : blanks){
            for(int i=0;i<blocks.size();i++){
                if(used[i]) continue;
                List<int[]> block = blocks.get(i);
                if(block.size() != blank.size()) continue;
                boolean matched = false;
                List<int[]> rotated = block;
                for(int r=0;r<4;r++){
                    if(match(blank, rotated)){
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

    static void bfs(int x, int y, List<int[]> shape, int[][] board, boolean[][] visited, int target){
        Queue<int[]> q = new LinkedList<>();
        int n = board.length;
        q.offer(new int[]{x, y});
        visited[x][y] = true;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            shape.add(cur);

            for(int i=0;i<4;i++){
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if(nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                if(!visited[nx][ny] && board[nx][ny] == target){
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx, ny});
                }
            }
        }
    }

    static List<int[]> normalize(List<int[]> shape){
        List<int[]> list = new ArrayList<>();
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;

        for(int i=0;i<shape.size();i++){
            minX = Math.min(shape.get(i)[0], minX);
            minY = Math.min(shape.get(i)[1], minY);
        }

        for(int i=0;i<shape.size();i++){
            list.add(new int[]{shape.get(i)[0] - minX, shape.get(i)[1] - minY});
        }

        return list;
    }
    //90도 시계 회전
    static List<int[]> rotate(List<int[]> shape, int n){
        List<int[]> list = new ArrayList<>();
        for(int i=0;i<shape.size();i++){
            list.add(new int[]{shape.get(i)[1], n - 1 - shape.get(i)[0]});
        }
        //왜 또 정규화 해줘야하지? 아 정규화는 무조건 0,0 으로 맞추는건가
        return normalize(list);
    }

    static boolean match(List<int[]> a, List<int[]> b){
        if(a.size() != b.size()) return false;
        a.sort((p1,p2)->p1[0] == p2[0] ? p1[1] - p2[1] : p1[0] - p2[0]);
        b.sort((p1, p2) ->p1[0] == p2[0] ? p1[1] - p2[1] : p1[0] - p2[0]);
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
