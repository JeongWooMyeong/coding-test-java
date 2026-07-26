package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 인간컴퓨터상호작용2 {

    static int[][] prefix;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String str = br.readLine();

        prefix = new int[str.length()+1][26];

        for(int i=1;i<prefix.length;i++){
            int idx = str.charAt(i-1) - 'a';
            for(int j=0;j<26;j++){
                int beforeValue = prefix[i-1][j];

                prefix[i][j] = idx == j ? beforeValue+1 : beforeValue;
            }
        }

        int q = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while(q-- > 0){
            st = new StringTokenizer(br.readLine());
            int idx = st.nextToken().charAt(0) - 'a';
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            sb.append(prefix[end+1][idx] - prefix[start][idx]).append("\n");
        }

        System.out.println(sb.toString());

    }

}
