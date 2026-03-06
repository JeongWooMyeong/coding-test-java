package 백준.실버.level4;

import java.util.*;
import java.io.*;
/*
-
- Deque → 양쪽 다 지원, 최신 구현체(ArrayDeque)로 성능도 좋음

 */

public class 덱 {
    static int n;
    static String command;
    static Deque<Integer> deque = new LinkedList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            command =  st.nextToken();
            if(command.startsWith("push_back")){
                deque.addLast(Integer.parseInt(st.nextToken()));
            }else if(command.startsWith("push_front")){
                deque.addFirst(Integer.parseInt(st.nextToken()));
            }else if(command.equals("pop_front")){
                sb.append(deque.isEmpty()? -1 : deque.pollFirst()).append("\n");
            }else if(command.equals("pop_back")){
                sb.append(deque.isEmpty()? -1 : deque.pollLast()).append("\n");
            }else if(command.equals("size")){
                sb.append(deque.size()).append("\n");
            }else if(command.equals("empty")){
                sb.append(deque.isEmpty() ? 1 : 0).append("\n");
            }else if(command.equals("front")){
                sb.append(deque.isEmpty() ? -1 : deque.getFirst()).append("\n");
            }else if(command.equals("back")){
                sb.append(deque.isEmpty() ? -1 : deque.getLast()).append("\n");
            }

        }

        System.out.print(sb);
    }
}
