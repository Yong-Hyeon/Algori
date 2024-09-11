package 백준_1284_집주소;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[] size = {5, 3, 4, 4, 4, 4, 4, 4, 4, 4};

        while (true) {
            String str = br.readLine();
            if("0".equals(str)){
                break;
            }
            int length = str.length();
            int sum = 1;
            for(int i = 0; i < length; i++){
                sum += size[str.charAt(i) - '0'];
            }
            sb.append(sum).append("\n");
        }

        System.out.println(sb);
    }

}
