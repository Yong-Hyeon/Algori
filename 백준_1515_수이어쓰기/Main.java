package 백준_1515_수이어쓰기;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();
        int size = str.length();
        int point = 0;
        for(int base = 1; base < 30000; base++){
            String temp = base + "";
            for(int i = 0; i < temp.length(); i++){
                if (temp.charAt(i) == str.charAt(point)){
                    point++;
                }
                if(point == size){
                    sb.append(base);
                    break;
                }
            }
            if(point == size){
                break;
            }
        }


        System.out.println(sb);
    }

}
