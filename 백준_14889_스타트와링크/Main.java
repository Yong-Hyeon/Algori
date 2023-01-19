package 백준_14889_스타트와링크;

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
        int[] start = new int[N/2];
        int[] link = new int[N/2];
        boolean[] isStart = new boolean[N];
        set(N,nums, start, link, 0, 0, isStart);

        System.out.println(min);
    }

    static void set(int N, int[][] nums, int[] start, int[] link, int cnt, int startNum, boolean[] isStart) {
        if (cnt == N/2) {
            int startCnt = 0;
            int linkCnt = 0;
            for(int i = 0; i < N; i++){
                if(isStart[i]){
                    start[startCnt++] = i;
                }else{
                    link[linkCnt++] = i;
                }
            }
            startSum = 0;
            linkSum = 0;

            setStart(nums, N/2, 0, start, new int[2], 0);
            setLink(nums, N/2, 0, link, new int[2], 0);

            min = Math.min(min, Math.abs(startSum-linkSum));
            return;
        }

        for (int i = startNum; i < N; i++) {
            isStart[i] = true;
            set(N, nums, start, link, cnt+1, i+1, isStart);
            isStart[i] = false;
        }
    }

    static void setStart(int[][] nums, int N, int cnt, int[] team, int[] isSelected, int start){
        if(cnt == 2){
            startSum += nums[team[isSelected[0]]][team[isSelected[1]]];
            startSum += nums[team[isSelected[1]]][team[isSelected[0]]];
            return;
        }

        for(int i = start; i < N; i++){
            isSelected[cnt] = i;
            setStart(nums, N, cnt + 1, team, isSelected, i + 1);
        }
    }

    static void setLink(int[][] nums, int N, int cnt, int[] team, int[] isSelected, int start){
        if(cnt == 2){
            linkSum += nums[team[isSelected[0]]][team[isSelected[1]]];
            linkSum += nums[team[isSelected[1]]][team[isSelected[0]]];
            return;
        }

        for(int i = start; i < N; i++){
            isSelected[cnt] = i;
            setLink(nums, N, cnt + 1, team, isSelected, i + 1);
        }
    }
}
