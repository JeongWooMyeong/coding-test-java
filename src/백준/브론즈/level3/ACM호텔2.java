package 백준.브론즈.level3;

import java.util.*;
import java.io.*;

public class ACM호텔2 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while(t-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());

            int floor  = N % H; //층수
            int room = N / H + 1;   //호수 (나ㅓ지가 있으면?)

            if(floor == 0){
                floor = H;
                room = N / H;
            }

            System.out.println("floor:"+floor);
            System.out.println("room:"+room);

            sb.append(floor);
            if(room < 10) sb.append("0");
            sb.append(room).append("\n");
        }

        System.out.print(sb);
    }
}
