package 백준_1009_분산처리;

import java.io.*;import java.lang.*;import java.util.*;
class Main{
    public static void main(String[]args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int result = pow(a,b);
            sb.append(result == 0 ? 10 : result).append("\n");
        }


        System.out.print(sb);
    }

    static int pow(int a, int b){
        if(b == 1){
            return a % 10;
        }
        int mid = pow(a, b / 2);


        if(b % 2 == 0){
            return (mid * mid) % 10;
        }else{
            return (mid * mid * a) % 10;
        }
    }
}
