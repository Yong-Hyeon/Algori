package 백준_2473_세용액;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static long min;
    static long[] minIdx;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        long[] input = new long[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            input[i] = Long.parseLong(st.nextToken());
        }
        min = 5000000000l;
        minIdx = new long[3];
        Arrays.sort(input);

        for(int i = 0; i < N; i++){
            search(N, input, 0, N-1, i);
        }

        Arrays.sort(minIdx);

        sb.append(minIdx[0]).append(" ").append(minIdx[1]).append(" ").append(minIdx[2]).append("\n");
        System.out.println(sb);
    }

    static void search(int N, long[] input, int left, int right, int cnt){
        if(left == right){
            return;
        }
        if(left == cnt || right == cnt){
            return;
        }
        long sum = input[left] + input[right];
        long dist = sum + input[cnt];
        if(Math.abs(dist) < min){
            min = Math.abs(dist);
            minIdx[0] = input[left];
            minIdx[1] = input[right];
            minIdx[2] = input[cnt];
        }


        if(dist < 0){
            search(N, input, left + 1, right, cnt);
        }else if(dist > 0){
            search(N, input, left, right - 1, cnt);
        }

    }
}
