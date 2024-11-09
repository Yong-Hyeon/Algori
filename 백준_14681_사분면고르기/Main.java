package 백준_14681_사분면고르기;
import java.util.*;interface Main{static void main(String[]q){Scanner s=new Scanner(System.in);int a=s.nextInt();int b=s.nextInt();System.out.print(a>0?b>0?1:4:b>0?2:3);}}