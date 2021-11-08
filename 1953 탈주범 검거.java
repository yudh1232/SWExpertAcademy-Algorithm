import java.io.*;
import java.util.*;

public class Solution {

	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	static int[][] tunnelGraph = {
			{0, 0, 0, 0, 0, 0, 0, 0},
			{0, 15, 3, 12, 6, 5, 9, 10},
			{0, 3, 3, 0, 2, 1, 1, 2},
			{0, 12, 0, 12, 4, 4, 8 ,8},
			{0, 9, 1, 8, 0, 1, 9, 8},
			{0, 10, 2, 8, 2, 0, 8, 10},
			{0, 6, 2, 4, 6, 4, 0, 2},
			{0, 5, 1, 4, 4, 5, 1, 0}
	};
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());
			
			int[][] underground = new int[n][m];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(in.readLine());
				for (int j = 0; j < m; j++) {
					underground[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			boolean[][] visited = new boolean[n][m];
			int answer = 0;
			
			Queue<int[]> q = new LinkedList<int[]>();
			q.offer(new int[] {r, c, 1});
			answer++;
			visited[r][c] = true;
			
			while (!q.isEmpty()) {
				int[] now = q.poll();
				int x = now[0];
				int y = now[1];
				int time = now[2];
				
				if (time == l) break;
				
				for (int d = 0; d < 4; d++) {
					int nx = x + dx[d];
					int ny = y + dy[d];
					if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
					if (visited[nx][ny]) continue;
					if (((1 << d) & tunnelGraph[underground[x][y]][underground[nx][ny]]) != 0) {
						q.offer(new int[] {nx, ny, time + 1});
						answer++;
						visited[nx][ny] = true;
					}
				}
			}
			
			sb.append("#").append(tc).append(" ").append(answer).append("\n");
		}
		
		System.out.println(sb);
	}
	
}
