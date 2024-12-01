package 백준_1340_연도진행바;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), ",");
        StringTokenizer sst = new StringTokenizer(st.nextToken());
        String Month = sst.nextToken();
        int D = Integer.parseInt(sst.nextToken());
        sst = new StringTokenizer(st.nextToken().trim());
        int Y = Integer.parseInt(sst.nextToken());
        sst = new StringTokenizer(sst.nextToken(), ":");
        int H = Integer.parseInt(sst.nextToken());
        int M = Integer.parseInt(sst.nextToken());

        String[] Months = "January, February, March, April, May, June, July, August, September, October, November, December".split(", ");
        int[] months = {31,28,31,30,31,30,31,31,30,31,30,31};

        int oneYear = 365 * 24 * 60;
        int sum = 0;

        if(Y % 400 == 0 || (Y % 4 == 0 && Y % 100 != 0)){
            oneYear += 24 * 60;
        }

        for(int i = 0; i < 12; i++){
            if(i == 2){
                if(Y % 400 == 0 || (Y % 4 == 0 && Y % 100 != 0)){
                    sum++;
                }
            }
            if(Months[i].equals(Month)){
                sum += D;
                break;
            }
            sum += months[i];
        }
        sum--;
        sum = sum * 24 * 60;
        sum += H * 60;
        sum += M;

        sb.append((double)sum/oneYear*100.0);


        System.out.print(sb);
    }
}
