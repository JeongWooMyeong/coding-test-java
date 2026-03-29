package 이것이코딩테스트다2.기출문제.구현;

import java.util.*;
import java.io.*;

public class 외벽점검2 {
    public static void main(String[] args) throws Exception{
        int n = 12;
        int[] weak = {1, 3, 4, 9, 10};
        int[] dist = {3, 5, 7};

        System.out.print(solution(n, weak, dist));
    }

    static int solution(int n, int[] weak, int[] dist){
        int length = weak.length;
        int answer = Integer.MAX_VALUE;
        //1. 취약점 원형 -> 직선 2배
        int[] extended = new int[length * 2];

        for(int i=0;i<length;i++){
            extended[i] = weak[i];
            extended[i+length] = weak[i] + n;
        }

        //2. dist 친구 순열 조합 구하기
        List<int[]> permutations = new ArrayList<>();
        permute(dist, 0, permutations);

        //3. 취약점 start로 친구 수 확인
        for(int start =0;start<length;start++){
            //친구
            for(int[] friends : permutations){
                int count = 1;
                int position = extended[start] + friends[count-1];
                for(int i=start;i<start+length;i++){
                    //커버 범위를 넘어갔다는 이야기므로 친구 추가
                    if(extended[i] > position){
                        count++;
                        //count가 친구 넘어가버리면 break
                        if(count > dist.length) break;
                        //커버 범위 갱신
                        position = extended[i] + friends[count - 1];
                    }
                }
                answer = Math.min(answer, count);
            }
        }
        return answer > dist.length ? -1 : answer;

    }

    static void permute(int[] arr, int depth, List<int[]> result){
        if(depth == arr.length){
            result.add(arr.clone());
            return;
        }

        for(int i=depth;i<arr.length;i++){
            swap(arr, i, depth);
            permute(arr, depth+1, result);
            swap(arr, i, depth);
        }

    }

    static void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
