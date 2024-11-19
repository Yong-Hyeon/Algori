package 백준_1384_메시지;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int cnt = 1;
        int N = 0;
        while ((N = Integer.parseInt(br.readLine())) != 0){
            String[][] inputs = new String[N][N];
            sb.append("Group ").append(cnt++).append("\n");

            for(int i = 0; i < N; i++){
                inputs[i] = br.readLine().split(" ");
            }

            boolean isNasty = false;
            for(int i = 0; i < N; i++){
                for(int j = 1; j < N; j++){
                    if("N".equals(inputs[i][j])){
                        isNasty = true;
                        sb.append(inputs[(i-j+N)%N][0]).append(" was nasty about ").append(inputs[i][0]).append("\n");
                    }
                }
            }
            if (!isNasty){
                sb.append("Nobody was nasty\n");
            }

            sb.append("\n");
        }

        System.out.println(sb);
    }
}