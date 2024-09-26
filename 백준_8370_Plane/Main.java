package 백준_8370_Plane;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        sb.append(Integer.parseInt(st.nextToken()) * Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken()) * Integer.parseInt(st.nextToken()));

        System.out.println(sb);
    }
}
