package 프로그래머스.level3;

import java.util.*;
import java.io.*;

public class 불량사용자 {
    static Set<Set<String>> set;

    public static int solution(String[] user_id, String[] banned_id){
        int answer = 0;
        set = new HashSet<>();

        dfs(0,user_id, banned_id, new HashSet<>());

        return set.size();
    }

    static void dfs(int idx, String[] user_id, String[] banned_id, Set<String> selected){
        if(idx == banned_id.length){
            set.add(new HashSet<>(selected));
            return;
        }

        for(String userid : user_id){
            //idx가 banned_id 기준이니 idx banndid 하면서 하는게 좋을듯?
            if(!selected.contains(userid) && match(userid, banned_id[idx])){
                selected.add(userid);
                dfs(idx+1, user_id, banned_id, selected);
                selected.remove(userid);
            }
        }

    }
    //할떄 banned_id 배열로 받아서 햇는데 이러면 다 들어와서 true 판별 불가능
    static boolean match(String userid, String banned_id){
        if(userid.length() != banned_id.length()) return false;

        for(int i=0;i<userid.length();i++){
            if(banned_id.charAt(i) == '*') continue;
            if(banned_id.charAt(i) != userid.charAt(i)) return false;
        }

        return true;
    }

    public static void main(String[] args) throws Exception{
        String[] user_id = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
        String[] banned_id = {"fr*d*", "abc1**"};

        System.out.println(solution(user_id, banned_id));
    }

}
