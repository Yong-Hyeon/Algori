package 백준_15657_N과M8;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] nums = new int [N];
        for(int i = 0; i < N; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);
        int[] select = new int[M];

        permu(N, M, 0, select, sb, nums, 0);
        System.out.println(sb);
    }

    static public void permu(int N, int M, int cnt, int[] select, StringBuilder sb, int[] nums, int start) {
        if (cnt == M) {
            for (int i = 0; i < M; i++) {
                sb.append(nums[select[i]]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i < N; i++) {

            select[cnt] = i;
            permu(N, M, cnt + 1, select, sb, nums, i);
        }
    }
}
