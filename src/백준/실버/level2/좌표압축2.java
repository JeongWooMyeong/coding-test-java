package 백준.실버.level2;

import java.util.*;
import java.io.*;

//좌표압축은 좌표 값이 적은 순서로 순서 매기는걸 의미

public class 좌표압축2 {
    static HashSet<Integer> set = new HashSet<>();
    static int[] arr;
    static List<Integer> list = new ArrayList<>();
    static int N;
    static Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
            set.add(num);
        }

        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        for(int i=0;i<list.size();i++){
            map.put(list.get(i), i);
        }

        StringBuilder sb = new StringBuilder();
        for(int x : arr){
            sb.append(map.get(x)).append(" ");
        }

        System.out.print(sb);

    }


}
