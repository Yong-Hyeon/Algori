package 백준_2920_음계;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] nums = new int[8];
        boolean isSort = false;
        for (int i = 0; i < 8; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= 8; i++) {
            if (i != nums[i - 1]) {
                break;
            }
            if (i == 8) {
                System.out.println("ascending");
                isSort = true;
            }
        }

        for (int i = 8; i >= 1; i--) {
            if (i != nums[8 - i]) {
                break;
            }
            if (i == 1) {
                System.out.println("descending");
                isSort = true;
            }
        }

        if (!isSort) {
            System.out.println("mixed");
        }
    }
}
