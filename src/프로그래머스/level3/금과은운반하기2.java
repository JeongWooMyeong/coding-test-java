package 프로그래머스.level3;

public class 금과은운반하기2 {

    public static long solution(int a, int b, int[] g, int[] s, int[] w, int[] t){
        long left = 1;
        //최소 t[i] = 1, w[i] = 1최대 골드 10^9
        //금과 은 2 * 10^9;
        //왕복거리 2 * 10^5;
        // 4 * 10^14 -> 최대 10^15로 잡는게 안전
        long right =  (long) 1e15;
        long answer = 0;
        //금과 은을 운반하는데 걸리는 시간을 mid로 잡는다
        while(left <= right){
            long mid = (left + right) / 2;
            //이 시간대에 만족하면
            if(can(a,b,g,s,w,t,mid)){
                answer = mid;
                //더 시간을 줄여 최소 시간을 구해본다.
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }

        return answer;
    }

    static boolean can(int a, int b, int[] g, int[] s, int[] w, int[] t, long mid){
        //3가지 경우를 고려해봐야함
        //금, 은, 토탈
        long gold = 0;
        long silver = 0;
        long total = 0;
        //for문 끝까지 돌림
        for(int i=0;i<t.length;i++){
            //왕복횟수
            long repeatCount = mid / (2L * t[i]);
            //편도 이동 가능 확인 (남은 시간 >= 편도시간) -> 그래야 편도 이용 가능
            if(mid % (2L * t[i]) >= t[i]) repeatCount++;
            //최대로 가져갈 수 있는 개수 -> 왕복횟수 * 최대옮길수 있는 무게
            long maxCarry = repeatCount * w[i];

            gold += Math.min(g[i], maxCarry);
            silver += Math.min(s[i], maxCarry);

            total += Math.min(g[i] + s[i], maxCarry);


        }

        return gold >= a && silver >= b && total >= (a+b);

    }

    public static void main(String[] args) throws Exception{
        int a = 10;
        int b = 10;
        int[] g = {100};
        int[] s = {100};
        int[] w = {7};
        int[] t = {10};

        System.out.println(solution(a,b,g,s,w,t));
    }

}
