package 백준_1138_한줄로서기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        int[] result = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++){
            int num = Integer.parseInt(st.nextToken());
            int numCheck = 0;
            int cnt = 0;
            while (true){
                if(result[cnt] != 0){
                    cnt++;
                }else{
                    if(numCheck == num){
                        break;
                    }
                    cnt++;
                    numCheck++;
                }
            }
            result[cnt] = i;
        }

        for(int i = 0; i < N; i++){
            sb.append(result[i]).append(" ");
        }

        System.out.println(sb);
    }

}
