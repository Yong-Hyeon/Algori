package 백준_2467_용액;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int min;
    static int[] minIdx;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] input = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            input[i] = Integer.parseInt(st.nextToken());
        }
        min = 2000000001;
        minIdx = new int[2];
        int mid = N / 2;

        search(N, input, mid-1, mid, min);

        sb.append(input[minIdx[0]]).append(" ").append(input[minIdx[1]]).append("\n");
        System.out.println(sb);
    }

    static void search(int N, int[] input, int left, int right, int before){
        if(left == right){
            return;
        }
        if(left < 0 || right >= N){
            return;
        }
        int sum = input[left] + input[right];
        if(Math.abs(sum) < min){
            min = Math.abs(sum);
            minIdx[0] = left;
            minIdx[1] = right;
        }

        if(input[left] < 0 && input[right] < 0){
            search(N, input, left + 1, right + 1, before);
        }else if(input[left] > 0 && input[right] > 0){
            search(N, input, left - 1, right - 1, before);
        }else{
            if(sum < 0){
                search(N, input, left, right + 1, before);
            }else{
                search(N, input, left -1, right, before);
            }
        }
    }
}
