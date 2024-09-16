package 백준_5522_카드게임;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int sum = 0;
        for(int i = 0; i < 5; i++){
            sum += Integer.parseInt(br.readLine());
        }

        sb.append(sum);
        System.out.println(sb);
    }
}
