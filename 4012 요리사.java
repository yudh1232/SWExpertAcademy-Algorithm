import java.io.*;
import java.util.*;

public class Solution {

	static int[][] ingredient;
	static int n;
	static int[] numbers;
	static int taste;
	static List<Integer> tasteList;
			
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			n = Integer.parseInt(in.readLine());
			ingredient = new int[n][n];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(in.readLine(), " ");
				for (int j = 0; j < n; j++) {
					ingredient[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			numbers = new int[n / 2];
			tasteList = new ArrayList<Integer>();
			combination(0, 0);
			int result = Integer.MAX_VALUE;
			for (int i = 0; i < tasteList.size() / 2; i++) {
				int gap = Math.abs(tasteList.get(i) - tasteList.get(tasteList.size() - 1 - i));
				result = Math.min(result, gap);
			}
			
			sb.append("#").append(tc).append(" ").append(result).append("\n");
		}
		
		System.out.println(sb);
	}
	
	private static void combination(int cnt, int start) {
		if (cnt == n / 2) {
			taste = 0;
			for (int i : numbers) {
				for (int j : numbers) {
					taste += ingredient[i][j];
				}
			}
			tasteList.add(taste);
			return;
		}
		
		for (int i = start; i < n; i++) {
			numbers[cnt] = i;
			combination(cnt + 1, i + 1);
		}
	}
	
}
