package 알고리즘정리;

public class CombinationUtil {
    public static void combination(int[] arr, boolean[] visited, int start, int r){
        if(r == 0){
            for(int i=0;i<arr.length;i++){
                if(visited[i]) System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }
        for(int i=start;i<arr.length;i++){
            visited[i] = true;
            combination(arr, visited, i+1, r-1);
            visited[i] = false;
        }
    }
}
