package 백준.실버.level3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N과M260410_8 {
    static int N, M;
    static int[] arr;
    static int[] selected;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        selected = new int[M];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        dfs(0, 0);

        System.out.print(sb.toString());


    }

    static void dfs(int start, int idx){
        if(idx == M){
            for(int i=0;i<M;i++){
                sb.append(selected[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        //start부터 시작해야함
        for(int i=start;i<N;i++){
            selected[idx] = arr[i];
            dfs(i, idx+1);
        }

    }

}
