package 백준.실버.level2;

import java.util.*;

public class 잃어버린괄호 {
    static String str;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        str = sc.nextLine();

        String[] parts = str.split("-");
        int result = sum(parts[0]);

        for(int i=1;i<parts.length;i++){
            result -= sum(parts[i]);
        }

        System.out.print(result);

    }

    public static int sum(String strs){
        String[] strarr = strs.split("\\+");
        int total = 0;
        for(int i=0;i<strarr.length;i++){
            total += Integer.parseInt(strarr[i]);
        }

        return total;
    }

}
