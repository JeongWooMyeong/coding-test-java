package 백준.실버.level4;

import java.util.*;

public class 큐 {
    static int n;
    static Deque<Integer> q = new LinkedList<>();
    static String command;


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            command = sc.next();
            if(command.equals("push")){
                q.offer(sc.nextInt());
            }else if(command.equals("pop")){
                sb.append(q.isEmpty() ? -1 : q.poll()).append("\n");
            }else if(command.equals("size")){
                sb.append(q.size()).append("\n");
            }else if(command.equals("empty")){
                sb.append(q.isEmpty()? 1 : 0).append("\n");
            }else if(command.equals("front")){
                sb.append(q.isEmpty() ? -1 : q.peek()).append("\n");
            }else if(command.equals("back")){
                sb.append(q.isEmpty() ? -1 : q.peekLast()).append("\n");
            }
        }
        System.out.print(sb);

    }

}
