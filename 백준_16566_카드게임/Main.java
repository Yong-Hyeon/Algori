package 백준_16566_카드게임;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] input = new int[M];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++){
            input[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(input);
        int[] next = new int[4000001];
        for(int i = 0; i < M - 1; i++){
            next[input[i]] = input[i+1];
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < K; i++){
            search(sb, input, next, Integer.parseInt(st.nextToken()), M);
        }

        System.out.println(sb);
    }

    private static void search(StringBuilder sb, int[] input, int[] next, int num, int size) {
        int left = 0;
        int right = size;
        while (left < right){
            int mid = (left + right) / 2;

            if(input[mid] > num){
                right = mid;
            }else{
                left = mid + 1;
            }
        }

        sb.append(input[left]).append("\n");
        int ne = next[input[left]];
        if(left > 0){
            next[input[left-1]] = ne;
        }

        while (left < size && ne != 0 && input[left] != ne){
            input[left++] = ne;
        }

    }
}
