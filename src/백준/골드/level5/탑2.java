package 백준.골드.level5;

import java.io.*;
import java.util.*;

public class 탑2 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();   //인덱스 저장
        for(int i=0;i<n;i++){
            //현재 탑보다 낮은 탑은 스택에서 제거
            while(!stack.isEmpty() && arr[stack.peek()] <= arr[i]){
                stack.pop();
            }
            if(!stack.isEmpty()){
                result[i] = stack.peek() + 1;
            }else{
                result[i] = 0;
            }
            //현재 탑 인덱스를 스택에 저장
            stack.push(i);
        }

        StringBuilder sb = new StringBuilder();
        for(int x : result){
            sb.append(x).append(" ");
        }
        System.out.println(sb);


    }
}
