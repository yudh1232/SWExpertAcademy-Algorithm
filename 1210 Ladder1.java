import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int[][] grid = new int[100][100];
		StringBuilder sb = new StringBuilder();
		
		for (int tc = 1; tc <= 10; tc++) {
			int n = Integer.parseInt(in.readLine());
			for (int i = 0; i < 100; i++) {
				StringTokenizer st = new StringTokenizer(in.readLine(), " ");
				for (int j = 0; j < 100; j++) {
					grid[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int x = 0;
			int y = 0;
			for (int j = 0; j < 100; j++) {
				if (grid[99][j] == 2) {
					x = 99;
					y = j;
				}
			}
			
			while (true) {
				if (x == 0)
					break;
				
				if (y - 1 >= 0 && grid[x][y - 1] == 1) {
					while (true) {
						y = y - 1;
						if (y - 1 < 0 || grid[x][y - 1] != 1) break;
					}
				}
				else if (y + 1 < 100 && grid[x][y + 1] == 1) {
					while (true) {
						y = y + 1;
						if (y + 1 >= 100 || grid[x][y + 1] != 1) break;
					}
				}
				
				x = x - 1;
			}
			
			sb.append("#").append(n).append(" ").append(y).append("\n");
			
		}
		
		System.out.println(sb);
		
	}
	
}
