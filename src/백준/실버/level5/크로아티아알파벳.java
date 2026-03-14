package 백준.실버.level5;

import java.util.*;
import java.io.*;

public class 크로아티아알파벳 {
    static String str = "";
    static String[] alphabet = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();

        for(int i=0;i<alphabet.length;i++){
            if(str.contains(alphabet[i])){
                str = str.replaceAll(alphabet[i], "a");
            }
        }

        System.out.println(str.length());
    }

}
