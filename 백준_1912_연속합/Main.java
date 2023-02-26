package 백준_1912_연속합;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] nums = new int[N];

        int max = -10000;
        int sum = 0;
        for(int i = 0; i < N; i++){
            nums[i] = Integer.parseInt(st.nextToken());
            if(sum < 0){
                sum = 0;
            }
            sum += nums[i];
            max = Math.max(max, sum);
        }
        System.out.println(max);
    }
}
