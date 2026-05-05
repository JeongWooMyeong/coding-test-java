package 프로그래머스.level1;

import java.util.Arrays;

/*
체육복6 코드와는 간결성 차이 빼고느 동일
 */

public class 체육복7 {
    static int[] clothes;

    public static int solution(int n, int[] lost, int[] reserve){
        int answer = 0;

        clothes = new int[n+1];
        Arrays.fill(clothes, 1);

        for(int x : lost){
            clothes[x] -= 1;
        }

        for(int x : reserve){
            clothes[x] += 1;
        }

        for(int i=1;i<=n;i++){
            if(clothes[i] == 0){
               if(i > 1 && clothes[i-1] > 1){
                   clothes[i] += 1;
                   clothes[i-1] -= 1;
               }else if(i < n && clothes[i+1] > 1){
                   clothes[i] += 1;
                   clothes[i+1] -= 1;
               }
            }
        }

        for(int i=1;i<=n;i++){
            if(clothes[i] > 0) answer++;
        }


        return answer;
    }

    public static void main(String[] args) throws Exception{
        int n = 5;
        int[] lost = {2,4};
        int[] reserve = {1,3,5};

        System.out.println(solution(n, lost, reserve));
    }

}
