package 백준_2562_최대값;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int max = -1;
        int maxIdx = -1;

        for(int i = 1; i <= 9; i++){
            int num = Integer.parseInt(br.readLine());
            if(max < num){
                max = num;
                maxIdx = i;
            }
        }

        System.out.println(max);
        System.out.println(maxIdx);
    }
}
