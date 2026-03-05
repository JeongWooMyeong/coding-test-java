package 백준.골드.level5;

import java.util.*;

public class ZOAC {
    static char[] s;
    static boolean[] visited;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        s = sc.nextLine().toCharArray();
        visited = new boolean[s.length];
        solve(0, s.length);
    }

    static void solve(int start, int end){
        if(start >= end) return;

        //가장 작은 문자 찾기
        int minIdx = -1;
        for(int i=start;i<end;i++){
            if(!visited[i]){
                if(minIdx == -1 || s[i] < s[minIdx]){
                    minIdx = i;
                }
            }
        }

        //방문처리
        visited[minIdx] = true;

        //현재까지 출력
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length;i++){
            if(visited[i]) sb.append(s[i]);
        }
        System.out.println(sb.toString());

        //왼쪽, 오른쪽 재귀
        solve(start, minIdx);
        solve(minIdx + 1, end);
    }
}
