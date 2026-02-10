package 이것이코딩테스트다.기출문제.구현;

import java.util.*;

public class 문자열압축 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int answer = str.length();

        for(int step=1;step<str.length() / 2 + 1;step++){
            String compressed = "";
            String prev = str.substring(0, step);
            int cnt = 1;
            //단위 크기 만큼 증가시키며 이전 문자열과 비교
            for(int j=step;j<str.length();j+=step){
                //이전 상태와 동일하다면 압축 횟수(count) 증가
                String sub = "";
                for(int k=j;k<j+step;k++){
                    if(k<str.length()) sub += str.charAt(k);
                }
                if(prev.equals(sub)) cnt += 1;
                //다른 문자열이 나왔다면
                else{
                    compressed += (cnt >= 2) ? cnt + prev : prev;
                    sub = "";
                    for(int k=j;k<j+step;k++){
                        if(k < str.length()) sub += str.charAt(k);
                    }
                    prev = sub;
                    cnt = 1;
                }
            }
            // 남아 있는 문자열에 대해서 처리
            compressed += (cnt >= 2) ? cnt + prev : prev;
            //만들어지는 압축 문자열이 가장 짧은 것이 정답
            answer = Math.min(answer, compressed.length());
        }
        System.out.println(answer);
    }
}
