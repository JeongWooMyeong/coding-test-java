package 이것이코딩테스트다.다이나믹프로그래밍;

public class 피보나치수열3 {
    public static long[] d = new long[100];

    public static long fibo(int x){
        System.out.println("f(" + x + ") ");
        if(x == 1 || x == 2){
            return 1;
        }
        //이미 계산한적 있는 문제라면 그대로 반환
        if(d[x] != 0 ){
            return d[x];
        }
        //아직 계산되지 않은 문제라면 점화식에 따라서 피보나치 결과 반환
        d[x] = fibo(x-1) + fibo(x-2);
        return d[x];
    }

    public static void main(String[] args){
        fibo(6);
    }
}
