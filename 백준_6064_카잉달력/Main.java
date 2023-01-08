package 백준_6064_카잉달력;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int max = 0;
            int min = 0;
            int maxRe = 0;
            int minRe = 0;
            if(M > N){
                max = M;
                min = N;
                maxRe = x;
                minRe = y;
            }else{
                max = N;
                min = M;
                maxRe = y;
                minRe = x;
            }

            int lcm = 0;

            for (int i = 1; ; i++) {
                if ((max * i) % min == 0) {
                    lcm = max * i;
                    break;
                }
            }
            int result = -1;
            for(int i = 0;; i++){
                if((((max * i + maxRe) - 1) % min) + 1 == minRe){
                    result = max * i + maxRe;
                    break;
                }
                if(max * i + maxRe > lcm){
                    break;
                }
            }

            sb.append(result).append("\n");
        }

        System.out.println(sb);

    }
}
