package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 불량사용자5 {
    //==static Set<List<String>> set;
    static Set<Set<String>> set;
    static boolean[] visited;

    public static int solution(String[] user_id, String[] banned_id){
        int answer = 0;
        set = new HashSet<>();
        visited = new boolean[user_id.length];

        dfs(0, user_id, banned_id, new HashSet<>());

        return set.size();
    }

    static void dfs(int idx, String[] user_id, String[] banned_id, Set<String> selected){
        if(idx == banned_id.length){
            set.add(new HashSet<>(selected));
            return;
        }

        for(int i=0;i<user_id.length;i++){
            if(!visited[i] && match(user_id[i], banned_id[idx])){
                selected.add(user_id[i]);
                visited[i] = true;
               dfs(idx+1, user_id, banned_id, selected);
               selected.remove(user_id[i]);
               visited[i] = false;
            }
        }

    }

    static boolean match(String userid, String banid){
        if(userid.length() != banid.length()) return false;
        for(int i=0;i<userid.length();i++){
            if(banid.charAt(i) == '*') continue;
            if(userid.charAt(i) != banid.charAt(i)) return false;
        }

        return true;
    }

    public static void main(String[] args) throws Exception{
        String[] user_id = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
        String[] banned_id = {"fr*d*", "abc1**"};

        System.out.println(solution(user_id, banned_id));
    }

}
