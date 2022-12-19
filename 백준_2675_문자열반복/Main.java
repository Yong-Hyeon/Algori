package 백준_2675_문자열반복;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int R = Integer.parseInt(st.nextToken());
            char[] S = st.nextToken().toCharArray();

            for(int i = 0; i < S.length; i++){
                for(int j = 0; j < R; j++){
                    sb.append(S[i]);
                }
            }

            sb.append("\n");
        }
        System.out.println(sb);
    }
}
