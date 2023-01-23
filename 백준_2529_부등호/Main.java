package 백준_2529_부등호;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static long max;
    static long min;
    static String maxStr;
    static String minStr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");

        int[] selected = new int[N+1];
        boolean[] isSelected = new boolean[10];
        max = 0;
        min = Long.MAX_VALUE;

        per(N, selected, isSelected, input, 0);

        System.out.println(maxStr);
        System.out.println(minStr);
    }

    static void per(int N, int[] selected, boolean[] isSelected, String[] input, int cnt){
        if(cnt == N + 1){
            String temp = "";
            for(int i = 0; i <= N; i++){
                temp += selected[i];
            }
            if(max < Long.parseLong(temp)){
                max = Long.parseLong(temp);
                maxStr = temp;
            }
            if(min > Long.parseLong(temp)){
                min = Long.parseLong(temp);
                minStr = temp;
            }
            return;
        }



        for(int i = 0; i <= 9; i++){
            if(isSelected[i]){
                continue;
            }
            isSelected[i] = true;
            selected[cnt] = i;
            if (cnt > 0) {
                if (input[cnt - 1].equals(">")) {
                    if (selected[cnt - 1] <= selected[cnt]) {
                        isSelected[i] = false;
                        continue;
                    }
                } else if (input[cnt - 1].equals("<")) {
                    if (selected[cnt - 1] >= selected[cnt]) {
                        isSelected[i] = false;
                        continue;
                    }
                }
            }
            per(N, selected, isSelected, input, cnt + 1);
            isSelected[i] = false;
        }
    }


}
