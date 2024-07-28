package 백준_7453_합이0인네정수;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int NN = N * N;

        int[][] input = new int[N][4];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 4; j++){
                input[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] sumAB = new int[NN];
        int[] sumCD = new int[NN];

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                sumAB[i * N + j] = input[i][0] + input[j][1];
                sumCD[i * N + j] = input[i][2] + input[j][3];
            }
        }
        Arrays.sort(sumAB);
        Arrays.sort(sumCD);

        int i = 0;
        int j = NN - 1;

        long result = 0;

        while (i < NN && j >= 0){
            int ab = sumAB[i];
            int cd = sumCD[j];
            int sum = ab + cd;

            if(sum == 0){
                long cntAB = 0;
                long cntCD = 0;
                while (i < NN && ab == sumAB[i]){
                    i++;
                    cntAB++;
                }
                while (j >= 0 && cd == sumCD[j]){
                    j--;
                    cntCD++;
                }
                result += cntAB * cntCD;
            }else if(sum > 0){
                j--;
            }else{
                i++;
            }
        }

        sb.append(result).append("\n");
        System.out.println(sb);
    }
}
