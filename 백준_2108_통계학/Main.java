package 백준_2108_통계학;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        int[] arr = new int[N];
        int[] frequency = new int[8001];
        int sum = 0;

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            sum += num;
            arr[i] = num;
            frequency[num + 4000]++;
        }

        Arrays.sort(arr);
        sb.append(Math.round((double) sum / N)).append("\n");
        sb.append(arr[N / 2]).append("\n");

        int max = -1;
        for (int i = 0; i <= 8000; i++) {
            max = Math.max(max, frequency[i]);
        }
        int cnt = 0;
        int maxIdx = 0;
        for (int i = 0; i <= 8000; i++) {
            if(cnt == 2){
                break;
            }
            if(max == frequency[i]){
                cnt++;
                maxIdx = i;
            }
        }
        sb.append(maxIdx-4000).append("\n");
        sb.append(arr[N-1] - arr[0]).append("\n");

        System.out.println(sb);

    }
}
