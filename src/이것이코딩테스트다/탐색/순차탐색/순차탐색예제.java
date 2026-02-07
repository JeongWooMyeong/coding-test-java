package 이것이코딩테스트다.탐색.순차탐색;

import java.util.*;

public class 순차탐색예제 {
    //순차탐색 메섣
    public static int sequentialSearch(String[] arr, String target){
        for(int i=0;i<arr.length;i++){
            if(arr[i].equals(target)){
                return i+1;
            }
        }
        return -1;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        //배열 크기와 찾을 값 입력
        int n = sc.nextInt();
        String target = sc.next();

        String[] arr = new String[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.next();
        }

        int result = sequentialSearch(arr, target);

        System.out.print(result);
    }
}
