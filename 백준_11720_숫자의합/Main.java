package 백준_11720_숫자의합;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int sum = 0;
        String[] nums = br.readLine().split("");
        for(int i = 0; i < N; i++){
            int num =  Integer.parseInt(nums[i]);
            sum += num;
        }

        System.out.println(sum);
    }
}
