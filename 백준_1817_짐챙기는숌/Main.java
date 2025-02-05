package 백준_1817_짐챙기는숌;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        if(N == 0){
            sb.append(0);
        }else{
            st = new StringTokenizer(br.readLine());
            int result = 0;
            int sum = 0;
            for(int i = 0; i < N; i++){
                int num = Integer.parseInt(st.nextToken());
                if(sum + num > M){
                    result++;
                    sum = num;
                }else{
                    sum += num;
                }
            }

            if(sum > 0){
                result++;
            }

            sb.append(result);
        }

        System.out.println(sb);
    }
}
