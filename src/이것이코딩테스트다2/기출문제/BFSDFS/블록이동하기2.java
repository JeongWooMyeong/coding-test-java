package 이것이코딩테스트다2.기출문제.BFSDFS;

import java.util.*;
import java.io.*;

public class 블록이동하기2 {
    static int N;
    static int[][] map;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    static class Robot{
        int x1;
        int y1;
        int x2;
        int y2;
        int dist;

        public Robot(int x1, int y1, int x2, int y2, int dist){
            this.x1 = x1;
            this.y1= y1;
            this.x2 = x2;
            this.y2 = y2;
            this.dist = dist;
        }

    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        //맵 정보 입력
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        //로봇 이동
        System.out.print(bfs());


    }

    static int bfs(){
        Queue<Robot> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();  //로봇상태 저장
        q.add(new Robot(0,0,0,1,0));
        visited.add("0,0,0,1");

        while(!q.isEmpty()){
            Robot cur = q.poll();
            int x1 = cur.x1;
            int y1 = cur.y1;
            int x2 = cur.x2;
            int y2 = cur.y2;
            int dist = cur.dist;
            //종료 조건
            if((cur.x1 == N-1 && cur.y1 == N-1) || (cur.x2 == N-1 && cur.y2 == N-1)){
                return cur.dist;
            }

            //상하좌우 이동
            for(int i=0;i<4;i++){
                int nx1 = x1 + dx[i];
                int ny1 = y1 + dy[i];
                int nx2 = x2 + dx[i];
                int ny2 = y2 + dy[i];

                if(canMove(nx1, ny1) && canMove(nx2, ny2)){
                    String key = nx1+","+ny1+","+nx2+","+ny2;
                    if(!visited.contains(key)) {
                        visited.add(key);
                        q.offer(new Robot(nx1, ny1, nx2, ny2, dist + 1));
                    }
                }

            }

            //회전 (로봇 가로, 세로 방향일때 고려)
            if(cur.x1 == cur.x2)    //로봇 가로 상태
            {
                //위 아래 회전
                for(int d=-1;d<=1;d+=2){
                    if(canMove(cur.x1+d, cur.y1) && canMove(cur.x2+d, cur.y1)){
                        //첫번째 블록 회전
                        String key = (cur.x1+d)+","+cur.y1+","+cur.x1+","+cur.y1;
                        if(!visited.contains(key)){
                            visited.add(key);
                            q.offer(new Robot(cur.x1+d, cur.y1, cur.x1, cur.y1, cur.dist+1));
                        }
                        //두번째 블록 축 회전
                        String key2 = (cur.x2+d)+","+cur.y1+","+cur.x2+","+cur.y2;
                        if(!visited.contains(key)){
                            visited.add(key);
                            q.offer(new Robot(cur.x2+d, cur.y2, cur.x2, cur.y2, cur.dist+ 1));
                        }
                    }
                }
            }else{  //로봇 세로 상태
                //좌우
                for(int d=-1;d<=1;d+=2){
                    if(canMove(cur.x1, cur.y1+d) && canMove(cur.x2, cur.y2+d)){
                        //첫번째 축
                        String key = cur.x1+","+(cur.y1+d)+","+cur.x1+","+cur.y1;
                        if(!visited.contains(key)){
                            visited.add(key);
                            q.add(new Robot(cur.x1, cur.y1+d, cur.x1, cur.y1, cur.dist+1));
                        }
                        //두번째 축
                        String key2 = cur.x2+","+(cur.y2+d)+","+cur.x2+","+cur.y2;
                        if(!visited.contains(key2)){
                            visited.add(key2);
                            q.add(new Robot(cur.x2, cur.y2+d, cur.x2, cur.y2, cur.dist+1));
                        }
                    }
                }
            }

        }
        return -1;
    }

    static boolean canMove(int x, int y){
        return x>=0 && y>=0 && x<N && y<N && map[x][y] == 0;
    }


}
