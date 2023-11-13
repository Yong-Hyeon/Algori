package 백준_2798_블랙잭;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int max;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] inputs = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            inputs[i] = Integer.parseInt(st.nextToken());
        }

        int[] selected = new int[3];
        max = 0;
        combi(selected, N, inputs, 0, 0, M);
        System.out.println(max);
    }

    static void combi(int[] selected, int N, int[] inputs, int start, int cnt, int M){
        if(cnt == 3){
            int sum = 0;
            for(int i = 0; i < 3; i++){
                sum += selected[i];
            }
            if(sum <= M){
                max = Math.max(max, sum);
            }

            return;
        }

        for(int i = start; i < N; i++){
            selected[cnt] = inputs[i];
            combi(selected, N, inputs, i + 1, cnt + 1, M);
        }
    }
}
