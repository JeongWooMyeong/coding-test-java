package 이것이코딩테스트다.정렬.선택정렬;

public class 선택정렬예제 {
    public static void main(String[] args) throws Exception{
        int[] arr = {7, 5, 9, 0, 3, 1, 6, 2, 4, 8};

        for(int i=0;i<arr.length-1;i++){
            int minIndex = i; // 가장 작은 원소의 인덱스
            for(int j = i+1;j<arr.length;j++){
                if(arr[minIndex] > arr[j]){
                    minIndex = j;
                }
            }

            //swap
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;

        }

        //결과 출력
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i] + " ");
        }
    }
}
