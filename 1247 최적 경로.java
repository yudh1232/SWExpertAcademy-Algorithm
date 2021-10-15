import java.io.*;
import java.util.*;

public class Solution {

	static int n, result;
	static int[] company, home, numbers;
	static int[][] customer;
	static boolean[] isSelected;
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			n = Integer.parseInt(in.readLine());
			
			company = new int[2];
			home = new int[2];
			customer = new int[n][2];
			
			st = new StringTokenizer(in.readLine(), " ");
			company[0] = Integer.parseInt(st.nextToken());
			company[1] = Integer.parseInt(st.nextToken());
			home[0] = Integer.parseInt(st.nextToken());
			home[1] = Integer.parseInt(st.nextToken());
			for (int i = 0; i < n; i++) {
				customer[i][0] = Integer.parseInt(st.nextToken());
				customer[i][1] = Integer.parseInt(st.nextToken());
			}
			
			numbers = new int[n];
			isSelected = new boolean[n];
			result = Integer.MAX_VALUE;
			permutation(0, 0);
			
			sb.append("#").append(tc).append(" ").append(result).append("\n");
		}
		
		System.out.println(sb);
	}

	private static void permutation(int cnt, int sum) {
		if (sum > result) return;
		
		if (cnt == n) {
			int dist = sum + Math.abs(customer[numbers[n - 1]][0] - home[0]) + Math.abs(customer[numbers[n - 1]][1] - home[1]);
			result = Math.min(result, dist);
			return;
		}
		
		for (int i = 0; i < n; i++) {
			if (isSelected[i]) continue;
			
			numbers[cnt] = i;
			isSelected[i] = true;
			
			if (cnt == 0) {
				permutation(cnt + 1, Math.abs(company[0] - customer[numbers[0]][0]) + Math.abs(company[1] - customer[numbers[0]][1]));
			}
			else {
				permutation(cnt + 1, sum + Math.abs(customer[numbers[cnt]][0] - customer[numbers[cnt - 1]][0]) + Math.abs(customer[numbers[cnt]][1] - customer[numbers[cnt - 1]][1]));
			}
			
			isSelected[i] = false;
		}
	}
}
