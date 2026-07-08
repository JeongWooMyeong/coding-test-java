package 프로그래머스.level4;

import java.util.*;
import java.io.*;

public class 비트마스크 {

    public static void main(String[] args){
        int state = 0;
        System.out.println("초기 상태: " + Integer.toBinaryString(state));

        state |= (1 << 2);  //2번째 비트 켜기
        System.out.println("2번째 비트 켜기 : " + Integer.toBinaryString(state));

        state &= ~(1 << 2); //2번째 비트 끄기
        System.out.println("2번째 비트 끄기: " + Integer.toBinaryString(state));

        state ^= (1 << 1);  //1번째 비트 토글
        System.out.println("1번째 비트 토글:" + Integer.toBinaryString(state));

        boolean isOn = (state & (1 << 1)) != 0;
        System.out.println("1번째 비트 켜져 있나?" + isOn);

        System.out.println("================================");

        int keys = 0;
        keys |= (1 << 0);   //열쇠 a 획득
        keys |= (1 << 1);   //열쇠 b 획득

        System.out.println("현재 열쇠 상태 : " + Integer.toBinaryString(keys));

        if((keys & (1 << 2)) != 0){
            System.out.println("열쇄 c 있음");
        }else{
            System.out.println("열쇠 c 없음");
        }


    }

}
