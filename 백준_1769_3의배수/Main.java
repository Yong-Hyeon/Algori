package 백준_1769_3의배수;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String N = br.readLine();
        int cnt = 0;

        while (N.length() > 1){
            cnt++;
            int sum = 0;
            int size = N.length();
            for(int i = 0; i < size; i++){
                sum += N.charAt(i) - '0';
            }
            N = sum + "";
        }

        sb.append(cnt).append("\n");
        if(Integer.parseInt(N) % 3 == 0){
            sb.append("YES");
        }else{
            sb.append("NO");
        }

        System.out.print(sb);
    }
}