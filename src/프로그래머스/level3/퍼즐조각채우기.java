package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 퍼즐조각채우기 {
    static boolean[][] visited;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};

    public static int solution(int[][] game_board, int[][] table){
        int answer = 0;
        int n = game_board.length;

        //빈칸 모음
        List<List<int[]>> blanks = new ArrayList<>();
        visited = new boolean[n][n];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                List<int[]> shape = new ArrayList<>();
                if(!visited[i][j] && game_board[i][j] == 0) {
                    dfs(i, j, shape, visited, game_board, 0);
                    //좌표를 어떻게 쓰지? 다른곳에서도 쓸려면?
                    blanks.add(normalize(shape));
                }
            }
        }

        //table 블럭 모음
        List<List<int[]>> blocks = new ArrayList<>();
        visited = new boolean[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                List<int[]> shape = new ArrayList<>();
                if(!visited[i][j] && table[i][j] == 1){
                    dfs(i, j, shape, visited, table, 1);
                    //근데 이게 좌표가 지금 좌표로는 쓸수 없는데 어떻게?
                    //현재 좌표로는 쓸 수 ㅇ벗느 ㅣ정규화 과정 필요
                    blocks.add(normalize(shape));
                }
            }
        }

        //이제 blank, block 가지고 매칭
        boolean[] used = new boolean[blocks.size()];    //사용
        for(List<int[]> blank : blanks){
            for(int i=0;i<blocks.size();i++){
                if(used[i]) continue;
                List<int[]> block = blocks.get(i);
                //블락 사이즈랑 blank 사이즈 안맞으면 넣을 수 없으므로 continue;
                if(block.size() != blank.size()) continue;

                boolean matched = false;
                List<int[]> rotated = block;
                for(int r=0;r<4;r++){
                    if(match(blank, rotated)){
                        answer += blank.size();
                        used[i] = true;
                        matched = true;
                        break;
                    }
                    rotated = rotate(rotated, n);
                }
                if(matched) break;
            }
        }


        return answer;
    }

    static void dfs(int x, int y, List<int[]> shape, boolean[][] visited, int[][] board, int target){
        int n = board.length;
        visited[x][y] = true;
        shape.add(new int[]{x,y});
        for(int i=0;i<4;i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx < 0 || ny < 0 || nx >= n || ny >= n) continue;

            if(!visited[nx][ny] && board[nx][ny] == target){
                dfs(nx,ny,shape, visited, board, target);
            }
        }
    }
    //좌표로된 블락 및 blank 정규화 (쓰기 위해서)
    static List<int[]> normalize(List<int[]> shape){
        List<int[]> list = new ArrayList<>();
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;

        for(int i=0;i<shape.size();i++){
            int[] s = shape.get(i);
            minX = Math.min(minX, s[0]);
            minY = Math.min(minY, s[1]);
        }

        for(int i=0;i<shape.size();i++){
            int[] s = shape.get(i);
            list.add(new int[]{s[0]-minX, s[1]-minY});
        }


        return list;
    }
    //90도 회전 후 좌표 정규화
    static List<int[]> rotate(List<int[]> shape, int n){
        List<int[]> result = new ArrayList<>();
        for(int[] p : shape){
            result.add(new int[]{p[1], n-1-p[0]});
        }
        return normalize(result);
    }
    //a,b 비교할때 정렬 해서 다 같으면 true
    static boolean match(List<int[]> a , List<int[]> b){
        if(a.size() != b.size()) return false;
        a.sort((p1,p2)->p1[0] == p2[0] ? p1[1] - p2[1] : p1[0] - p2[0]);
        b.sort((p1,p2)->p1[0] == p2[0] ? p1[1] - p2[1] : p1[0] - p2[0]);

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
