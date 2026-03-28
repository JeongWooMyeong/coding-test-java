package 이것이코딩테스트다2.기출문제.구현;

public class 자물쇠와열쇠3 {
    static int N, M;    //key, lock 길이

    public static void main(String[] args) throws Exception{
        int[][] key = {
                {0,0,0},
                {1,0,0},
                {0,1,1}
        };
        int[][] lock = {
                {1,1,1},
                {1,1,0},
                {1,0,1}
        };

        System.out.print(solution(key, lock));

    }

    static boolean solution(int[][] key, int[][] lock){
        N = lock.length;
        M = key.length;

        int[][] newboard = new int[N*3][N*3];   //lock 기준으로 배열 3배 정도로 늘림

        //lock을 가운데로 넣음 일단
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                newboard[i+N][j+N] = lock[i][j];
            }
        }

        //lcok 범위까지만 탐색 (이후에는 겹치지 않아서 필요없음)
        for(int r=0;r<4;r++) {
            for (int i = 0; i <= 2 * N; i++) {
                for (int j = 0; j <= 2 * N; j++) {
                    //key 회전
                    key = rotate(key);
                    //key 범위
                    for (int x = 0; x < M; x++) {
                        for (int y = 0; y < M; y++) {
                            newboard[i + x][j + y] += key[x][y];
                        }
                    }

                    //키를 다 넣고 비교 (다 1이면 true)
                    if (lockCheck(newboard, N)) return true;

                    //아니면 key 다시 뺌
                    for (int x = 0; x < M; x++) {
                        for (int y = 0; y < M; y++) {
                            newboard[i + x][j + y] -= key[x][y];
                        }
                    }
                }
            }
        }
        return false;
    }

    static int[][] rotate(int[][] key){
        int N = key.length;
        int[][] rotated = new int[N][N];
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                rotated[j][N - i - 1] = key[i][j];
            }
        }

        return rotated;
    }
    //lock에 대해서 유효한지 체크
    static boolean lockCheck(int[][] lock, int N){
        for(int i=N;i<2*N;i++){
            for(int j=N;j<2*N;j++){
                if(lock[i][j] != 1) return false;
            }
        }

        return true;
    }

}
