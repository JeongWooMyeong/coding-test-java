package 백준.실버.level5;

import java.util.*;

public class 단어정렬 {
    //N개의 단어 길이가 짧은 것부터
    static HashSet<String> set = new HashSet<>();
    static int n;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();   //단어의 개수
        sc.nextLine();

        for(int i=0;i<n;i++){
            set.add(sc.nextLine());
        }
        
        List<String> list = new ArrayList<>(set);

        Collections.sort(list, (a,b)->{
            if(a.length() == b.length()){
                return a.compareTo(b);
            }else{
                return a.length() - b.length(); //길이 순
            }
        });

        for(String s : list){
            System.out.println(s);
        }

    }

}
