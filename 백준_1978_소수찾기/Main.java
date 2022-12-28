package 백준_1978_소수찾기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int cnt = 0;
        for(int i = 0; i < N; i++){
            int num = Integer.parseInt(st.nextToken());
            if(num == 1){
                continue;
            }else if(num == 2){
                cnt++;
                continue;
            }
            int sqrtNum = (int)Math.sqrt(num) + 1;
            for(int j = 2; j <= sqrtNum; j++){
                if(num % j == 0){
                    break;
                }
                if(j == (sqrtNum)){
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
    }
}
