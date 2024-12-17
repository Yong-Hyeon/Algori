package 백준_1019_책페이지;

import java.io.BufferedReader;
import java.io.InputStreamReader;
/*
11

1
0~9 + 1
1 + 2

1 4 1 1 1 1 1 1 1 1  1 1 1 1


7

1~7 + 1

19
1 ~ 9 + 1
0 ~ 9 + 1
1 + 10
1 12 2 2 2 2 2  2


999

1의자리
1~9 + 1

10의자리
0 ~ 9 + 9  1자리 10의라지만큼 더하기

1 ~ 8 + 10 -> 9 + 10 10의자리 1부터 지금 숫자까지 다 10씩 더하고 마지막인 9는 일의자리 + 1 만큼 더해주기 0부터 시작하니까

100의자리
0~9 100자리까지 해서 / 10 한만큼 더하기 900 / 10 = 90 | 100의 자리인 9 * 10 만큼 더하기

0~9 100자리 수 9-1 * 10만큼 80씩 더해주기 /// 밑에거 정리하면 0~9 + 90씩
10~99 1~9 10| 100~899 0~9 9 - 1 * 10| 900~ 생각할거 없음 900~910까지만 0 개수 다르니 0을 + 10 해주면 댐 10의자리가 > 0 ? 0 + 10 : 1의자리 + 1 만큼

1~8 + 100 | 100의자리 - 1 까지 + 100 해줌 & 100의자리인 9는 밑에꺼+1만큼 + 해주기 + 100

1000의자리
0~9
 */
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String N = br.readLine();
        int n = N.length();

        int[] cnt = new int[10];

        int start = 1;
        int end = Integer.parseInt(N);
        int point = 1;

        while (start <= end){
            while (start % 10 != 0 && start < end){
                sum(start, cnt, point);
                start++;
            }

            while (end % 10 != 9 && start < end){
                sum(end, cnt, point);
                end--;
            }

            if (start == end){
                sum(start, cnt, point);
                break;
            }else{
                int sum = end / 10 - start / 10 + 1;
                for(int i = 0; i < 10; i++){
                    cnt[i] += sum * point;
                }
            }
            point *= 10;
            start /= 10;
            end /= 10;
        }

        for(int i = 0; i < 10; i++){
            sb.append(cnt[i]).append(" ");
        }
        System.out.println(sb);
    }

    static void sum(int page, int[] cnt, int point){
        while (page > 0){
            cnt[page % 10] += point;
            page /= 10;
        }
    }
}
