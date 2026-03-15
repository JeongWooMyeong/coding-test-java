package 백준.골드.level4;

import java.io.*;
import java.util.*;

public class 미세먼지안녕 {
    static int r, c, t; //행, 열, 시간
    static int[][] map; //방 상태 (미세먼지 양, 공기청정기 위치)
    static int airTop, airBottom;   //공기 청정기 위치 (위쪽, 아래쪽)
    static int[] dx = {-1, 1, 0, 0};    //상 하 좌 우 이동
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException{
        //빠른 입력을 위한 BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //첫 줄 입력 : r(행) c(열) t (시간)
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        map = new int[r][c];    //방 상태 배열 초기화

        //방 상태 입력
        for(int i=0;i<r;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<c;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                //공기청정기 위치 저장 (-1이 공기청정기)
                if(map[i][j] == -1){
                    if(airTop == 0) airTop = i; //첫번째 -1은 위쪽 청정기
                    else airBottom = i; // 두번째 -1은 아래쪽 청정기
                }
            }
        }

        //T초 동안 시뮬레이션 반복
        for(int i=0;i<t;i++){
            spreadDust();   //1. 먼지 확산
            operateCleaner();   //2. 공기청정기 작동
        }

        //최종 먼지 합 출력
        System.out.println(countDust());
    }

    //1. 먼지 확산
    static void spreadDust(){
        int[][] temp = new int[r][c];   //임시 배열 (동시 확산)

        for(int x=0;x<r;x++){
            for(int y=0;y<c;y++){
                if(map[x][y] > 0){
                    //먼지가 있는 칸만 처리
                    int amount = map[x][y] / 5; //퍼질 양
                    int cnt = 0;    //퍼진 방향 개수

                    //네 방향으로 확산
                    for(int d=0;d<4;d++){
                        int nx = x + dx[d], ny = y + dy[d];
                        //범위 밖이거나 공기청정기면 확산 불가
                        if(nx < 0 || ny < 0 || nx >= r || ny >= c) continue;
                        if(map[nx][ny] == -1) continue;

                        temp[nx][ny] += amount; //옆 칸에 확산
                        cnt++;
                    }

                    //원래 칸에 남은 먼지 = 기존 - (퍼진양 * 방향 수)
                    temp[x][y] += map[x][y] - amount * cnt;

                }
            }
        }

        //temp 결과를 map에 반영
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(map[i][j] != -1) map[i][j] = temp[i][j]; //청정기는 그대로
            }
        }
    }

    //2. 공기 청정기 작동
    static void operateCleaner(){
        //위쪽 (반시계 방향 순환)
        for(int i=airTop - 1;i>0;i--) map[i][0] = map[i-1][0];  // 위로 당김
        for(int j=0;j<c-1;j++) map[0][j] = map[0][j+1]; //왼 -> 오
        for(int i=0;i<airTop;i++) map[i][c-1] = map[i+1][c-1];  //아래로 당김
        for(int j=c-1;j>1;j--) map[airTop][j] = map[airTop][j-1];   //오 -> 왼
        map[airTop][1] = 0; //청정기로 들어간 먼지는 제거

        //아래쪽 (시계방향 순환0
        for(int i=airBottom +1;i<r-1;i++) map[i][0] = map[i+1][0];  //아래로 당김
        for(int j=0;j<c-1;j++) map[r-1][j] = map[r-1][j+1];
        for(int i=r-1;i>airBottom;i--) map[i][c-1] = map[i-1][c-1]; //위로 당김
        for(int j=c-1;j>1;j--) map[airBottom][j] = map[airBottom][j-1]; //오->왼
        map[airBottom][1] = 0;  //ㅊㅇ정기로 들어간 먼지는 제거
    }

    //3. 남은 먼지 합 계산
    static int countDust(){
        int sum = 0;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(map[i][j] > 0) sum += map[i][j]; //먼지 양 합산

            }
        }
        return sum;
    }
}
