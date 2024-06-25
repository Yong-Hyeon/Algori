package 백준_16953_AtoB;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static boolean isEnd;
    static int result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        result = 0;
        isEnd = false;
        check(A, B, 1);
        if(result == 0){
            sb.append(-1).append("\n");
        }else{
            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }

    private static void check(int A, int B, int cnt) {
        if(isEnd){
            return;
        }
        if(A == B){
            isEnd = true;
            result = cnt;
        }
        if(A > B){
            return;
        }

        check(A * 2, B, cnt + 1);
        if(A < 100000000){
            check(Integer.parseInt(A + "1"), B, cnt + 1);
        }
    }
}