package 백준_1929_소수구하기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        for(int i = M; i <= N; i++){
            if(i == 1){
                continue;
            }else if(i == 2){
                sb.append(i).append("\n");
                continue;
            }
            int sqrtNum = (int)Math.sqrt(i) + 1;
            for(int j = 2; j <= sqrtNum; j++){
                if(i % j == 0){
                    break;
                }
                if(j == (sqrtNum)){
                    sb.append(i).append("\n");
                }
            }
        }

        System.out.println(sb);
    }
}
