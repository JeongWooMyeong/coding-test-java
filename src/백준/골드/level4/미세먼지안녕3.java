package 백준.골드.level4;

import java.util.*;
import java.io.*;

public class 미세먼지안녕3 {
    static int R,C,T;
    static int[][] map;
    static int upAir = -1;
    static int downAir = -1;

    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        map = new int[R][C];

        for(int i=0;i<R;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<C;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                //공기청정기는 무조건 1열에 설치
                if(map[i][j] == -1){
                    if(upAir == -1) upAir = i;
                    else if(downAir == -1) downAir = i;
                    //else downAir = i;
                }
            }
        }

        while(T-- > 0){
            //1. 먼지 확산
            spread();
            //2. 공기청정기 작동 (윗방향은 반시계 아래는 시계방향)
            operate();
        }

        int result = 0;
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                if(map[i][j] > 0){
                    result += map[i][j];
                }
            }
        }

        System.out.print(result);


    }

    //1. 먼지 확산
    static void spread(){
        //기존 map과 섞일 수 있으므로 temp 맵 사용
        int[][] temp = new int[R][C];

//        for(int i=0;i<R;i++){
//            temp[i] = map[i].clone();
//        }

        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                //먼지가 있을때
                if(map[i][j] > 0 ){
                    //확산되는 양
                    int amount = map[i][j] / 5;    //확산되는 양
                    int count = 0;  //확산되는 카운트 숫자
                    for(int d=0;d<4;d++){
                        int nx = i + dx[d];
                        int ny = j + dy[d];

                        if(nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
                        if(map[nx][ny] == -1) continue;
                        //다음에 올 확산되는 양 더하기 (겹칠 수 있으므로 +=)
                        temp[nx][ny] += amount;
                        count++;

                    }
                    //여기 temp[i][j]가 아니라 기존 ma[i][j]
                    //남은양도 기존에 값이 있을
                    temp[i][j] += map[i][j] - (amount * count);
                }
            }
        }
        //공기청정기 위치 재설정
        temp[upAir][0] = -1;
        temp[downAir][0] = -1;

        map = temp;
    }
    //확산 처리한 다음 공기청정기 작동
    static void operate(){
        //위층
        for(int i=upAir-1;i>0;i--) map[i][0] = map[i-1][0];
        for(int i=0;i<C-1;i++) map[0][i] = map[0][i+1];
        for(int i=0;i<upAir;i++) map[i][C-1] = map[i+1][C-1];
        for(int i=C-1;i>1;i--) map[upAir][i] = map[upAir][i-1];
        map[upAir][1] = 0;

        //아래층
        for(int i=downAir+1;i<R-1;i++) map[i][0] = map[i+1][0];
        for(int i=0;i<C-1;i++) map[R-1][i] = map[R-1][i+1];
        for(int i=R-1;i>downAir;i--) map[i][C-1] = map[i-1][C-1];
        for(int i=C-1;i>1;i--) map[downAir][i] = map[downAir][i-1];
        map[downAir][1] = 0;


    }

}
