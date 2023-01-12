package 백준_15652_N과M4;

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
        int[] select = new int[M];

        permu(N, M, 0, select, sb, 1);
        System.out.println(sb);
    }

    static public void permu(int N, int M, int cnt, int[] select, StringBuilder sb, int start) {
        if (cnt == M) {
            for (int i = 0; i < M; i++) {
                sb.append(select[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i <= N; i++) {
            select[cnt] = i;
            permu(N, M, cnt + 1, select, sb, i);
        }
    }
}
