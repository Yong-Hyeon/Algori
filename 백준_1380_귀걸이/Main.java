package 백준_1380_귀걸이;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int cnt = 1;
        int N = 0;
        while ((N = Integer.parseInt(br.readLine())) != 0){
            String[] names = new String[N+1];
            int[] count = new int[N+1];
            for(int i = 1; i <= N; i++){
                names[i] = br.readLine();
            }

            for(int i = 0; i < N * 2 -1; i++){
                count[Integer.parseInt(br.readLine().split(" ")[0])]++;
            }

            for(int i = 1; i <= N; i++){
                if(count[i] == 1){
                    sb.append(cnt++).append(" ").append(names[i]).append("\n");
                    break;
                }
            }
        }

        System.out.print(sb);
    }
}