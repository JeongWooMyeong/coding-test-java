package 이것이코딩테스트다2.기출문제.구현;

import java.util.*;

public class 외벽점검 {
    public static void main(String[] args) throws Exception{
        int n = 12;
        int[] weak = {1,5,6,10};
        int[] dist = {1,2,3,4};

        System.out.print(solution(n, weak, dist));
    }

    static int solution(int n, int[] weak, int[] dist){
        int len = weak.length;

        //1. weak 배열을 2배로 확장(원형 -> 직선)
        int[] extended = new int[len * 2];
        for(int i=0;i<len;i++){
            extended[i] = weak[i];
            extended[i + len] = weak[i] + n;
        }

        //2. dist의 모든 순열 생성
        List<int[]> permutations = new ArrayList<>();
        permute(dist, 0, permutations);

        int answer = Integer.MAX_VALUE;

        //3. weakm의 각 지점을 시작점으로 가정
        for(int start = 0;start<len;start++){
            //4. 순열 마다 검사
            for(int[] friends : permutations){
                int count = 1;  //투입한 친구수
                int position = extended[start] + friends[count - 1];    //첫 친구가 커버 가능한 끝 지점

                //weak[start]부터 weak[start + len - 1]까지 커버해야함
                for(int i=start;i<start + len;i++){
                    if(extended[i] > position){
                        //못막으면 다음 친구 투입
                        count++;
                        if(count > dist.length) break;  //친구 다 썼는데도 못막음
                        position = extended[i] + friends[count - 1];
                    }
                }
                answer = Math.min(answer, count);
            }
        }
        return answer > dist.length ? -1 : answer;
    }
    //dist 배열의 순열 생성
    static void permute(int[] arr, int depth, List<int[]> result){
        if(depth == arr.length){
            result.add(arr.clone());
            return;
        }
        for(int i=depth;i<arr.length;i++){
            swap(arr, i, depth);
            permute(arr, depth + 1, result);
            swap(arr, i, depth);
        }
    }

    static void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
