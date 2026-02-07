package 이것이코딩테스트다.정렬.계수정렬;

public class 계수정렬예제 {
    public static void main(String[] args){
        //정렬할 데이터 범위 (범위 : 0~9)
        int[] arr = {7, 5, 9, 0, 3, 1, 6, 2, 4, 8};

        //계수 배열 생성 (최대값 + 1 크기)
        int[] count = new int[10];

        //각 데이터의 등장 횟수 기록
        for(int i=0;i<arr.length;i++){
            count[arr[i]]++;
        }

        //계수 배열을 이용해 정렬 결과 출력
        for(int i=0;i<count.length;i++){
            for(int j=0;j<count[i];j++){
                System.out.print(i + " ");
            }
        }
    }
}
