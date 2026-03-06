package 백준.골드.level5;

import java.util.*;
import java.io.*;

public class 탑4 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> stack = new Stack<>();
        int[] result= new int[n];
        for(int i=0;i<n;i++){
            while(!stack.isEmpty() && arr[stack.peek()] < arr[i]){
                stack.pop();
            }

            if(!stack.isEmpty()){
                result[i] = stack.peek() + 1;
            }else{
                result[i] = 0;
            }

            stack.push(i);
        }
        StringBuilder sb = new StringBuilder();
        for(int i : result){
            sb.append(i).append(" ");
        }

        System.out.print(sb);

    }
}
