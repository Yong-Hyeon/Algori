package 백준_29731_2033밈투표;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        String str = "Never gonna give you up\n" +
                "Never gonna let you down\n" +
                "Never gonna run around and desert you\n" +
                "Never gonna make you cry\n" +
                "Never gonna say goodbye\n" +
                "Never gonna tell a lie and hurt you\n" +
                "Never gonna stop";

        boolean isFail = false;
        for(int i = 0; i < N; i++) {
            String s = br.readLine();
            if(!str.contains(s)) {
                isFail = true;
            }
        }

        sb.append(isFail ? "Yes" : "No");

        System.out.println(sb);
    }
}
