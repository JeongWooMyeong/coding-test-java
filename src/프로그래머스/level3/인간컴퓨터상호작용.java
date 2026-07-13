package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 인간컴퓨터상호작용 {

    static int[][] prefix;
    static String str;
    static int q;
    static StringBuilder sb;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        str = br.readLine();
        prefix = new int[str.length()+1][26];

        for(int i=1;i<=str.length();i++){
            int idx = str.charAt(i-1) - 'a';

            for(int j=0;j<26;j++){
                int beforeValue = prefix[i-1][j];

                prefix[i][j] = (j == idx ? beforeValue + 1 : beforeValue);
            }

        }

        q = Integer.parseInt(br.readLine());
        sb = new StringBuilder();

        while(q-- > 0){
            st = new StringTokenizer(br.readLine());
            int findIdx = st.nextToken().charAt(0) - 'a';
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            //문제 0based로 주어지므로 유의
            sb.append(prefix[end+1][findIdx] - prefix[start][findIdx]).append("\n");
        }


        System.out.println(sb.toString());

    }

}
