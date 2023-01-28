package 백준_10819_차이를최대로;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int max;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] input = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }
        int[] selected = new int[N];
        boolean[] isSelected = new boolean[N];
        max = 0;
        permu(input, N, selected, isSelected, 0);

        System.out.println(max);
    }
    static void permu(int[] input, int N, int[] selected, boolean[] isSelected, int cnt){
        if(cnt == N){
            int sum = 0;
            for(int i = 0; i < N-1; i++){
                sum += Math.abs(input[selected[i]] - input[selected[i+1]]);
            }
            max = Math.max(max, sum);
            return;
        }

        for(int i = 0; i < N; i++){
            if(isSelected[i]){
                continue;
            }
            selected[cnt] = i;
            isSelected[i] = true;
            permu(input, N, selected, isSelected, cnt + 1);
            isSelected[i] = false;
        }
    }
}
