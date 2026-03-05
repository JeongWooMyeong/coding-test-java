package 백준.골드.level5;

import java.util.*;

public class ZOAC다시 {
    //입력 문자열을 저장할 배열
    static char[] s;
    //이미 선택(출력)된 문자를 표시할 배열
    static boolean[] visited;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        //문자열 입력받기
        s = sc.nextLine().toCharArray();
        //방문 여부 배열 초기화
        visited = new boolean[s.length];
        //전체 구간 (0 ~ 끝)에서 시작
        solve(0, s.length);
    }

    //문자열 구간 [start, end]에서 가장 작은 문자를 찾아 출력하는 함수
    static void solve(int start, int end){
        //구간이 비어 있으면 종료
        if(start >= end) return;

        //1. 현재 구간에서 가장 작은 문자의 위치 찾기
        int minIdx = -1;
        for(int i=start;i<end;i++){
            //아직 선택되지 않은 문자만 고려
            if(!visited[i]){
                //첫번째 후보이거나, 기존 최소값보다 더 작은 문자를 발견하면 갱신
                if(minIdx == -1 || s[i] < s[minIdx]){
                    minIdx = i;
                }
            }
        }

        //2. 가장 작은 문자를 방문처리
        visited[minIdx] = true;

        //3. 현재까지 선택된 문자들을 출력
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length;i++){
            if(visited[i]) sb.append(s[i]);
        }
        System.out.println(sb.toString());

        //4. 왼쪽 구간과 오른쪽 구간을 재귀적으로 처리
        // 선택된 문자를 기준으로 문자열을 두 부분으로 나눔
        solve(minIdx + 1, end);
        solve(start, minIdx);

    }
}
