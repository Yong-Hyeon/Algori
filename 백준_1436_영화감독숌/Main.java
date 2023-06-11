package 백준_1436_영화감독숌;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int num = 0;
        int cnt = 0;
        int result = 0;

        while (cnt < N){
            if((num + "").contains("666")){
                cnt++;
                result = num;
            }
            num++;
        }
        System.out.println(result);
    }
}
