package 프로그래머스.level2;

public class 모음사전13 {

    static char[] vowel = {'A','E','I','O','U'};
    static int[] weight = {781, 156, 31, 6, 1};
    static int answer;

    public static int solution(String word){

        answer = 0;

        for(int i=0;i<word.length();i++){
            int idx = 0;
            for(int j=0;j<vowel.length;j++){
                if(word.charAt(i) == vowel[j]){
                    idx = j;
                    break;
                }
            }
            answer += idx * weight[i] + 1;
        }

        return answer;
    }


    public static void main(String[] args) throws Exception{
        String word = "AAAAE";
        System.out.println(solution(word));
    }

}
