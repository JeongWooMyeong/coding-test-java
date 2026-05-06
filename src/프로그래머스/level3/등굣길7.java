package 프로그래머스.level3;

public class 등굣길7 {
    static int[][] dp;
    static int[][] map;

    public static int solution(int m, int n, int[][] puddles){
        dp = new int[n][m];
        map = new int[n][m];
        int mod = 1000000007;

        for(int[] p : puddles){
            int x = p[0];
            int y = p[1];
            map[y-1][x-1] = -1;
        }

        dp[0][0] = 1;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(map[i][j] == -1){
                    dp[i][j] = 0;
                    continue;
                }
                if(i == 0 && j == 0) continue;

                int up = (i > 0) ? dp[i-1][j] : 0;
                int left = (j > 0) ? dp[i][j-1] : 0;

                dp[i][j] = (up+left) % mod;
            }
        }

        return dp[n-1][m-1];
    }

    public static void main(String[] args) throws Exception{
        int m = 4;
        int n = 3;
        int[][] puddles = {{2,2}};

        System.out.println(solution(m,n,puddles));
    }

}
