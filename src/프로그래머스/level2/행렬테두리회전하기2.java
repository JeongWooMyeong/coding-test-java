package 프로그래머스.level2;

public class 행렬테두리회전하기2 {
    static int[][] board;
    static int[] answer;

    public static int[] solution(int rows, int columns, int[][] queries){
        board = new int[rows+1][columns+1];
        answer = new int[queries.length];

        int value = 1;
        //rows, columns 배열 채우기
        for(int i=1;i<=rows;i++){
            for(int j=1;j<=columns;j++){
                board[i][j] = value;
                value++;
            }
        }

        for(int i=0;i<queries.length;i++) {
            int[] point = queries[i];
            int x1 = point[0];
            int y1 = point[1];
            int x2 = point[2];
            int y2 = point[3];

            answer[i] = rotate(x1, y1, x2, y2);
        }

        return answer;
    }

    static int rotate(int x1, int y1, int x2, int y2){
        int prev = board[x1][y1];
        int minValue = prev;

        //위
        for(int y=y1+1;y<=y2;y++){
            int temp = board[x1][y];
            board[x1][y] = prev;
            prev = temp;
            minValue = Math.min(minValue, prev);
        }

        //오른쪽
        for(int x=x1+1;x<=x2;x++){
            int temp = board[x][y2];
            board[x][y2] = prev;
            prev = temp;
            minValue = Math.min(minValue, prev);
        }

        for(int y=y2-1;y>=y1;y--){
            int temp = board[x2][y];
            board[x2][y] = prev;
            prev = temp;
            minValue = Math.min(minValue, prev);
        }

        for(int x=x2-1;x>=x1;x--){
            int temp = board[x][y1];
            board[x][y1] = prev;
            prev = temp;
            minValue = Math.min(minValue, prev);
        }


        return minValue;

    }

    public static void main(String[] args) throws Exception{
        int rows = 6;
        int columns = 6;
        int[][] queries = {{2,2,5,4},{3,3,6,6},{5,1,6,3}};

        int[] arr = solution(rows, columns, queries);

        StringBuilder sb = new StringBuilder();

        for(int x : arr){
            sb.append(x).append("\n");
        }

        System.out.println(sb.toString());
    }

}
