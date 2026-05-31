package 프로그래머스.level3;

public class 최적의행렬곱셈3 {

    static int[][] dp;
    static int n;

    public static int solution(int[][] matrix_sizes){
        n = matrix_sizes.length;

        dp = new int[n][n];

        for(int i=0;i<n;i++){
            dp[i][i] = 0;
        }

        for(int len=2;len<=n;len++){
            for(int i=0;i<=n-len;i++){
                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE;
                for(int k=i;k<j;k++){
                    int cost = dp[i][k]
                            +dp[k+1][j]
                            + matrix_sizes[i][0]
                            * matrix_sizes[k][1]
                            * matrix_sizes[j][1];

                    dp[i][j] = Math.min(dp[i][j], cost);
                }
            }
        }


        return dp[0][n-1];
    }

    public static void main(String[] args) throws Exception{
        int[][] matrix_sizes = {{5,3},{3,10},{10,6}};
        System.out.println(solution(matrix_sizes));
    }

}
