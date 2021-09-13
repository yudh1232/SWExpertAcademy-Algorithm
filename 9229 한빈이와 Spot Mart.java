import java.io.*;
import java.util.StringTokenizer;

public class Solution {

	static int n;
	static int m;
	static int[] weights;
	static int[] selected;
	static int maxResult;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int TC = Integer.parseInt(in.readLine());

		for (int tc = 1; tc <= TC; tc++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			weights = new int[n];
			selected = new int[2];
			maxResult = -1;
			
			
			st = new StringTokenizer(in.readLine(), " ");
			for (int i = 0; i < n; i++) {
				weights[i] = Integer.parseInt(st.nextToken());
			}
			
			combination(0, 0);
			
			sb.append("#").append(tc).append(" ").append(maxResult).append("\n");
		}
		
		System.out.println(sb);
		
	}

	private static void combination(int cnt, int start) {

		if (cnt == 2) {
			int weightSum = selected[0] + selected[1];
			if (weightSum <= m && weightSum > maxResult) maxResult = weightSum;
			return;
		}

		for (int i = start; i < n; i++) {
			selected[cnt] = weights[i];
			combination(cnt + 1, i + 1);
		}
	}
}
