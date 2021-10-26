import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		final int INF = 1000000000;
		
		int TC = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int n = Integer.parseInt(st.nextToken());
			
			int[][] graph = new int[n + 1][n + 1];
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					int cost = Integer.parseInt(st.nextToken());
					if (cost == 0 && i != j) cost = INF;
					graph[i][j] = cost;
				}
			}
			
			for (int k = 1; k <= n; k++) {
				for (int i = 1; i <= n; i++) {
					for (int j = 1; j <= n; j++) {
						graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
					}
				}
			}
			
			int result = INF;
			for (int i = 1; i <= n; i++) {
				int sum = 0;
				for (int j = 1; j <= n; j++) {
					sum += graph[i][j];
				}
				result = Math.min(result, sum);
			}
			
			sb.append("#").append(tc).append(" ").append(result).append("\n");
		}
		System.out.println(sb);
	}
	
}
