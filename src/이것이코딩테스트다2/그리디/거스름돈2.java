package 이것이코딩테스트다2.그리디;

public class 거스름돈2 {
    public static void main(String[] args){
        int n = 1260;
        int cnt = 0;
        int[] coinTypes = {500, 100, 50, 10};

        for(int i=0;i<coinTypes.length;i++){
            int coin = coinTypes[i];
            cnt += n / coin;
            n %= coin;
        }

        System.out.print(cnt);
    }
}
