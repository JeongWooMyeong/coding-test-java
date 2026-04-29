package 프로그래머스.level2;

import java.util.*;
import java.io.*;

public class 줄서는방법3 {

    public static int[] solution(int n, int k){
        int[] answer = new int[n];
        List<Integer> people = new ArrayList<>();
        //사람수 넣기
        for(int i=1;i<=n;i++){
            people.add(i);  //사람 0 index부터 내려감
        }

        //그래서 k번째도 0인덱스에 맞추기 위해 k-- 해야함
        k--;

        long fact = 1;
        for(int i=0;i<people.size();i++){
            fact *= people.get(i);  //n!;
        }
        //n개의 수 선택
        for(int i=0;i<n;i++){
            fact /= (n-i);  //0번째 선택햇을떄 경우의 수
            int idx = (int) (k / fact); //몇번째 그룹인지
            answer[i] = people.get(idx);
            //자리 한자리 배정되었으면 그 인덱스 삭제 (순열 조합)
            people.remove(idx);
            //그룹내에서 몇번째인지 확인해야함
            k %= fact;

        }

        return answer;
    }

    public static void main(String[] args) throws Exception{
        int n = 3;
        int k = 5;
        System.out.println(Arrays.toString(solution(n,k)));
    }

}
