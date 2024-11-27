package 백준_1475_방번호;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String N = br.readLine();
        int[] count = new int[10];

        int size = N.length();
        for(int i = 0; i < size; i++){
            count[N.charAt(i)-'0']++;
        }

        int max = 0;
        for(int i = 0; i < 9; i++){
            if(i == 6){
                max = Math.max(max, (int)Math.round((count[6] + count[9]) / 2.0));
            }else{
                max = Math.max(max, count[i]);
            }
        }
        sb.append(max);
        System.out.println(sb);
    }
}
