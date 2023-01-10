package 백준_15650_N과M2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        boolean[] isSelected = new boolean[N + 1];
        int[] select = new int[M];

        permu(N, M, 0, isSelected, select, sb, 1);
        System.out.println(sb);
    }

    static public void permu(int N, int M, int cnt, boolean[] isSelected, int[] select, StringBuilder sb, int start) {
        if (cnt == M) {
            for (int i = 0; i < M; i++) {
                sb.append(select[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i <= N; i++) {
            if (isSelected[i]) {
                continue;
            }
            isSelected[i] = true;
            select[cnt] = i;
            permu(N, M, cnt + 1, isSelected, select, sb, i + 1);
            isSelected[i] = false;
        }
    }
}
