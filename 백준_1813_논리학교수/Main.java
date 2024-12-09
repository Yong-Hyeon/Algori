package 백준_1813_논리학교수;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int[] cnt = new int[51];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++){
            cnt[Integer.parseInt(st.nextToken())]++;
        }

        boolean isTrue = false;
        int result = 0;
        for(int i = 0; i <= 50; i++){
            if(cnt[i] == i){
                result = i;
                isTrue = true;
            }
        }

        if(isTrue){
            sb.append(result);
        }else{
            sb.append(-1);
        }

        System.out.print(sb);
    }
}
