package 백준.골드.level5;

import java.util.*;

public class ZOAC2 {

    //문자열에 대한 문자 와야하니 문자열 배열 지정
    static char[] c;
    // 해당 문자 처리 flag
    static boolean[] visited;
    //사전순으로 가장 작은 문자열을 구해야함
    //가장 작은 문자열을 기준으로 왼쪽, 오른쪽 재귀 함수 실행
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        //toCharArray로 문자 배열 구성
        c = sc.nextLine().toCharArray();
        visited = new boolean[c.length];

        search(0, c.length);

    }
    //문자 배열 기준으로 가장 작은 문자열을 찾는다.
    static void search(int start, int end){
        //구간이 비면 종료
        if(start >= end) return;
        int min_index = -1;
        //이렇게 하면 무조건 최소 문자만 가지므로
        //start, end에 대해서 처리하는게 맞음
        for(int i=start;i<end;i++){
            //이미 방문한 문자는 제외 왜? 이건 상간없지 않나
            if(!visited[i]) {
                if (min_index == -1 || c[min_index] > c[i]) {
                    min_index = i;
                }
            }
        }
        //근데 처리한 문자열에 대해서는 하면 안되므로 flag 필요
        visited[min_index] = true;

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<c.length;i++){
            if(visited[i]){
                sb.append(c[i]);
            }
        }
        System.out.println(sb.toString());
        //이렇게 순서대로 처리하면 예제출력처럼 안나오는디..
        //OA다음에 OAC 사전순이라면 이렇게 나와야하는디,,
        search(start, min_index);
        search(min_index+1, end);

    }
}
