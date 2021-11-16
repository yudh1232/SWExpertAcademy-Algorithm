import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int TC = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			st = new StringTokenizer(in.readLine());
			int n = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			
			int[][] map = new int[n][n];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(in.readLine());
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int answer = 0;
			int state = 0;
			int sameCount = 0;
			
			for (int i = 0; i < n; i++) {
				state = 0;
				sameCount = 1;
				for (int j = 1; j < n; j++) {
					if (Math.abs(map[i][j - 1] - map[i][j]) > 1)
						break;
					
					if (map[i][j - 1] - map[i][j] == 0) {
						sameCount++;
						if (state == 1 && sameCount == x) {
							state = 0;
							sameCount = 0;
						}
					}
					else if (map[i][j - 1] - map[i][j] == 1) {
						if (state == 1 && sameCount < x)
							break;
						state = 1;
						sameCount = 1;
					}
					else { // map[i][j - 1] - map[i][j] == -1
						if (sameCount < x)
							break;
						state = 0;
						sameCount = 1;
					}
					
					if (j == n - 1) {
						if (state != 1 || sameCount >= x)
							answer++;
					}
				}
			}
			
			for (int j = 0; j < n; j++) {
				state = 0;
				sameCount = 1;
				for (int i = 1; i < n; i++) {
					if (Math.abs(map[i - 1][j] - map[i][j]) > 1)
						break;
					
					if (map[i - 1][j] - map[i][j] == 0) {
						sameCount++;
						if (state == 1 && sameCount == x) {
							state = 0;
							sameCount = 0;
						}
					}
					else if (map[i - 1][j] - map[i][j] == 1) {
						if (state == 1 && sameCount < x)
							break;
						state = 1;
						sameCount = 1;
					}
					else { // map[i - 1][j] - map[i][j] == -1
						if (sameCount < x)
							break;
						state = 0;
						sameCount = 1;						
					}
					
					if (i == n - 1) {
						if (state != 1 || sameCount >= x)
							answer++;
					}
				}
			}
			
			sb.append("#").append(tc).append(" ").append(answer).append("\n");
		}
		
		System.out.println(sb);
	}
	
}
