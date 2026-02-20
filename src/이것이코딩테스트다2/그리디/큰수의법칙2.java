package 이것이코딩테스트다2.그리디;

import java.util.*;

public class 큰수의법칙2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();   //배열 크기
        int m = sc.nextInt();   //더해지는 횟수
        int k = sc.nextInt();   //최대 더해질 수 있는 횟수
        ArrayList<Integer> list = new ArrayList<>();

        for(int i=0;i<n;i++){
            list.add(sc.nextInt());
        }
        //내림 차순 정렬
        Collections.sort(list, Collections.reverseOrder());

        int result = 0;
        while(m > 0){
            for(int j=0;j<k;j++){
                result += list.get(0);
                m -= 1;
            }

            result += list.get(1);
            m -= 1;
        }

        System.out.print(result);

    }
}
