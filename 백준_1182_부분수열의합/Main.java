package 백준_1182_부분수열의합;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int[] input = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            input[i] = Integer.parseInt(st.nextToken());
        }
        int cnt = 0;

        for(int i = 1; i < (1 << N); i++){
            int sum = 0;
            for(int j = 0; j < N; j++){
                if((i & (1 << j)) > 0){
                    sum += input[j];
                }
            }
            if(sum == S){
                cnt++;
            }
        }

        System.out.println(cnt);
    }

}
