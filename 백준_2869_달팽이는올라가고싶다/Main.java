package 백준_2869_달팽이는올라가고싶다;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        int result = 1;
        V -= A;
        int diff = A - B;
        result += V / diff;
        if(V % diff > 0){
            result++;
        }

        System.out.println(result);
    }
}
