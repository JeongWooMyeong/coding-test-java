package 프로그래머스.level2;

import java.util.ArrayList;
import java.util.List;

public class 모음사전2 {
    static List<String> dict;
    static char[] vowels = {'A', 'E', 'I', 'O', 'U'};
    static int count = 0;
    static int answer = 0;

    public static int solution(String word){

        dict = new ArrayList<>();
        dfs(0, "", word);

        return answer;
    }

    static void dfs(int depth, String current, String target){
        if(depth > 5) return;

        //System.out.println(current);
        if(!"".equals(current)) {
            count++;
            if(target.equals(current)) {
                answer = count;
                return;
            }
        }

        for(char c : vowels){
            dfs(depth + 1, current + c, target);
        }

    }

    public static void main(String[] args) throws Exception{
        String word = "AAAAE";

        System.out.println(solution(word));

    }

}
