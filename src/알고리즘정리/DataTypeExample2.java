package 알고리즘정리;

import java.math.BigInteger;

public class DataTypeExample2 {
    public static void main(String[] args){
        //기본 정수형들
        byte smallByte = 100;   //-128 ~ 127
        short smallShort = 30000;   //-32,768 ~ 32,767
        int normalInt = 2000000000; //약 플마21억
        long bigLong = 900000000000000000L; // 매우 큰 정수, 값 뒤에 L 붙임

        System.out.println("byte 값 : " + smallByte);
        System.out.println("short 값 : " + smallShort);
        System.out.println("int 값 : " + normalInt);
        System.out.println("long 값 : " + bigLong);

        //Wrapper 클래스 Integer (객체로 다루는 정수)
        Integer wrappedInt = Integer.valueOf(12345);
        System.out.println("Integer 객체 값: " + wrappedInt);

        //BigInteger (무한대 크기의 정수 표현 가능)
        BigInteger veryBig = new BigInteger("123456789012345678901234567890");
        BigInteger anotherBig = new BigInteger("987654321098765432109876543210");

        BigInteger sum = veryBig.add(anotherBig);
        BigInteger product = veryBig.multiply(anotherBig);

        System.out.println("BigInteger 덧셈 결과 : " + sum);
        System.out.println("BigInteger 곱셈 결과 : " + product);

        //형 변환 예제
        int castedInt = (int) smallShort;
        System.out.println("short를 int로 변환 : " + castedInt );

        long castedLong = normalInt;    //int -> long 자동변환
        System.out.println("int를 long으로 변환 : " + castedLong);


    }
}
