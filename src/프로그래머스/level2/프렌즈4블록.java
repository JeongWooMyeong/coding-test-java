package 프로그래머스.level2;

public class 프렌즈4블록 {
    static char[][] map;
    static boolean[][] removeSet;

    public static int solution(int m, int n, String[] board) {
        map = new char[m][n];
        //removeSet = new HashSet<>();
        int answer = 0;
        //1. char 2차원 배열에 board String 하나씩 담기
        for (int i = 0; i < m; i++) {
            String line = board[i];
            for (int j = 0; j < n; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        while (true) {
            boolean remove = false;


            removeSet = new boolean[m][n];
            //2. 담은 char 배열 하나씩 돌면서 2x2 만족하는 지 확인하고 제거 list에 넣기 (바로 지우면 안됌)
            for (int i = 0; i < m-1; i++) {
                //if(i == m-1) continue;

                for (int j = 0; j < n-1; j++) {
                    char C = map[i][j];

                    //마지막행은 비교할 수 없음 제외
                    if (C!='.' && map[i][j + 1] == C && map[i + 1][j + 1] == C && map[i + 1][j] == C) {
                        removeSet[i][j] = true;
                        removeSet[i][j+1] = true;
                        removeSet[i+1][j+1] = true;
                        removeSet[i+1][j] = true;
                        remove = true;

                    }



                }
            }

            if (!remove) break;

            //3. 담은 리스트 돌려서 map[i][j] = '.' 로 바꿈 (빈칸표시 난 이렇게 정함)
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    if(removeSet[i][j]){
                        map[i][j] = '.';
                        answer++;
                    }
                }
            }


            // 4. 중력 처리 (정석 버전)
            for (int j = 0; j < n; j++) {
                for (int i = m - 1; i >= 0; i--) {
                    if (map[i][j] == '.') {
                        int k = i - 1;
                        while (k >= 0 && map[k][j] == '.') {
                            k--;
                        }
                        if (k >= 0) {
                            map[i][j] = map[k][j];
                            map[k][j] = '.';
                        }
                    }
                }
            }

        }

//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                if (map[i][j] == '.') answer++;
//            }
//        }

        return answer;
    }

    public static void main(String[] args) throws Exception{
        int m = 4;
        int n = 5;
        String[] board = {"CCBDE", "AAADE", "AAABF", "CCBBF"};
        System.out.println(solution(m,n,board));
    }

}
