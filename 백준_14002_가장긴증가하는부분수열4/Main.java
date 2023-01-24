package 백준_14002_가장긴증가하는부분수열4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] input = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }
        int[] dp = new int[N];
        int max = 1;
        String result = "";
        Arrays.fill(dp,1);

        for(int i = 1; i < N; i++){
            for(int j = 0; j < i; j++){
                if(input[i] > input[j]){
                    if(dp[i] < dp[j] + 1){
                        dp[i] = dp[j] + 1;
                    }
                }
            }
            if(max < dp[i]){
                max = dp[i];
            }
        }

        int temp = max;
        Stack<Integer> stack = new Stack<>();
        for(int i = N-1; i >= 0; i--){
            if(dp[i] == temp){
                stack.add(input[i]);
                temp--;
            }
        }

        while (!stack.isEmpty()){
            result += stack.pop() + " ";
        }

        System.out.println(max);
        System.out.println(result);
    }
}
