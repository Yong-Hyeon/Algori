package 백준_1308_DDay;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int nowY = Integer.parseInt(st.nextToken());
        int nowM = Integer.parseInt(st.nextToken());
        int nowD = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int nextY = Integer.parseInt(st.nextToken());
        int nextM = Integer.parseInt(st.nextToken());
        int nextD = Integer.parseInt(st.nextToken());

        int[] days = {0,31,28,31,30,31,30,31,31,30,31,30,31};

        int dDay = 0;
        if(nextD >= nowD){
            dDay += nextD - nowD;
        }else{
            dDay += days[nowM] - nowD + nextD;
            if(nowM == 2){
                if(nowY % 4 == 0){
                    dDay++;
                    if(nowY % 100 == 0){
                        dDay--;
                        if(nowY % 400 == 0){
                            dDay++;
                        }
                    }
                }
            }
            nowM++;
        }
        if(nowM == 13){
            nowM = 1;
            nowY++;
        }
        while (nextM != nowM){
            if(nowM == 2){
                if(nowY % 4 == 0){
                    dDay++;
                    if(nowY % 100 == 0){
                        dDay--;
                        if(nowY % 400 == 0){
                            dDay++;
                        }
                    }
                }
            }
            dDay += days[nowM];
            nowM++;
            if(nowM == 13){
                nowM = 1;
                nowY++;
            }
        }

        if(nextY - nowY >= 1000){
            sb.append("gg");
        }else{
            while (nextY != nowY){
                dDay += 365;
                if(nowY % 4 == 0){
                    dDay++;
                    if(nowY % 100 == 0){
                        dDay--;
                        if(nowY % 400 == 0){
                            dDay++;
                        }
                    }
                }
                nowY++;
            }
            sb.append("D-").append(dDay);
        }

        System.out.println(sb);
    }
}
