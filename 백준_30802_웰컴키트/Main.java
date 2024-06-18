package 백준_30802_웰컴키트;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());
        int[] shirt = new int[6];

        st = new StringTokenizer(br.readLine());
        int penSum = 0;
        for(int i = 0; i < 6; i++){
            int num = Integer.parseInt(st.nextToken());
            penSum += num;
            shirt[i] = num;
        }
        st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        int shireSum = 0;
        for(int i = 0; i < 6; i++){
            shireSum += shirt[i] / T;
            if(shirt[i] % T != 0){
                shireSum++;
            }
        }

        sb.append(shireSum).append("\n");
        sb.append(penSum / P).append(" ").append(penSum % P).append("\n");

        System.out.println(sb);
    }
}
