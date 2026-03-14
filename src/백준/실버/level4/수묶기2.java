package 백준.실버.level4;

import java.util.*;
import java.io.*;

/*
정렬로 푸는 방법도 있음
 */

public class 수묶기2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> positives = new ArrayList<>();
        List<Integer> negatives = new ArrayList<>();
        int ones = 0;
        boolean hasZero = false;

        for(int i=0;i<n;i++){
            int x = sc.nextInt();
            if(x > 1) positives.add(x);
            else if(x == 1) ones++;
            else if(x == 0) hasZero = true;
            else negatives.add(x);
        }

        //정렬
        positives.sort(Collections.reverseOrder()); //큰수부터
        Collections.sort(negatives);    //작은 수부터

        int sum = 0;

        //양수 처리
        for(int i=0;i<positives.size();i += 2){
            if(i + 1 < positives.size()) sum += positives.get(i) * positives.get(i+1);
            else sum += positives.get(i);
        }

        //음수 처리
        for(int i=0;i<negatives.size(); i+= 2){
            if(i+1 < negatives.size()) sum += negatives.get(i) * negatives.get(i+1);
            else{
                if (!hasZero) sum += negatives.get(i);
            }
        }

        //1은 그냥 더하기
        sum += ones;

        System.out.println(sum);

    }
}
