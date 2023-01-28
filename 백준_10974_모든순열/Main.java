package 백준_10974_모든순열;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] selected = new int[N];
        boolean[] isSelected = new boolean[N];

        permu(N, selected, isSelected, 0, sb);
        System.out.println(sb);
    }

    private static void permu(int N, int[] selected, boolean[] isSelected, int cnt, StringBuilder sb) {
        if(cnt == N){
            for(int i = 0; i < N; i++){
                sb.append(selected[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = 0; i < N; i++){
            if(isSelected[i]){
                continue;
            }
            isSelected[i] = true;
            selected[cnt] = i + 1;
            permu(N, selected, isSelected, cnt + 1, sb);
            isSelected[i] = false;
        }

    }

}
