package 백준.실버.level3;

import java.io.*;
import java.util.*;

public class 하나둘셋더하기 {
    static int T;
    static int[] d = new int[11];

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        // 4를 예시로 줬으니까 3까지 구한다음에 점화식 구하면 되네..
        d[0] = 0;
        d[1] = 1;
        d[2] = 2;
        d[3] = 4;
        for(int i=4;i<11;i++){
            d[i] = d[i-3] + d[i-2] + d[i-1];
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<T;i++){
            int num = Integer.parseInt(br.readLine());
            sb.append(d[num]).append("\n");
        }

        System.out.print(sb);

    }

}
