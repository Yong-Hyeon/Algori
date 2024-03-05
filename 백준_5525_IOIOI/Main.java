package 백준_5525_IOIOI;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        String S = br.readLine() + "Z";

        int result = 0;
        int cnt = 1;
        char past = S.charAt(0);
        if(past == 'I'){
            cnt++;
        }
        for(int i = 1; i < M; i++){
            char ch = S.charAt(i);
            if(past != 'I'){
                past = ch;
                continue;
            }
            if(ch == 'O' && S.charAt(i+1) == 'I'){
                cnt += 2;
                i++;
                continue;
            }
            result += (cnt - 1) / 2 - (N - 1) < 0 ? 0 : (cnt - 1) / 2 - (N - 1);
            cnt = 1;
            past = ch;
        }
        result += (cnt - 1) / 2 - (N - 1) < 0 ? 0 : (cnt - 1) / 2 - (N - 1);

        System.out.println(result);
    }

}
