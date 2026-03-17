package 백준.골드.level4;

import java.io.*;
import java.util.*;

public class 이진탐색트리2 {
    static ArrayList<Integer> preOrder = new ArrayList<>();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;

        //입력 받기
        while((line = br.readLine()) != null && !line.isEmpty()){
            preOrder.add(Integer.parseInt(line));
        }

        postOrder(0, preOrder.size()-1);
    }

    //후위 순회
    static void postOrder(int start, int end){
        if(start > end) return;

        int root = preOrder.get(start);
        int idx = start + 1;

        //오른쪼 서브트리 시작 위치 찾기
        while(idx <= end && preOrder.get(idx) < root){
            idx++;
        }

        // 왼쪽 서브트리
        postOrder(start + 1, idx - 1);

        // 오른쪽 서브트리
        postOrder(idx, end);

        // 루트 출력
        System.out.println(root);
    }
}
