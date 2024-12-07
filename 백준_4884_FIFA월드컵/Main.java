package 백준_4884_FIFA월드컵;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            long G = Long.parseLong(st.nextToken());
            long T = Long.parseLong(st.nextToken());
            long A = Long.parseLong(st.nextToken());
            long D = Long.parseLong(st.nextToken());

            if(G < 0){
                break;
            }

            long tournament = G * A + D;
            long binary = 1;

            while (tournament > binary){
                binary = binary << 1;
            }

            long Y = binary - tournament;

            long X = 0;
            X = T * (T - 1) / 2;

            X = X * G;

            X += binary - 1;

            sb.append(G).append("*").append(A).append("/").append(T).append("+").append(D).append("=").append(X).append("+").append(Y).append("\n");
        }

        System.out.print(sb);
    }
}
