package 백준_6603_로또;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());

            if(k == 0){
                break;
            }
            int[] nums = new int[k];
            for(int i = 0; i < k; i++){
                nums[i] = Integer.parseInt(st.nextToken());
            }
            int[] selected = new int[k];

            permu(nums, 6, k, selected, 0, 0, sb);

            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void permu(int[] nums, int N, int k, int[] selected, int cnt, int start, StringBuilder sb) {
        if (cnt == N) {
           for(int i = 0; i < N; i++){
               sb.append(nums[selected[i]]).append(" ");
           }
           sb.append("\n");
            return;
        }

        for (int i = start; i < k; i++) {
            selected[cnt] = i;
            permu(nums, N, k, selected, cnt + 1, i+1, sb);
        }
    }
}
