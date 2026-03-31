package 이것이코딩테스트다2.기출문제.정렬;

import java.util.*;
import java.io.*;

/*
계수 정렬 + 구조체 정렬
 */

public class 실패율 {
    static int N, K;   //스테이지 개수
    static int[] arr;   //스테이지 개수 담을 배열
    static ArrayList<Stage> result = new ArrayList<>(); //스테이지 실패율 담을 리스트

    static class Stage implements Comparable<Stage>{
        int idx;
        double value;

        public Stage(int idx, double value){
            this.idx = idx;
            this.value = value;
        }

        public int compareTo(Stage other){
            if(this.value == other.value) return this.idx - other.idx;
            return Double.compare(other.value, this.value);
        }

    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        arr = new int[N+1];

        st = new StringTokenizer(br.readLine());
        //스테이지 실패 단계 담기 개수
        for(int i=0;i<K;i++){
            int num = Integer.parseInt(st.nextToken());
            if(num > N) continue;
            arr[num] += 1;
        }

        //스테이지 실패율 구해서 담기
        int players = K;
        for(int i=1;i<=N;i++){
            if(arr[i] > 0){
                double fail = (double) arr[i] / players;
                players -= arr[i];

                result.add(new Stage(i, fail));
            }else{
                double fail = 0;
                result.add(new Stage(i, fail));
            }
        }

        Collections.sort(result);

        StringBuilder sb = new StringBuilder();
        for(Stage s : result){
            sb.append(s.idx).append(" ");
        }


        System.out.print(sb);


    }


}
