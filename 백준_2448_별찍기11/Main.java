package 백준_2448_별찍기11;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        String[] stars = new String[N];
        stars[0] = "  *  ";
        stars[1] = " * * ";
        stars[2] = "*****";

        int k = 1;
        int line = 3;

        while (k * line < N){
            int start = line * k;
            k *= 2;
            int now = line * k;

            for(int i = start; i < now; i++){
                stars[i] = stars[i - start] + " " + stars[i - start];
            }
            String temp = "";
            for(int i = 0; i < start; i++){
                temp += " ";
            }
            for(int i = 0; i < start; i++){
                stars[i] = temp + stars[i] + temp;
            }
        }

        for(int i = 0; i < N; i++){
            sb.append(stars[i]).append("\n");
        }

        System.out.println(sb);
    }
}
