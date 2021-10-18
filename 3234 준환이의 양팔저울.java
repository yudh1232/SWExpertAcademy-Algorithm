import java.io.*;
import java.util.*;

public class Solution {

	static int n, result;
	static int[] data, numbers;
	static boolean[] isSelected, isSelected2;
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(in.readLine());
		
		for (int tc = 1; tc <= TC; tc++) {
			n = Integer.parseInt(in.readLine());
			data = new int[n];
			numbers = new int[n];
			isSelected = new boolean[n];
			isSelected2 = new boolean[n];
			
			st = new StringTokenizer(in.readLine(), " ");
			for (int i = 0; i < n; i++) {
				data[i] = Integer.parseInt(st.nextToken());
			}
			
			result = 0;
			
			permutation(0);
			
			sb.append("#").append(tc).append(" ").append(result).append("\n");
		}
		
		System.out.println(sb);
	}
	
	private static void permutation(int cnt) {
		
		if (cnt == n) {
			generateSubset(0, 0, 0);
			return;
		}
		
		for (int i = 0; i < n; i++) {
			if (isSelected[i]) continue;
			
			numbers[cnt] = data[i];
			isSelected[i] = true;
			
			permutation(cnt + 1);
			
			isSelected[i] = false;
		}
	}
	
	private static void generateSubset(int cnt, int leftSum, int rightSum) {
		if (leftSum < rightSum) return;
		
		if (cnt == n) {
			result++;
			return;
		}
		
		isSelected2[cnt] = true;
		generateSubset(cnt + 1, leftSum + numbers[cnt], rightSum);
		
		isSelected2[cnt] = false;
		generateSubset(cnt + 1, leftSum, rightSum + numbers[cnt]);
	}
	
}
