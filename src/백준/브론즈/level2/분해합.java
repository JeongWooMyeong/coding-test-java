package 백준.브론즈.level2;

import java.util.*;

public class 분해합 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int remain = 0;
        int answer = 0;

        for(int j=0;j<n;j++) {
            String num = String.valueOf(j);
            for (int i = 0; i < num.length(); i++) {
                remain += num.charAt(i) - '0';
            }
            if(n == j + remain){
                answer = j;
                break;
            }
            remain = 0;
        }

        System.out.print(answer);

    }
}
