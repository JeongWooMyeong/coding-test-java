package 이것이코딩테스트다.정렬.삽입정렬;

public class 삽입정렬예제 {
    public static void main(String[] args) throws Exception {
        int[] arr = {7, 5, 9, 0, 3, 1, 6, 2, 4, 8};

        for (int i = 0; i < arr.length; i++) {
            //현재 삽입할 원소
            int key = arr[i];
            int j = i-1;

            //key보다 큰 원소들을 한칸씩 뒤로 이동
            while(j >= 0 && arr[j] > key){
                arr[j+1] = arr[j];
                j--;
            }

            //올바른 위치에 key 삽입
            arr[j+1] = key;
        }

        //결과 출력
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i] + " ");
        }
    }
}
