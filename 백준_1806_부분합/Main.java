package 백준_1806_부분합;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int[] input = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            input[i] = Integer.parseInt(st.nextToken());
        }

        int min = 200000;

        int i = 0;
        int j = 0;
        int sum = input[0];
        int cnt = 1;
        while (j < N && i <= j){
            if(sum >= S){
                min = Math.min(min, cnt);
                cnt--;
                sum -= input[i];
                i++;
            }else{
                j++;
                cnt++;
                if(j >= N){
                    break;
                }
                sum = sum + input[j];
            }
        }

        sb.append(min == 200000? 0 : min).append("\n");

        System.out.println(sb);
    }
}
