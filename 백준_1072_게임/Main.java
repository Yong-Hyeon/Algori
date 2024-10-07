package 백준_1072_게임;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        long X = Long.parseLong(st.nextToken());
        long Y = Long.parseLong(st.nextToken());

        long Z = Y * 100 / X;
        long left = 1;
        long right = X;
        long result = -1;

        while (left <= right){
            long mid = (left + right) / 2;
            long z = (Y + mid) * 100 / (X + mid);
            if(z > Z){
                result = mid;
                right = mid;
                if(left == right){
                    break;
                }
            }else{
                left = mid + 1;
            }
        }

        sb.append(result);
        System.out.println(sb);
    }
}
