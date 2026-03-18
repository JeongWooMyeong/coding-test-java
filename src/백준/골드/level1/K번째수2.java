package 백준.골드.level1;

import java.io.*;

//첫번째 방법으로는 메모리 부족 에러.

public class K번째수2 {
    static int N, K;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        long left = 1, right = K, answer = 0;

        while(left <= right){
            long mid = (left + right) / 2;
            long count = 0;

            //mid 이하의 숫자가 몇개인지 계싼
            for(int i=1;i<=N;i++){
                count += Math.min(mid / i, N);
            }

            if(count >= K){
                answer = mid;
                right = mid -1;
            }else{
                left = mid + 1;
            }
        }


        System.out.println(answer);
    }

}
