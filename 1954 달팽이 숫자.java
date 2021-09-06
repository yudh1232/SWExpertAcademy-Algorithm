import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();
		
		// 우, 하, 좌, 상
		int[] dx = {0, 1, 0, -1};
		int[] dy = {1, 0, -1, 0};
		
		for (int tc = 1; tc <= TC; tc++) {
			int n = Integer.parseInt(in.readLine());
			int[][] grid = new int[n][n];
			
			grid[0][0] = 1;
			int x = 0;
			int y = 0;
			int value = 2;
			while (true) {
				if (value > n * n) break;
				
				for (int d = 0; d < 4; d++) {
					while (true) {
						int nx = x + dx[d];
						int ny = y + dy[d];
						if (nx < 0 || nx >= n || ny < 0 || ny >= n || grid[nx][ny] != 0) break;
						else {
							grid[nx][ny] = value;
							value++;
							x = nx;
							y = ny;
						}
					}
				}
			}
			
			sb.append("#").append(tc).append("\n");
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					sb.append(grid[i][j]).append(" ");
				}
				sb.setLength(sb.length() - 1);
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}

}
