package 백준_1431_시리얼번호;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static class Guitar implements Comparable<Guitar>{
        String num;
        int length;
        int sum;

        Guitar(String num, int length, int sum){
            this.num = num;
            this.length = length;
            this.sum = sum;
        }

        @Override
        public int compareTo(Guitar o){
            return this.length == o.length ? (this.sum == o.sum ? this.num.compareTo(o.num) : this.sum - o.sum) : this.length - o.length;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        String[] inputs = new String[N];
        Guitar[] guitars = new Guitar[N];

        for(int i = 0; i < N; i++){
            String str = br.readLine();
            inputs[i] = str;
            int sum = 0;
            int length = inputs[i].length();
            for(int c = 0; c < length; c++){
                if(str.charAt(c) >= '0' && str.charAt(c) <= '9'){
                    sum += str.charAt(c) - '0';
                }
            }
            guitars[i] = new Guitar(str, length, sum);
        }

        Arrays.sort(guitars);

        for(int i = 0; i < N; i++){
            sb.append(guitars[i].num).append("\n");
        }

        System.out.println(sb);
    }

}
