package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 불량사용자4 {
    static Set<Set<String>> list;

    public static int solution(String[] user_id, String[] banned_id){
        int answer = 0;
        list = new HashSet<>();

        dfs(0, user_id, banned_id, new HashSet<>());

        return list.size();
    }

    static void dfs(int idx, String[] user_id, String[] banned_id, Set<String> selected){
        if(idx == banned_id.length){
            list.add(new HashSet<>(selected));
            return;
        }

        for(String userid : user_id){
            if(match(userid, banned_id[idx])){
                selected.add(userid);
                dfs(idx+1, user_id, banned_id, selected);
                selected.remove(userid);
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
        String[] banned_id = {"fr*d*", "abc1**"};

        System.out.println(solution(user_id, banned_id));
    }

}
