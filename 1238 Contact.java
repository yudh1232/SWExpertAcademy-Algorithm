import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		for (int tc = 1; tc <= 10; tc++) {
			st = new StringTokenizer(in.readLine(), " ");
			int n = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());
			
			boolean[][] graph = new boolean[101][101];
			boolean[] visited = new boolean[101];
			
			st = new StringTokenizer(in.readLine(), " ");
			for (int i = 0; i < n / 2; i++) {
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				graph[a][b] = true;
			}
			
			Queue<Integer> q = new LinkedList<Integer>();
			q.offer(start);
			visited[start] = true;
			
			List<Integer> result = new ArrayList<Integer>();			
			while (!q.isEmpty()) {
				result.clear();
				int size = q.size();
				for (int k = 0; k < size; k++) {
					int now = q.poll();
					result.add(now);
					for (int i = 1; i <= 100; i++) {
						if (graph[now][i] && !visited[i]) {
							q.offer(i);
							visited[i] = true;
						}
					}
				}
			}
			
			int max = 0;
			for (int i = 0; i < result.size(); i++) {
				if (result.get(i) > max) max = result.get(i);
			}
			
			sb.append("#").append(tc).append(" ").append(max).append("\n");
		}
		
		System.out.println(sb);
	}
	
}
