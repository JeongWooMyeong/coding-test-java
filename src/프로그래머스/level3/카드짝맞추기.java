package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 카드짝맞추기 {

    static int[][] dist;
    static boolean[] visited;
    static int n = 4;
    static List<List<Integer>> orders;
    static Map<Integer, List<int[]>> map;
    static boolean[][] visited2;

    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};


    public static int solution(int[][] board, int r, int c){

        int answer = Integer.MAX_VALUE;

        //1. 해당 카드 위치 좌표 수집
        map = getCardPosition(board);

        //2. 순열 생성 총 1~6까지 2쌍이므로 3개
        List<Integer> cardTypes = new ArrayList<>(map.keySet());
        visited = new boolean[cardTypes.size()];
        orders = new ArrayList<>();
        permute(0, new ArrayList<>(), cardTypes);

        //3. 카드 순열 돌면서 최소 비용 찾기
        for(List<Integer> order : orders){
            answer = Math.min(answer , dfs(r,c,order,0,board));
        }

        //bfs(r,c,board);
        //StringBuilder sb = new StringBuilder();
        return answer;
    }

    static Map<Integer, List<int[]>> getCardPosition(int[][] board){
        Map<Integer, List<int[]>> result = new HashMap<>();
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                if(board[i][j] != 0){
                    result.putIfAbsent(board[i][j], new ArrayList<>());
                    result.get(board[i][j]).add(new int[]{i,j});
                }
            }
        }

        return result;
    }

    static void permute(int idx, ArrayList<Integer> list, List<Integer> cardTypes){

        if(idx == cardTypes.size()){
            orders.add(new ArrayList<>(list));
            return;
        }

        for(int i=0;i<cardTypes.size();i++){
            if(!visited[i]) {
                visited[i] = true;
                list.add(cardTypes.get(i));
                permute(idx+1, list, cardTypes);
                visited[i] = false;
                list.remove(list.size()-1);
            }
        }


    }
    //카드 제거 로직
    static int dfs(int x, int y, List<Integer> order, int idx, int[][] board){
        if(idx == order.size()) return 0;

        int card = order.get(idx);
        List<int[]> pos = map.get(card);
        int[] p1 = pos.get(0);
        int[] p2 = pos.get(1);

        //경우1. p1 -> p2
        int cost1 = bfs(board, x, y, p1[0], p1[1]) + bfs(board, p1[0], p1[1], p2[0], p2[1]) + 2;
        board[p1[0]][p1[1]] = 0; board[p2[0]][p2[1]] = 0;
        int res1 = cost1 + dfs(p2[0], p2[1], order, idx+1, board);
        board[p1[0]][p1[1]] = card; board[p2[0]][p2[1]] = card;

        //경우2. p2 -> p1 +2는 엔터입력 (삭제)
        int cost2 = bfs(board, x, y, p2[0], p2[1]) + bfs(board, p2[0], p2[1], p1[0], p1[1]) + 2;
        board[p1[0]][p1[1]] = 0; board[p2[0]][p2[1]] = 0;
        int res2 = cost2 + dfs(p1[0], p1[1], order, idx+1, board);
        board[p1[0]][p1[1]] = card; board[p2[0]][p2[1]] = card;


        return Math.min(res1, res2);

    }

    static int bfs(int[][] board, int startX, int startY, int endX, int endY){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{startX, startY, 0});
        dist = new int[4][4];
        visited2 = new boolean[4][4];

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            int count = cur[2];
            if(x == endX && y == endY) return count;

            for(int i=0;i<4;i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || ny < 0 || nx >= 4 || ny >= 4) continue;

                if(!visited2[nx][ny]){
                    visited2[nx][ny] = true;
                    q.offer(new int[]{nx,ny,count+1});
                }

            }

            for(int i=0;i<4;i++){
                int nx = x;
                int ny = y;
                while(true){
                    int tx2 = nx + dx[i], ty2 = ny + dy[i];
                    if(tx2 < 0 || ty2 < 0 || tx2 >= 4 || ty2 >= 4) break;
                    nx = tx2; ny = ty2;
                    if(board[nx][ny] != 0) break;
                }

                if(!visited2[nx][ny]){
                    visited2[nx][ny] = true;
                    q.offer(new int[]{nx,ny,count+1});
                }


            }

        }

        return Integer.MAX_VALUE;

    }

    public static void main(String[] args) throws Exception{
        int[][] board = {{1,0,0,3},{2,0,0,0},{0,0,0,2},{3,0,1,0}};
        int r = 1;
        int c = 0;
        System.out.println(solution(board,r,c));
    }

}
