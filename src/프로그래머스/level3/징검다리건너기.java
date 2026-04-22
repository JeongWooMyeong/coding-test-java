package 프로그래머스.level3;

public class 징검다리건너기 {
    public static int solution(int[] stones, int k){
        int answer = 0;
        int left = 1;
        int right = 0;

        for(int i=0;i<stones.length;i++){
            right = Math.max(right, stones[i]);
        }

        //탐색을 건널 수 있느 사람 기준으로 탐색
        while(left <= right){
            int mid = (left + right) / 2;

            if(canCross(stones, mid, k)){
                answer = mid;
                left = mid + 1;
            }else{
                right = mid - 1;
            }

        }


        return answer;
    }

    static boolean canCross(int[] stones, int mid, int k){
        //못건너는 카운트 수
        int count = 0;
        for(int stone : stones){
            if(stone - mid < 0){
                count++;
                if(count >= k) return false;
            }else{
                count = 0;
            }
        }
        return true;
    }


    public static void main(String[] args) throws Exception{
        int[] stones = {2,4,5,3,2,1,4,2,5,1};
        int k = 3;
        System.out.println(solution(stones, k));
    }
}
