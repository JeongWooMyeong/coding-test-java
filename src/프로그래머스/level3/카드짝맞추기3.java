package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 카드짝맞추기3 {
    static Map<Integer, List<int[]>> card;
    static int n,m;
    static List<List<Integer>> orders;
    static boolean[] visited1;
    static int answer;
    static boolean[][] visited2;
    static int[][] dist;

    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};

    public static int solution(int[][] board, int r, int c){
        n = board.length;
        m = board[0].length;
        answer = Integer.MAX_VALUE;
        //1. 카드 좌표 구하기
        card = getCardPosition(board);

        //2. 구한 카드 좌표 가지고 카드 제거 순서 정하기 (순열)
        orders = new ArrayList<>();
        List<Integer> order = new ArrayList<>(card.keySet());
        visited1 = new boolean[order.size()];
        permute(0,new ArrayList<>(), order);

        //3. 정한 카드 제거 순서에 따라서 최소비용 구하기 dfs
        for(List<Integer> ord : orders){
            answer = Math.min(answer, dfs(r,c,ord,0,board));
        }


        return answer;
    }

    static Map<Integer, List<int[]>> getCardPosition(int[][] board){
        Map<Integer, List<int[]>> result = new HashMap<>();

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j] != 0){
                    result.putIfAbsent(board[i][j], new ArrayList<>());
                    result.get(board[i][j]).add(new int[]{i,j});
                }
            }
        }

        return result;
    }

    static void permute(int idx, List<Integer> list, List<Integer> order){
        if(idx == order.size()){
            orders.add(new ArrayList<>(list));
            return;
        }

        for(int i=0;i<order.size();i++){
            if(!visited1[i]){
                visited1[i] = true;
                list.add(order.get(i));
                permute(idx+1, list, order);
                visited1[i] = false;
                list.remove(list.size()-1);
            }
        }

    }

    static int dfs(int x, int y, List<Integer> order, int idx, int[][] board){

        if(idx == order.size()) return 0;

        int cardnum = order.get(idx);
        List<int[]> pos = card.get(cardnum);

        int[] p1 = pos.get(0);
        int[] p2 = pos.get(1);

        //1. x,y -> p1 -> p2
        int cost1 = bfs(x,y,p1[0],p1[1],board) + bfs(p1[0],p1[1],p2[0],p2[1],board) + 2;
        board[p1[0]][p1[1]] = 0; board[p2[0]][p2[1]] = 0;
        int res1 = cost1 + dfs(p2[0],p2[1], order, idx+1, board);
        board[p1[0]][p1[1]] = cardnum; board[p2[0]][p2[1]] = cardnum;

        //2. x,y, -> p2 -> p1
        int cost2 = bfs(x,y,p2[0],p2[1],board) + bfs(p2[0],p2[1],p1[0],p1[1],board) + 2;
        board[p1[0]][p1[1]] =0; board[p2[0]][p2[1]] = 0;
        int res2 = cost2 + dfs(p1[0],p1[1], order, idx+1,board);
        board[p1[0]][p1[1]] =cardnum; board[p2[0]][p2[1]] = cardnum;

        return Math.min(res1, res2);
    }

    static int bfs(int startX, int startY, int endX, int endY, int[][] board){
        Queue<int[]> q = new LinkedList<>();
        visited2 = new boolean[n][n];
        dist = new int[n][n];
        q.offer(new int[]{startX, startY});
        visited2[startX][startY] = true;
        dist[startX][startY] = 0;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            if(x == endX && y == endY) return dist[x][y];
            //4방향
            for(int i=0;i<4;i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if(!visited2[nx][ny]){
                    visited2[nx][ny] = true;
                    dist[nx][ny] = dist[x][y] + 1;
                    q.offer(new int[]{nx,ny});
                }
            }
            //CTRL방향
            for(int i=0;i<4;i++){
                int nx = x;
                int ny = y;
                while(true){
                    int tx2 = nx + dx[i];
                    int ty2 = ny + dy[i];
                    if(tx2 < 0 || ty2 < 0 || tx2 >= n || ty2 >= m) break;

                    nx = tx2;
                    ny = ty2;

                    if(board[nx][ny] != 0) break;
                }

                if(!visited2[nx][ny]){
                    visited2[nx][ny] = true;
                    dist[nx][ny] = dist[x][y] + 1;
                    q.offer(new int[]{nx,ny});
                }

            }
        }
        return -1;

    }


    public static void main(String[] args) throws Exception{
        int[][] board = {{1,0,0,3},{2,0,0,0},{0,0,0,2},{3,0,1,0}};
        int r = 1;
        int c = 0;
        System.out.println(solution(board,r,c));
    }



}
