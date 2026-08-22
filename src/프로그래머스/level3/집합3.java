package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 집합3 {

    static int M;
    static StringBuilder sb;
    static int mask;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        M = Integer.parseInt(br.readLine());
        sb = new StringBuilder();
        mask = 0;

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            int x = st.hasMoreTokens() ? Integer.parseInt(st.nextToken()) : 0;

            if("add".equals(command)){
                mask |= (1<<(x-1));
            }else if("remove".equals(command)){
                mask &= ~(1<<(x-1));
            }else if("check".equals(command)){
                if((mask & (1<<(x-1))) != 0){
                    sb.append("1");
                }else{
                    sb.append("0");
                }

                sb.append("\n");

            }else if("toggle".equals(command)){
                mask ^= (1<<(x-1));
            }else if("all".equals(command)){
                mask = (1<<20) - 1;
            }else if("empty".equals(command)){
                mask = 0;
            }

        }

        System.out.println(sb);

    }

}
