package 알고리즘정리;
/*
유클리드 호제법
두 수의 최대공약수 구하는 알고리즘
(gcd) Greatest Common Divisor -> 최대공약수

큰수를 작은 수로 나누고, 그 나머지를 다시 작은수와 비교하는 과정 반복
 */
public class EuclideanAlgorithm {
    public static void main(String[] args){
        System.out.println(getGCD(12, 18)); //출력 6
        System.out.println(getGCD(1071, 1029));//출력 2
    }

    private static int getGCD(int x, int y){
        while(y != 0){
            int r = x%y;
            x = y;
            y = r;
        }
        return x;
    }
}
