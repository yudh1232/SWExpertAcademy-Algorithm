import java.io.*;
import java.util.*;

public class Solution {

	static final int INF = (int) 1e9;
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(in.readLine().trim());
		for (int tc = 1; tc <= TC; tc++) {
			int n = Integer.parseInt(in.readLine().trim());
			int m = Integer.parseInt(in.readLine().trim());
			
			int[][] graph = new int[n + 1][n + 1];
			for (int i = 0; i <= n; i++)
				Arrays.fill(graph[i], INF);
			
			for (int i = 0; i < m; i++) {
				StringTokenizer st = new StringTokenizer(in.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				graph[a][b] = 1;
			}
			
			for (int k = 1; k <= n; k++) {
				for (int i = 1; i <= n; i++) {
					for (int j = 1; j <= n; j++) {
						graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
					}
				}
			}
			
			int[] degree = new int[n + 1];
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if (graph[i][j] != INF) {
						degree[i]++;
						degree[j]++;
					}
				}
			}
			
			int answer = 0;
			for (int i = 1; i <= n; i++) {
				if (degree[i] == n - 1) answer++;
			}
			
			sb.append("#").append(tc).append(" ").append(answer).append("\n");
		}
		
		System.out.println(sb);
	}
	
}
