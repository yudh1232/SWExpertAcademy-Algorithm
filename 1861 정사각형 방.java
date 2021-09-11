import java.io.*;
import java.util.StringTokenizer;

public class Solution {

	static int[][] grid;
	static int[][] visited;
	static int n;
	static int maxCount;
	static int maxRoomNum;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	private static void dfs(int x, int y, int level) {
		if (level <= visited[x][y]) return;
		
		visited[x][y] = level;
		if (visited[x][y] > maxCount) {
			maxCount = visited[x][y];
			maxRoomNum = grid[x][y];
		}
		else if (visited[x][y] == maxCount) {
			if (grid[x][y] < maxRoomNum ) maxRoomNum = grid[x][y];
		}
		
		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			if (nx >= 0 && nx < n && ny >= 0 && ny < n && grid[x][y] - grid[nx][ny] == 1) {
				dfs(nx, ny, level + 1);
			}
		}		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(in.readLine());
		
		for (int tc = 1; tc <= TC; tc++) {
			n = Integer.parseInt(in.readLine());
			grid = new int[n][n];
			visited = new int[n][n];
			maxCount = 0;
			maxRoomNum = 0;
			
			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(in.readLine(), " ");
				for (int j = 0; j < n; j++) {
					grid[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for (int x = 0; x < n; x++) {
				for (int y = 0; y < n; y++) {
						dfs(x, y, 1);
				}
			}
			
			sb.append("#").append(tc).append(" ").append(maxRoomNum).append(" ").append(maxCount).append("\n");
			
		}
		
		System.out.println(sb);
		
	}
	
}
