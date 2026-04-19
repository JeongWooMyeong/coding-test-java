package 프로그래머스.level2;

public class 피로도 {
    static boolean[] visited;
    static int answer = 0;

    public static int solution(int k, int[][] dungeons){
        //int answer = -1;
        visited = new boolean[dungeons.length];
        dfs(k, 0, dungeons, visited);

        return answer;
    }

    static void dfs(int current, int count, int[][] dungeons, boolean[] visited){
        answer = Math.max(answer, count);
        for(int i=0;i<dungeons.length;i++){
            if(!visited[i]){
                if(current >= dungeons[i][0]){
                    visited[i] = true;
                    dfs(current - dungeons[i][1], count+1, dungeons, visited);
                    visited[i] = false;
                }
            }
        }
    }

    public static void main(String[] args) throws Exception{
        int k = 80;
        int[][] dungeons = {{80,20},{50,40},{30,10}};

        System.out.println(solution(k, dungeons));
    }

}
