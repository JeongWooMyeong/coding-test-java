package 삼성SW역량테스트.골드.level3;

/*
각 드래곤 커브별로 방향 담아서 이걸로 x,y 증가시켜서 방문 처리 하면 되네...
 */
import java.util.*;
import java.io.*;


public class 드래곤커브2 {
    static int N;
    static List<Integer> directions;
    //드래곤 커브 좌표 존재 유무
    static boolean[][] map = new boolean[101][101];

    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,-1,0,1};


    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        //드래곤 커브 입력
        for(int i=0;i<N;i++){
            //이게 몇세대까지 입력하라 이뜻이라는데 솔직히 문제보고 이해 못함)
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());

            drawDragonCurve(x, y, d, g);

        }

        //1x1 정사각형 갯수
        System.out.print(countSquare());

    }

    static void drawDragonCurve(int x, int y, int d, int g){
        List<Integer> directions = new ArrayList<>();
        //0세대 담음
        directions.add(d);

        //1세대부터~ 방향 담음
        int dir = d;
        for(int gen=1;gen<=g;gen++){
            //단순하게 추가하는게 아님 틀림
//            dir = (dir + 1) % 4;
//            directions.add(dir);
            for(int i=directions.size()-1;i>=0;i--){
                directions.add((directions.get(i) + 1) % 4);
            }
        }

        //처음 0세대 true 근데 좌표에서는 y가 x좌표이므로 반대
        map[y][x] = true;
        //이제 방향 계속 돌면서 진행
        int nx = x;
        int ny = y;

        for(int dirs : directions){
            nx += dx[dirs];
            ny += dy[dirs];

            if(nx < 0 || ny < 0 || nx >=101 || ny >= 101) continue;

            map[ny][nx] = true;

        }


    }
    //true 차지한 개수 구하기
    static int countSquare(){
        int count = 0;
        for(int i=0;i<100;i++){
            for(int j=0;j<100;j++){
                if(map[i][j] && map[i+1][j] && map[i][j+1] && map[i+1][j+1]){
                    count++;
                }
            }
        }
        return count;
    }

}
