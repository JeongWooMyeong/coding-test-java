package 백준.골드.level4;

import java.io.*;
import java.util.*;

public class 가장긴증가하는부분수열3 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] A = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0;i<n;i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[n];
        int[] prev = new int[n];

        Arrays.fill(dp, 1);
        Arrays.fill(prev, -1);

        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                //j에서 i로 이어붙이는게 ㄷ 길면
                if(A[j] < A[i] && dp[j] + 1 > dp[i]){
                    dp[i] = dp[j] + 1;
                    prev[i] = j;
                }
            }
        }

        //LISt 최대 길이 + 끝 인덱스 찾기
        int maxLen = 0;
        int lastIdx = 0;

        for(int i=0;i<n;i++){
            if(dp[i] > maxLen){
                maxLen = dp[i];
                lastIdx = i;
            }
        }

        //경로 역추적
        List<Integer> result = new ArrayList<>();

        while(lastIdx != -1){
            result.add(A[lastIdx]);
            lastIdx = prev[lastIdx];
        }

        Collections.reverse(result);

        //
        StringBuilder sb =new StringBuilder();
        sb.append(maxLen).append("\n");
        for(int num : result){
            sb.append(num).append(" ");
        }

        System.out.print(sb);

    }
}
