package 프로그래머스.level3;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 여행경로2 {
    static boolean[] visited;
    static List<String[]> answer = new ArrayList<>();

    public static String[] solution(String[][] tickets){
        visited = new boolean[tickets.length];
        //이렇게 정렬하는거 많이 하지 않아 익숙치 않음 -> 숙지 필요
        Arrays.sort(tickets, (a,b)-> {
           if(a[0].equals(b[0])) return a[1].compareTo(b[1]);
           return a[0].compareTo(b[0]);
        });
        List<String> path = new ArrayList<>();
        path.add("ICN");
        //시작점을 기준으로 하면되는구나
        dfs("ICN", path, tickets, 0);

        return answer.get(0);

    }

    static void dfs(String start, List<String> path, String[][] tickets, int used){
        if(used == tickets.length){
            answer.add(path.toArray(new String[0]));
            return;
        }
        //시작점이 2차원배열에서 첫번째랑 같은거 찾아서 다음 경로 찾음
        for(int i=0;i<tickets.length;i++){
            if(!visited[i] && tickets[i][0].equals(start)){
                visited[i] = true;
                path.add(tickets[i][1]);
                dfs(tickets[i][1], path, tickets, used+1);
                path.remove(path.size()-1);
                visited[i] = false;
            }
        }

    }

    public static void main(String[] args) throws Exception{
        String[][] tickets = {{"ICN","JFK"},{"HND","IAD"},{"JFK","HND"}};
        String[] arr = solution(tickets);

        StringBuilder sb = new StringBuilder();
        for(String str : arr){
            sb.append(str).append("\n");
        }

        System.out.print(sb.toString());
    }
}
