package 알고리즘정리;

public class DataTypeExample {
    public static void main(String[] args){
        //정수형 (int)
        int age = 25;
        int year = 2026;
        System.out.println("나이: " + age);
        System.out.println("년도: " + year);

        //실수형 (float) - 소수점 7자리 정도까지 정확
        float pi = 3.1415927f;  //float 는 값 뒤에 f를 붙여야 함
        float height = 175.5f;
        System.out.println("원주율(float): " + pi);
        System.out.println("키(float): " + height);

        //실수형 (double) - 소수점 15자리 정도까지 정확
        double gravity = 9.80665;
        double distance = 12345.6789;
        System.out.println("중력가속도(double): " + gravity);
        System.out.println("거리(double): " + distance);

        //형 변환
        double result = age + pi;   //int + float -> double로 자동 변환
        System.out.println("나이 + 원주율 = " + result);

        //명시적 형 변환 (Casting)
        int truncated = (int) distance; //double -> int (소수점 버림)
        System.out.println("거리(double)를 int로 변환: " + truncated);
    }
}
