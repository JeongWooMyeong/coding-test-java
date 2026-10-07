package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 집합5 {

    static int M;
    static StringBuilder sb;
    static int mask;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        M = Integer.parseInt(br.readLine());
        mask = 0;
        sb = new StringBuilder();

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            int x = st.hasMoreTokens() ? Integer.parseInt(st.nextToken()) : 0;

            if("add".equals(cmd)){
                mask |= (1<<(x-1));
            }else if("remove".equals(cmd)){
                mask &= ~(1<<(x-1));
            }else if("check".equals(cmd)){
                if((mask & (1<<(x-1))) != 0){
                    sb.append("1");
                }else{
                    sb.append("0");
                }

                sb.append("\n");
            }else if("toggle".equals(cmd)){
                mask ^= (1<<(x-1));
            }else if("all".equals(cmd)){
                mask = (1<<20) - 1;
            }else if("empty".equals(cmd)){
                mask = 0;
            }

        }

        System.out.println(sb);
    }

}
