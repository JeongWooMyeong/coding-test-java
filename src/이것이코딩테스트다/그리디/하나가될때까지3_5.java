package 이것이코딩테스트다.그리디;

import java.util.*;
import java.io.*;

public class 하나가될때까지3_5 {
    public static void main(String[] args) throws Exception{
        BufferedReader rc = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(rc.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int cnt = 0;

        while(N>1){
            if(N%K == 0){
                N /= K;
            }else {
                N--;
            }

            cnt++;
        }

        System.out.println(cnt);

    }
}
