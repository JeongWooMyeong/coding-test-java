package 백준.골드.level5;

import java.util.*;
import java.io.*;

public class 배열돌리기1_2 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][m];

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int layers = Math.min(n, m) / 2;
        for(int layer=0;layer<layers;layer++){
            ArrayList<Integer> list = new ArrayList<>();
            //위
            for(int j = layer;j < m - layer;j++) list.add(arr[layer][j]);
            //오른쪽
            for(int i = layer+1; i < n - layer - 1;i++) list.add(arr[i][m - layer - 1]);
            //아래쪽
            for(int j = m - layer - 1;j >= layer;j--) list.add(arr[n-layer-1][j]);
            //왼쪽
            for(int i= n - layer -2;i > layer;i--) list.add(arr[i][layer]);

            int len = list.size();
            int rotate = r % len;

            //회전된 결과 다시 채워넣기
            int idx = 0;
            //위쪽
            for(int j=layer;j<m-layer;j++) arr[layer][j] = list.get((idx++ + rotate) % len);
            //오른쪽
            for(int i=layer+1; i< n - layer - 1; i++) arr[i][m-layer-1] = list.get((idx++ + rotate) % len);
            //아래쪽
            for(int j=m-layer-1;j>=layer;j--) arr[n-layer-1][j] = list.get((idx++ + rotate) % len);
            //왼쪽
            for(int i=n-layer-2;i>layer;i--) arr[i][layer] = list.get((idx++ + rotate) % len);
        }

        //출력
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb);

    }
}
