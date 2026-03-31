package 이것이코딩테스트다2.기출문제.BFSDFS;

import java.util.*;

public class 블록이동하기 {
    static int N;
    static int[][] board;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    static class Robot{
        int x1, y1, x2, y2, time;
        public Robot(int x1, int y1, int x2, int y2, int time){
            this.x1 = x1;
            this.x2 = x2;
            this.time = time;
            this.y1 = y1;
            this.y2 = y2;
        }

    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        board = new int[N][N];
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                board[i][j] = sc.nextInt();
            }
        }

        System.out.println(bfs());

    }

    static int bfs(){
        Queue<Robot> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        Robot start = new Robot(0,0,0,1,0);
        q.offer(start);
        visited.add(hash(start));

        while(!q.isEmpty()){
            Robot cur = q.poll();

            //목표 도달 조건
            if((cur.x1 == N-1 && cur.y1 == N-1) || (cur.x2 == N-1 && cur.y2 == N-1)){
                return cur.time;
            }

            //4방햐 이동
            for(int d=0;d<4;d++){
                int nx1 = cur.x1 + dx[d];
                int ny1 = cur.y1 + dy[d];
                int nx2 = cur.x2 + dx[d];
                int ny2 = cur.y2 + dy[d];

                if(isValid(nx1, ny1) && isValid(nx2, ny2)){
                    Robot next = new Robot(nx1, ny1, nx2, ny2, cur.time+1);
                    if(!visited.contains(hash(next))){
                        visited.add(hash(next));
                        q.offer(next);
                    }
                }

            }

            //회전
            if(cur.x1 == cur.x2){   //가로 상태
                for(int dir=-1;dir<=1;dir+=2){
                    //위 (-1) 아래 (+1)
                    if(isValid(cur.x1+dir, cur.y1) && isValid(cur.x2+dir, cur.y2)){
                        Robot r1 = new Robot(cur.x1, cur.y1, cur.x1+dir, cur.y1, cur.time+1);
                        Robot r2 = new Robot(cur.x2, cur.y2, cur.x2+dir, cur.y2, cur.time+1);
                        if(!visited.contains(hash(r1))){ visited.add(hash(r1)); q.offer(r1);}
                        if(!visited.contains(hash(r2))){ visited.add(hash(r2)); q.offer(r2);}
                    }
                }
            } else if(cur.y1 == cur.y2){
                //세로 상태
                for(int dir=-1;dir<=1;dir+=2){
                    //왼쪽 -1 오른쪽 +1
                    if(isValid(cur.x1, cur.y1+dir) && isValid(cur.x2, cur.y2+dir)){
                        Robot r1 = new Robot(cur.x1, cur.y1, cur.x1, cur.y1+dir, cur.time+1);
                        Robot r2 = new Robot(cur.x2, cur.y2, cur.x2, cur.y2+dir, cur.time+1);
                        if(!visited.contains(hash(r1))){ visited.add(hash(r1)); q.offer(r1);}
                        if(!visited.contains(hash(r2))){ visited.add(hash(r2)); q.offer(r2);}
                    }
                }
            }

        }
        return -1;  //도달 불가
    }

    static boolean isValid(int x, int y){
        return x>=0 && y>=0 && x < N && y < N && board[x][y] ==0;
    }

    static String hash(Robot r){
        //두 칸 좌표를 정렬해서 상태를 유일하게 표현
        int ax = r.x1, ay = r.y1, bx = r.x2, by = r.y2;
        if(ax > bx || (ax==bx && ay>by)){
            int tmpx = ax, tmpy=ay;
            ax=bx; ay=by; bx=tmpx; by=tmpy;
        }
        return ax+","+ay+","+bx+","+by;
    }

}
