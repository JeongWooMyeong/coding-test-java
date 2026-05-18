package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 불량사용자7 {
    static Set<Set<String>> set;
    static boolean[] visited;

    public static int solution(String[] user_id, String[] banned_id){
        visited = new boolean[user_id.length];
        set = new HashSet<>();

        dfs(0,user_id, banned_id, new HashSet<>());

        return set.size();
    }

    static void dfs(int idx, String[] userid, String[] bannedid, Set<String> selected){
        if(idx == bannedid.length){
            set.add(new HashSet<>(selected));
            return;
        }

        for(int i=0;i<userid.length;i++){
            if(!visited[i] && match(userid[i], bannedid[idx])){
                visited[i] = true;
                selected.add(userid[i]);
                dfs(idx+1, userid, bannedid, selected);
                selected.remove(userid[i]);
                visited[i] = false;
            }
        }
    }

    static boolean match(String a, String b){
        if(a.length() != b.length()) return false;
        for(int i=0;i<a.length();i++){
            if(b.charAt(i) == '*') continue;
            if(a.charAt(i) != b.charAt(i)) return false;
        }

        return true;
    }

    public static void main(String[] args) throws Exception{
        String[] user_id = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
        String[] banned_id = {"fr*d*", "*rodo", "******", "******"};

        System.out.println(solution(user_id, banned_id));
    }

}
