package 이것이코딩테스트다.탐색.이진탐색;

import java.util.*;

public class 부품찾기집합자료 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //N (가게의 부품 개수)
        int n = sc.nextInt();
        //집합(Set) 정보를 처리하기 의한 HashSet 라이브러리
        HashSet<Integer> s = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            s.add(x);
        }

        //M (손님이 확인 요청한 부품 개수)
        int m = sc.nextInt();
        int[] targets = new int[n];
        for(int i=0;i<m;i++){
            targets[i] = sc.nextInt();
        }

        //손님이 요청한 부품 번호를 하나씩 확인
        for(int i=0;i<m;i++){
            if(s.contains(targets[i])){
                System.out.print("yes ");
            }else{
                System.out.print("no ");
            }
        }

    }
}
