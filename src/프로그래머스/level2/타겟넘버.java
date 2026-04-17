package 프로그래머스.level2;

public class 타겟넘버 {
    static int count;
    public static int solution(int[] numbers, int target){
        //int answer = 0;
        count = 0;

        dfs(0, 0, target, numbers);


        return count;
    }

    static void dfs(int idx, int sum, int target, int[] numbers){
        if(idx == numbers.length){
            if(sum == target){
                count++;

            }
            return;
        }

        dfs(idx+1, sum + numbers[idx], target, numbers);
        //numbers[idx] *= -1;
        dfs(idx+1, sum - numbers[idx], target, numbers);


    }

    public static void main(String[] args) throws Exception{
        int[] numbers = {1,1,1,1,1};
        int target = 3;

        System.out.println(solution(numbers, target));
    }
}
