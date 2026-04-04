package 삼성SW역량테스트.브론즈.level2;

import java.util.*;
import java.io.*;

public class 시험감독 {
    static int N;
    static int[] student;
    static int cap;
    static int scap;
    static long result = 0;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        student = new int[N];


        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            student[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        cap = Integer.parseInt(st.nextToken());
        scap = Integer.parseInt(st.nextToken());

        for(int i=0;i<N;i++){
            int num = student[i];
            if(num > 0) {
                //총감독관은 무조건 한명
                num -= cap;
                result++;
            }
            //부감독관은 여러명
            //num /= scap;
            if(num > 0) {
                long quote = num / scap;
                long remain = num % scap;
                result += quote;
                if (remain != 0){
                    result++;
                }
            }
        }

        System.out.print(result);



    }
}
