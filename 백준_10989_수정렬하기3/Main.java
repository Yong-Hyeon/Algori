package 백준_10989_수정렬하기3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        int[] nums = new int[10001];

        for(int i = 0; i < N; i++){
            int num = Integer.parseInt(br.readLine());
            nums[num]++;
        }

        for(int i = 1; i <= 10000; i++){
            for(int j = 0; j < nums[i]; j++){
                sb.append(i).append("\n");
            }
        }

        System.out.println(sb);
    }
}
