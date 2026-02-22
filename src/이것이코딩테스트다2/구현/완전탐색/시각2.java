package 이것이코딩테스트다2.구현.완전탐색;

import java.util.*;

public class 시각2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        String result = "";
        int cnt = 0;
        for(int k=0;k<n+1;k++) {
            String time = k + "";
            for (int i = 0; i < 60; i++) {
                String min = i + "";
                for (int j = 0; j < 60; j++) {
                    String second = j + "";
                    result = time + min + second;
                    if (result.contains("3")) {
                        cnt++;
                    }
                }
            }
        }

        System.out.println(cnt);



    }
}
