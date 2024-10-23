package 백준_1459_걷기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        long X = Long.parseLong(st.nextToken());
        long Y = Long.parseLong(st.nextToken());
        long W = Long.parseLong(st.nextToken());
        long S = Long.parseLong(st.nextToken());

        long max = Math.max(X, Y);
        long min = Math.min(X, Y);
        long sum = 0;
        if(S <= W){
            sum += min * S;
            if((max - min) % 2 == 0){
                sum += (max - min) * S;
            }else{
                sum += (max - min - 1) * S + W;
            }
        }else if(S <= 2 * W){
            sum += min * S + (max - min) * W;
        }else{
            sum = (X + Y) * W;
        }

        sb.append(sum);

        System.out.println(sb);
    }

}
