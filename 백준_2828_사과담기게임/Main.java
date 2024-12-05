package 백준_2828_사과담기게임;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int J = Integer.parseInt(br.readLine());

        int dist = 0;
        int left = 1;
        int right = M;

        for(int i = 0; i < J; i++){
            int j = Integer.parseInt(br.readLine());

            if(j < left){
                right -= left - j;
                dist += left - j;
                left -= left - j;
            }else if(j > right){
                left += j - right;
                dist += j - right;
                right += j - right;
            }
        }

        sb.append(dist);
        System.out.print(sb);
    }
}
