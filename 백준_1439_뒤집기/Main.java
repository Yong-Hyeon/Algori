package 백준_1439_뒤집기;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();
        int size = str.length();

        int[] cnt = new int[2];

        char now = str.charAt(0);

        for(int i = 1; i < size; i++){
            if(now != str.charAt(i)){
                cnt[now-'0']++;
                now = str.charAt(i);
            }
        }
        cnt[now-'0']++;

        sb.append(Math.min(cnt[0], cnt[1]));
        System.out.print(sb);
    }
}
