package 프로그래머스.level4;

/*
내가 지금 생각해서 푼것은 선형일때는 가능
근데 지금 문제는 원형이므로 경우를 더 생각해야함
X
 */

public class 도둑질2 {
    static int[] dp;
    static int[] dp2;

    public static int solution(int[] money){
        int answer = 0;

        dp = new int[money.length];
        dp2 = new int[money.length];
        int n = money.length;
        //첫번째 집 털었다고 가정/ 그래ㅓ 마지막 집은 털지 않음
        dp[0] = money[0];
        //첫번째 집 털었으므로 돈 그대로
        dp[1] = money[0];
        //마지막 집 제외 (첫번째 집 - 마지막집 이어져 있음)
        for(int i=2;i<n-1;i++){
            dp[i] = Math.max(dp[i-1], dp[i-2] + money[i]);
        }

        //첫번째 집 안털음 - 마지막 집 가능
        dp2[0] = 0;
        dp2[1] = money[1];
        for(int i=2;i<n;i++){
            dp2[i] = Math.max(dp2[i-1], dp2[i-2] + money[i]);
        }

        answer = Math.max(dp[n-2], dp2[n-1]);


        return answer;
    }

    public static void main(String[] args) throws Exception{
        int[] money = {1,2,3,1};
        System.out.println(solution(money));
    }

}
