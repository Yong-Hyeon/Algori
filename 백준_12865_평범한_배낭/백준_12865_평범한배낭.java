import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_12865_평범한배낭 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] W = new int[N];
		int[] V = new int[N];
		int[] bag = new int[K + 1];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			W[i] = Integer.parseInt(st.nextToken());
			V[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < N; i++) {
			for (int j = K; j >= W[i]; j--) {
				bag[j] = Math.max(bag[j], bag[j - W[i]] + V[i]);
			}
		}

		System.out.println(bag[K]);

	}

}
