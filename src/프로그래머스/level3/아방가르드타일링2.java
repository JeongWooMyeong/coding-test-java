package 프로그래머스.level3;

public class 아방가르드타일링2 {
    static final long MOD = 1_000_000_007;

    public static int solution(int n) {
        long[] dp = new long[n + 1];

        dp[0] = 1;

        if (n >= 1) dp[1] = 1;
        if (n >= 2) dp[2] = 3;
        if (n >= 3) dp[3] = 10;
        if (n >= 4) dp[4] = 23;
        if (n >= 5) dp[5] = 62;

        for (int i = 6; i <= n; i++) {
            dp[i] = dp[i - 1]
                    + (2 * dp[i - 2]) % MOD
                    + (6 * dp[i - 3]) % MOD
                    + dp[i - 4]
                    - dp[i - 6];

            dp[i] %= MOD;
            if (dp[i] < 0) dp[i] += MOD;
        }

        return (int) dp[n];
    }

    public static void main(String[] args) throws Exception{
        int n = 4;
        System.out.println(solution(n));
    }

}
