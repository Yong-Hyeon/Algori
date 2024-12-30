package 백준_19813_dates;

import java.io.*;import java.lang.*;import java.util.*;
class Main{
    public static void main(String[]args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++){
            String str = br.readLine();
            String d = "";
            String m = "";
            String y = "";
            if(str.charAt(1) == '.' || str.charAt(2) == '.'){
                String[] temp = str.split("\\.");
                d = temp[0];
                m = temp[1];
                y = temp[2];
            }else{
                String[] temp = str.split("/");
                d = temp[1];
                m = temp[0];
                y = temp[2];
            }
            if(d.length() == 1){
                d = "0" + d;
            }
            if(m.length() == 1){
                m = "0" + m;
            }
            if(y.length() != 4){
                int size = y.length();
                for(int j = 0; j < 4 - size; j++){
                    y = "0" + y;
                }
            }

            sb.append(d).append(".").append(m).append(".").append(y).append(" ");
            sb.append(m).append("/").append(d).append("/").append(y).append("\n");
        }

        System.out.print(sb);
    }
}