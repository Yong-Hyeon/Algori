package 백준_10807_개수세기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(br.readLine());
        int result = 0;
        for(int i = 0; i < N; i++){
            if(v == Integer.parseInt(st.nextToken())){
                result++;
            }
        }

        sb.append(result);

        System.out.println(sb);
    }
}
