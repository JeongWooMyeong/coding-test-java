package 이것이코딩테스트다.기출문제.정렬;

import java.util.*;

public class 안테나 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        ArrayList<Integer> arrayList = new ArrayList<>();
        for(int i=0;i<n;i++){
            arrayList.add(sc.nextInt());
        }

        Collections.sort(arrayList);

        //중간 값 (median)을 출력
        System.out.println(arrayList.get((n-1) / 2));

    }
}
