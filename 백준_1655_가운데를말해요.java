import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class 백준_1655_가운데를말해요 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pqAsc = new PriorityQueue<>();
		PriorityQueue<Integer> pqDesc = new PriorityQueue<>(Collections.reverseOrder());
		
		int mid = Integer.parseInt(br.readLine());
		sb.append(mid).append("\n");
		
		for(int i = 2 ; i <= N; i++) {
			int temp = Integer.parseInt(br.readLine());
			if(i % 2 == 0) {
				if(temp >= mid) {
					pqAsc.add(temp);
					sb.append(mid).append("\n");
				}else {
					pqDesc.add(temp);
					pqAsc.add(mid);
					mid = pqDesc.poll();
					sb.append(mid).append("\n");					
				}
			}else {
				if(temp > mid) {
					pqDesc.add(mid);
					pqAsc.add(temp);
					mid = pqAsc.poll();
					sb.append(mid).append("\n");					
				}else {
					pqDesc.add(temp);
					sb.append(mid).append("\n");					
				}
			}
		}
		
		System.out.println(sb);
	}

}
