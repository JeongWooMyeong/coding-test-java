package 이것이코딩테스트다2.그리디;

import java.util.*;

public class 하나가될때까지2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int result = 1;
        int cnt = 0;

        while(true){
            if(n % k == 0){
                n /= k;
                cnt += 1;
            }else{
                n -= 1;
                cnt += 1;
            }

            if(n == 1) break;

        }

        System.out.println(cnt);

    }
}
