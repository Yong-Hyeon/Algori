package 백준_15661_링크와스타트;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int min;
    static int startSum;
    static int linkSum;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        int[][] nums = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                nums[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        min = Integer.MAX_VALUE;
        int[] start = new int[N];
        int[] link = new int[N];
        boolean[] isStart = new boolean[N];
        for (int i = 2; i < N; i++) {
            set(N, nums, start, link, 0, 0, isStart, i);
        }

        System.out.println(min);
    }

    static void set(int N, int[][] nums, int[] start, int[] link, int cnt, int startNum, boolean[] isStart, int startMax) {
        if (cnt == startMax) {
            int startCnt = 0;
            int linkCnt = 0;
            for (int i = 0; i < N; i++) {
                if (isStart[i]) {
                    start[startCnt++] = i;
                } else {
                    link[linkCnt++] = i;
                }
            }
            startSum = 0;
            linkSum = 0;

            setStart(nums, startMax, 0, start, new int[2], 0);
            setLink(nums, N - startMax, 0, link, new int[2], 0);

            min = Math.min(min, Math.abs(startSum - linkSum));
            return;
        }

        for (int i = startNum; i < N; i++) {
            isStart[i] = true;
            set(N, nums, start, link, cnt + 1, i + 1, isStart, startMax);
            isStart[i] = false;
        }
    }

    static void setStart(int[][] nums, int N, int cnt, int[] team, int[] isSelected, int start) {
        if (cnt == 2) {
            startSum += nums[team[isSelected[0]]][team[isSelected[1]]];
            startSum += nums[team[isSelected[1]]][team[isSelected[0]]];
            return;
        }

        for (int i = start; i < N; i++) {
            isSelected[cnt] = i;
            setStart(nums, N, cnt + 1, team, isSelected, i + 1);
        }
    }

    static void setLink(int[][] nums, int N, int cnt, int[] team, int[] isSelected, int start) {
        if (cnt == 2) {
            linkSum += nums[team[isSelected[0]]][team[isSelected[1]]];
            linkSum += nums[team[isSelected[1]]][team[isSelected[0]]];
            return;
        }

        for (int i = start; i < N; i++) {
            isSelected[cnt] = i;
            setLink(nums, N, cnt + 1, team, isSelected, i + 1);
        }
    }
}
