package 백준.실버.level2;

import java.util.*;
import java.io.*;

public class 좌표압축 {
    static int n;
    static int[] arr;
    //map 저장 (순서)
    static HashMap<Integer, Integer> map = new HashMap<>();
    //중복 제거 set
    static HashSet<Integer> set = new HashSet<>();

    public static void main(String[] args) throws IOException{
        //Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        //n = sc.nextInt();
        arr = new int[n];
        //배열에 담고 그 값을 set에 add
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            //arr[i] = sc.nextInt();
            arr[i] = Integer.parseInt(st.nextToken());
            set.add(arr[i]);
        }
        //set을 list로 변환 후 정렬
        ArrayList<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        //list를 map에 저장 (인덱스 구하기 위해)
        for(int i=0;i<list.size();i++){
            map.put(list.get(i), i);
        }
        //출력
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            sb.append(map.get(arr[i])).append(" ");
        }

        System.out.print(sb);

    }

}
