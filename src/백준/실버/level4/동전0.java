package 백준.실버.level4;

import java.util.*;

public class 동전0 {
    public static int n, k;
    public static Integer[] money;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        money = new Integer[n];

        for(int i=0;i<n;i++){
            money[i] = sc.nextInt();
        }

        Arrays.sort(money, Collections.reverseOrder());

        int sum = 0;
        for(int i=0;i<n;i++){
            if(money[i] <= k){
                sum += k / money[i];
                //k = k % money[i];
                k %= money[i];
                if(k == 0) break;
            }
        }

        System.out.print(sum);

    }
}
