package 백준.실버.level4;

import java.util.*;

public class 괄호 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        for(int i=0;i<n;i++) {
            int count = 0;
            String ps = sc.nextLine();
            boolean valid = true;

            for (int j = 0; j < ps.length(); j++) {
                if(ps.charAt(j) == '('){
                    count += 1;
                }else if(ps.charAt(j) == ')'){
                    count -= 1;
                }
                if(count < 0 ){
                    valid = false;
                    break;
                }
            }

            if(valid && count == 0){
                System.out.println("YES");

            }else{
                System.out.println("NO");
            }
        }


    }
}
