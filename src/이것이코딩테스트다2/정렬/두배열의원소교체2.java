package 이것이코딩테스트다2.정렬;

import java.util.*;

public class 두배열의원소교체2 {
    static int n,k;
    static List<Integer> list = new ArrayList<>();
    static List<Integer> list2= new ArrayList<>();

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();

        sc.nextLine(); //버퍼 지우기
        for(int i=0;i<n;i++){
            list.add(sc.nextInt());
        }

        for(int i=0;i<n;i++){
            list2.add(sc.nextInt());
        }

        Collections.sort(list);
        Collections.sort(list2, Collections.reverseOrder());

        for(int i=0;i<k;i++){
            list.set(i, list2.get(i));
        }

        int result = 0;
        for(int i=0;i<list.size();i++){
            result += list.get(i);
        }

        System.out.println(result);

    }
}
