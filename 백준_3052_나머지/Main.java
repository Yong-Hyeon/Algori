package 백준_3052_나머지;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] nums = new int[42];
        int cnt = 0;

        for (int i = 0; i < 10; i++) {
            int num = Integer.parseInt(br.readLine());
            nums[num%42]++;
            if(nums[num%42] == 1){
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
