package 이것이코딩테스트다.정렬.퀵정렬;

public class 퀵정렬예제 {
    public static void quickSort(int[] arr, int start, int end){
        if(start >= end) return; //원소가 1개 이하일때 종료

        int pivot = start; //피벗은 첫번째 원소
        int left = start + 1;
        int right = end;

        while(left <= right){
            //피벗보다 큰 데이터 찾을때
            while(left <= end && arr[left] <= arr[pivot]) left++;
            //피벗보다 작은 데이터를 찾을때까지
            while(right > start && arr[right] >= arr[pivot]) right--;

            if(left > right){
                //엇갈렸다면 작은 데이터와 피벗을 교체
                int temp = arr[pivot];
                arr[pivot] = arr[right];
                arr[right] = temp;
            } else{
                //엇갈맂 않았다면 작은데이터와 큰 데이터를 교체
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
        }

        //분할 후 왼쪽 부분과 오른쪽 부분을 각각 정렬
        quickSort(arr, start, right-1);
        quickSort(arr, right + 1, end);
    }

    public static void main(String[] args){
        int[] arr = {7, 5, 9, 0, 3, 1, 6, 2, 4, 8};

        quickSort(arr, 0, arr.length -1);

        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i] + " ");
        }
    }
}
