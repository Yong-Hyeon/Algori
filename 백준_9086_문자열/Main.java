package 백준_9086_문자열;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc++){
            String str = br.readLine();
            sb.append(str.charAt(0)).append(str.charAt(str.length()-1));
            sb.append("\n");
        }

        System.out.println(sb);
    }
}