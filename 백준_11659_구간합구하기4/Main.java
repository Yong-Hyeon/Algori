package 백준_11659_구간합구하기4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int sum;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] nums = new int[N+1];
        int[] segment = new int[N * 4];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++){
            int num = Integer.parseInt(st.nextToken());
            nums[i] = num;
        }

        init(segment, nums, 1, N, 1);

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            sum = 0;
            sum(segment, 1, N, 1, start, end);
            sb.append(sum).append("\n");
        }

        System.out.println(sb);
    }

    static int init (int[] segment, int[] nums, int left, int right, int node){
        if(left == right){
            segment[node] = nums[left];
            return  nums[left];
        }
        segment[node] = init(segment, nums, left, (left+right)/2, node * 2) + init(segment, nums, (left + right) / 2 + 1, right, node * 2 + 1);
        return  segment[node];
    }

    static void sum(int[] segment, int left, int right, int node, int start, int end){
        if(start > right || end < left){
            return;
        }

        if(start <= left && end >= right){
            sum += segment[node];
            return;
        }
        int mid = (left + right) / 2;
        sum(segment, left, mid, node * 2, start, end);
        sum(segment, mid + 1, right, node * 2 + 1, start, end);

    }
}
