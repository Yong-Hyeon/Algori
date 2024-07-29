package 백준_9527_1의개수세기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        long binary = 2;
        long binaryTemp = 1;
        long aTemp = A;
        long bTemp = B + 1;


        long aCnt = 0;
        long bCnt = 0;
        while (binaryTemp <= B){
            aCnt = aCnt + (aTemp / binary * binaryTemp) + (aTemp % binary > binaryTemp ? aTemp % binary - binaryTemp : 0);
            bCnt = bCnt + (bTemp / binary * binaryTemp) + (bTemp % binary > binaryTemp ? bTemp % binary - binaryTemp : 0);
            binary = binary << 1;
            binaryTemp = binaryTemp << 1;
        }

        sb.append(bCnt - aCnt).append("\n");
        System.out.println(sb);
    }
}
