import java.io.*;

public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(in.readLine());
		
		for (int tc = 1; tc <= TC; tc++) {
			int n = Integer.parseInt(in.readLine());
			int[][] farm = new int[n][n];
			for (int i = 0; i < n; i++) {
				String s = in.readLine();
				for (int j = 0; j < n; j++) {
					farm[i][j] = s.charAt(j) - '0';
				}
			}
			
			int result = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (i <= n / 2) {
						if (j >= n / 2 - i && j <= n / 2 + i) {
							result += farm[i][j];
						}
					}
					else {
						if (j >= i - n / 2 && j <= n - 1 - i + n / 2) {
							result += farm[i][j];
						}
					}
				}
			}
			
			sb.append("#").append(tc).append(" ").append(result).append("\n");
			
		}
		
		System.out.println(sb);
		
	}
	
}
