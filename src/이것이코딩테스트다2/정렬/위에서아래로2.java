package 이것이코딩테스트다2.정렬;

import java.util.*;

public class 위에서아래로2 {
    static int n;
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for(int i=0;i<n;i++){
            list.add(sc.nextInt());
        }

        Collections.sort(list, Collections.reverseOrder());

        for(int i : list){
            System.out.print(i + " ");
        }



    }
}
