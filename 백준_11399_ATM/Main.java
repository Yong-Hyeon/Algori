package 백준_11399_ATM;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] times = new int[N];
        for(int i = 0; i < N; i++){
            times[i] = Integer.parseInt(st.nextToken());
        }

        int result = 0;
        int sum = 0;

        Arrays.sort(times);

        for(int i = 0; i < N; i++){
            sum += times[i];
            result += sum;
        }

        System.out.println(result);
    }
}
