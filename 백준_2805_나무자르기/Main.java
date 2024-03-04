package 백준_2805_나무자르기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long[] trees = new long[N];
        st = new StringTokenizer(br.readLine());

        long maxTree = 0;
        for(int i = 0; i < N; i++){
            long tree = Long.parseLong(st.nextToken());
            trees[i] = tree;
            maxTree = maxTree < tree ? tree : maxTree;
        }

        long start = 0;
        long end = maxTree;
        long mid = 0;

        long sum = 0;
        long min = Long.MAX_VALUE;

        while (true){
            mid = (start + end) / 2;
            sum = 0;
            if(mid == start){
                break;
            }

            for(int i = 0; i < N; i++){
                sum += trees[i] - mid < 0 ? 0 : trees[i] - mid;
                if(sum > min){
                    start = mid;
                    break;
                }
            }

            if(sum >= M && sum < min){
                min = sum;
                start = mid;
            }else{
                end = mid;
            }
        }

        System.out.println(mid);
    }

}
