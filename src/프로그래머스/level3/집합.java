package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 집합 {

    static int M;
    static StringBuilder sb;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        sb = new StringBuilder();

        M = Integer.parseInt(br.readLine());
        int bitmask = 0;
        int x = 0;

        for(int i=0;i<M;i++){
            //StringTokenizer로 할걸..
            String[] cmd = br.readLine().split(" ");
            if(cmd.length > 1) {
                x = Integer.parseInt(cmd[1]);
            }

            if(cmd[0].equals("add")){
                bitmask |= (1 << (x-1));
            }else if(cmd[0].equals("remove")){
                bitmask &= ~(1 << (x-1));
            }else if(cmd[0].equals("check")){
                if((bitmask & (1 << (x-1))) != 0){
                    sb.append("1");
                }else{
                    sb.append("0");
                }

                sb.append("\n");
            }else if(cmd[0].equals("toggle")){
                bitmask ^= (1 << (x-1));
            }else if(cmd[0].equals("all")){
                bitmask = (1 << 20) - 1;
            }else{
                bitmask = 0;
            }

        }

        System.out.println(sb);

    }

}
