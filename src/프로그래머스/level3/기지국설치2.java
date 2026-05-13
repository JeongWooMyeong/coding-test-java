package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 기지국설치2 {

    public static int solution(int n, int[] stations, int w){
        int start = 1;  //1부터 시작
        //stations[i] 기준으로 범위는 stations[i]-w부터 stations[i]+w
        //범위는 stations[i]+w - (stations[i]-w) = 2w +1 앞 범위도 포함
        int cover = 2 * w + 1; //커버 범위 칸
        int answer = 0;

        for(int s : stations){
            //스테이션의 커버범위 left
            int left = s - w;
            //left의 범위가 start보다 크면 범위가 있따는 소리
            if(start < left){
                int gap = left - start; //커버 범위에서 하므로 +1 필요없음
                //answer += (gap + cover - 1) / cover;
                //Math.ceil도 가능 -> 근데 double 캐스팅 후 사용 (소수점 안나올 수 있으므로)
                answer += (int)Math.ceil((double)gap / cover);
            }
            //start 다음 커버 범위이후로 설정
            start = s + w + 1;

        }

        //마지막 커버 범위 확인
        //끝지점은 위와 다르게 s-w 가 아니기 때문에.. +1 로 칸 개수 구해야함
        if(start <= n){
            int gap = n - start + 1;
            //answer += (gap + cover - 1) / cover;
            answer += (int)Math.ceil((double)gap / cover);
        }


        return answer;
    }

    public static void main(String[] args) throws Exception{
        int N = 11;
        int[] stations = {4,11};
        int W = 1;
        System.out.println(solution(N, stations, W));
    }

}
