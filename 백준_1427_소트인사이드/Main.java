package 백준_1427_소트인사이드;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        char[] inputs = br.readLine().toCharArray();

        Arrays.sort(inputs);

        int size = inputs.length;

        for(int i = size-1; i >= 0; i--){
            sb.append(inputs[i]);
        }

        System.out.print(sb);
    }
}