package 백준_2230_수고르기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;
        int right = 1;
        if(M == 0){
            System.out.println(0);
        }else{
            for(int i = 0; i < N; i++){
                while (arr[right] - arr[i] < M){
                    right++;
                    if(right >= N){
                        break;
                    }
                }
                if(right >= N){
                    break;
                }
                min = Math.min(min, arr[right] - arr[i]);
            }
            System.out.println(min);
        }

    }

}
