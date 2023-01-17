package 백준_14501_퇴사;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int max;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        int[][] nums = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            nums[i][0] = Integer.parseInt(st.nextToken());
            nums[i][1] = Integer.parseInt(st.nextToken());
        }
        max = 0;


        day(N, nums, 0, 0);


        System.out.println(max);
    }

    static void day(int N, int[][] nums, int sum, int day) {
        if (day == N) {
            max = Math.max(max, sum);
            return;
        }
        if (day > N) {
            return;
        }
        max = Math.max(max, sum);
        for (int i = day; i < N; i++) {
            day(N, nums, sum + nums[i][1], i + nums[i][0]);
        }
    }
}
